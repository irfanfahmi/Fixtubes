package com.example.irfanfahmiwijaya.fixtubes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class modullokasi_Activity extends AppCompatActivity {

    private Button btPlacesAPI;
    private EditText tvlatitude;
    private EditText tvlongitude;
    private EditText tvalamat;
    private EditText tvnama;
    // konstanta untuk mendeteksi hasil balikan dari place picker
    private int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modullokasi_);

        tvnama = (EditText) findViewById(R.id.nama);
        tvalamat = (EditText) findViewById(R.id.alamat);
        tvlatitude = (EditText) findViewById(R.id.lat);
        tvlongitude = (EditText) findViewById(R.id.longi);

        btPlacesAPI = (Button)findViewById(R.id.bt_ppicker);
        btPlacesAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // membuat Intent untuk Place Picker
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    //menjalankan place picker
                    startActivityForResult(builder.build(modullokasi_Activity.this), PLACE_PICKER_REQUEST);

                    // check apabila <a title="Solusi Tidak Bisa Download Google Play Services di Android" href="http://www.twoh.co/2014/11/solusi-tidak-bisa-download-google-play-services-di-android/" target="_blank">Google Play Services tidak terinstall</a> di HP
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // menangkap hasil balikan dari Place Picker, dan menampilkannya pada TextView
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                String nama= place.getName().toString();
                String alamat = place.getAddress().toString();
                double latitude = place.getLatLng().latitude;
                double longitude = place.getLatLng().longitude;
                tvnama.setText(nama);
                tvalamat.setText(alamat);
                tvlatitude.setText(""+latitude);
                tvlongitude.setText(""+longitude);
            }
        }
    }
}
