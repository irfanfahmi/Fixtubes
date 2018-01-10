package com.example.irfanfahmiwijaya.fixtubes;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Created by irfanfahmiwijaya on 07/12/2017.
 */

public class modullokasimasjid extends FragmentActivity implements LocationListener {

    private String API_KEY_SERVER = "AIzaSyCVCsKGmpAOwjaA76dkBUjO6NPNcPA-Uo4";

    private GoogleMap mGoogleMap;
    private ProgressDialog progressDialog;
    private double mLatitude = 0;
    private double mLongitude = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button btnFind = (Button) findViewById(R.id.btn_masjid);


        // cek google play services
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
        if (status != ConnectionResult.SUCCESS) {
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();
        } else {
            SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapi);
            fragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mGoogleMap = googleMap;
                    initMap();
                }
            });

            //menampilkan info tentang apa yang di cari mengambil data dari google
            btnFind.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                    sb.append("location=" + mLatitude + "," + mLongitude);
                    sb.append("&radius=5000");
                    //type bisa diganti dngan food & mosque, restaurant tergantung mencari apa
                    sb.append("&types=mosque");
                    sb.append("&sensor=true");
                    sb.append("&key=" + API_KEY_SERVER);

                    new PlacesTask().execute(sb.toString());
                }
            });




        }

    }

    //set permission
    private void initMap() {
        if (mGoogleMap != null) {
            mGoogleMap.setMyLocationEnabled(true);

            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, true);
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
            Location location = locationManager.getLastKnownLocation(provider);

            if (location != null) {
                onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(provider, 20000, 0, this);
        }
    }


    //download json data from url
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    @Override
    public void onLocationChanged(Location location) {
        mLatitude = location.getLatitude();
        mLongitude = location.getLongitude();
        LatLng latLng = new LatLng(mLatitude, mLongitude);

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    //download Google Places
    private class PlacesTask extends AsyncTask<String, Integer, String> {

        String data = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(modullokasimasjid.this);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Loading Peta");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... url) {
            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            new ParserTask().execute(result);
        }

    }

    //parse the Google Places in JSON format
    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>> {

        JSONObject jObject;

        @Override
        protected List<HashMap<String, String>> doInBackground(String... jsonData) {

            List<HashMap<String, String>> places = null;
            ParserJSONPlace parserJSONPlace = new ParserJSONPlace();

            try {
                jObject = new JSONObject(jsonData[0]);
                places = parserJSONPlace.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return places;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, String>> list) {

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            // clear all map sebelumnya
            mGoogleMap.clear();

            for (int i = 0; i < list.size(); i++) {
                MarkerOptions markerOptions = new MarkerOptions();
                HashMap<String, String> hmPlace = list.get(i);

                double lat = Double.parseDouble(hmPlace.get("lat"));
                double lng = Double.parseDouble(hmPlace.get("lng"));

                String nama = hmPlace.get("place_name");
                String namaJln = hmPlace.get("vicinity");

                LatLng latLng = new LatLng(lat, lng);

                markerOptions.position(latLng);
                markerOptions.title(nama + " : " + namaJln);

                mGoogleMap.addMarker(markerOptions);
            }
        }
    }
}
