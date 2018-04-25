package com.example.irfanfahmiwijaya.fixtubes;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.irfanfahmiwijaya.fixtubes.Adapter.ApiClient;
import com.example.irfanfahmiwijaya.fixtubes.Adapter.ApiService;
import com.example.irfanfahmiwijaya.fixtubes.Adapter.ListLocationModelMasjid;
import com.example.irfanfahmiwijaya.fixtubes.Adapter.LocationModelMasjid;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class modul_tampil_lokasi_masjid_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<LocationModelMasjid> mListMarker = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_input_lokasi_masjid_);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);



        getAllDataLocationLatLng();
    }

    /**
     * method ini digunakan menampilkan data marker dari database
     */
    private void getAllDataLocationLatLng() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListLocationModelMasjid> call = apiService.getAllLocation();
        call.enqueue(new retrofit2.Callback<ListLocationModelMasjid>() {
            @Override
            public void onResponse(Call<ListLocationModelMasjid> call, retrofit2.Response<ListLocationModelMasjid> response) {
                dialog.dismiss();
                mListMarker = response.body().getmData();
                initMarker(mListMarker);
            }

            @Override
            public void onFailure(Call<ListLocationModelMasjid> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(modul_tampil_lokasi_masjid_Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    /**
     * Method ini digunakan untuk menampilkan semua marker di maps dari data yang didapat dari database
     * @param listData
     */
    private void initMarker(List<LocationModelMasjid> listData){
        //iterasi semua data dan tampilkan markernya
        for (int i=0; i<mListMarker.size(); i++){
            //set latlng nya
            LatLng location = new LatLng(Double.parseDouble(mListMarker.get(i).getLatutide()), Double.parseDouble(mListMarker.get(i).getLongitude()));
            //tambahkan markernya
            mMap.addMarker(new MarkerOptions().position(location).title(mListMarker.get(i).getNama_masjid()));
            //set latlng index ke 0
            LatLng latLng = new LatLng(Double.parseDouble(mListMarker.get(0).getLatutide()), Double.parseDouble(mListMarker.get(0).getLongitude()));
            //lalu arahkan zooming ke marker index ke 0
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude,latLng.longitude), 13.0f));
        }
    }

}
