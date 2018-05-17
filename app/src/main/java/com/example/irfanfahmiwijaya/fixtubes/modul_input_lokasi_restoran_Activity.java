package com.example.irfanfahmiwijaya.fixtubes;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.irfanfahmiwijaya.fixtubes.Adapter.MyCommand;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageBase64;
import com.kosalgeek.android.photoutil.ImageLoader;
import com.kosalgeek.android.photoutil.PhotoLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class modul_input_lokasi_restoran_Activity extends Activity {

    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;

    ImageView ivGallery, ivFoto;
    EditText namarestoran,latitude,longitude,alamatrestoran;
    CameraPhoto cameraPhoto;
    Button ivCari;

    GalleryPhoto galleryPhoto;

    final int GALLERY_REQUEST = 1201;
    final int CAMERA_REQUEST = 13321;

    final String TAG = this.getClass().getSimpleName();

    LinearLayout linearMainr;

    ArrayList<String> imageList = new ArrayList<>();


    // konstanta untuk mendeteksi hasil balikan dari place picker
    private int PLACE_PICKER_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_input_lokasi_restoran_);

        FloatingActionButton feb_restoran = (FloatingActionButton) findViewById(R.id.upload_restoran);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        linearMainr = (LinearLayout)findViewById(R.id.linearMainr);

        galleryPhoto = new GalleryPhoto(getApplicationContext());

        ivGallery = (ImageView)findViewById(R.id.ivGalleryrestoran);
        ivFoto = (ImageView)findViewById(R.id.ivFotorestoran);
        ivCari = (Button) findViewById(R.id.carilokasir);


        cameraPhoto = new CameraPhoto(getApplicationContext());

        namarestoran = (EditText)findViewById(R.id.namarestoran);
        alamatrestoran = (EditText)findViewById(R.id.alamatrestoran);
        latitude = (EditText)findViewById(R.id.latitude);
        longitude = (EditText)findViewById(R.id.longitude);

        ivGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = galleryPhoto.openGalleryIntent();
                startActivityForResult(in, GALLERY_REQUEST);
            }
        });

        ivCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // membuat Intent untuk Place Picker
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    //menjalankan place picker
                    startActivityForResult(builder.build(modul_input_lokasi_restoran_Activity.this), PLACE_PICKER_REQUEST);

                    // check apabila <a title="Solusi Tidak Bisa Download Google Play Services di Android" href="http://www.twoh.co/2014/11/solusi-tidak-bisa-download-google-play-services-di-android/" target="_blank">Google Play Services tidak terinstall</a> di HP
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });



        ivFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivityForResult(cameraPhoto.takePhotoIntent(), CAMERA_REQUEST);
                    cameraPhoto.addToGallery();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),
                            "Something Wrong while taking photos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final MyCommand myCommand = new MyCommand(getApplicationContext());

        feb_restoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(String imagePath: imageList){
                    try {
                        Bitmap bitmap = PhotoLoader.init().from(imagePath).requestSize(512, 512).getBitmap();
                        final String encodedString = ImageBase64.encode(bitmap);


                        String url = "http://192.168.127.1/imageuploadtest/upload_data_restoran.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Error while uploading image", Toast.LENGTH_SHORT).show();
                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("foto_restoran", encodedString);
                                params.put("sertifakat_restoran", encodedString);
                                params.put("nama_restoran", namarestoran.getText().toString());
                                params.put("latitude", latitude.getText().toString());
                                params.put("longitude", longitude.getText().toString());
                                params.put("alamat_restoran", alamatrestoran.getText().toString());
                                return params;
                            }
                        };

                        myCommand.add(stringRequest);

                    } catch (FileNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "Error while loading image", Toast.LENGTH_SHORT).show();
                    }
                }
                myCommand.execute();

            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == GALLERY_REQUEST){
                galleryPhoto.setPhotoUri(data.getData());
                String photoPath = galleryPhoto.getPath();
                imageList.add(photoPath);
                Log.d(TAG, photoPath);
                try {
                    Bitmap bitmap = PhotoLoader.init().from(photoPath).requestSize(512, 512).getBitmap();

                    ImageView imageView = new ImageView(getApplicationContext());
                    LinearLayout.LayoutParams layoutParams =
                            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setPadding(0, 0, 0, 10);
                    imageView.setAdjustViewBounds(true);
                    imageView.setImageBitmap(bitmap);

                    linearMainr.addView(imageView);

                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Error while loading image", Toast.LENGTH_SHORT).show();
                }
            }else if(requestCode == CAMERA_REQUEST){
                String photoPath = cameraPhoto.getPhotoPath();
                //ambil nilai lokasi gambar
                imageList.add(photoPath);
                Log.d(TAG, photoPath);
                try {
                    Bitmap bitmap = ImageLoader.init().from(photoPath).requestSize(512, 512).getBitmap();
                    //menampilkan image yang udah di pilih

                    //imageList.setImageBitmap(bitmap);

                    ImageView imageView = new ImageView(getApplicationContext());
                    LinearLayout.LayoutParams layoutParams =
                            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setPadding(0, 0, 0, 10);
                    imageView.setAdjustViewBounds(true);
                    imageView.setImageBitmap(bitmap);

                    linearMainr.addView(imageView);

                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(),
                            "Something Wrong while loading photos", Toast.LENGTH_SHORT).show();
                }

            }
        }

        // menangkap hasil balikan dari Place Picker, dan menampilkannya pada TextView
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsglat = String.format(
                        "Latlng %s \n",place.getLatLng().latitude+" "+place.getLatLng().longitude);

                namarestoran.setText(place.getName());
                latitude.setText(""+place.getLatLng().latitude);
                longitude.setText(""+place.getLatLng().longitude);
                alamatrestoran.setText(place.getAddress());

            }
        }
    }



    void getLocation() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED & ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        }else{
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null){
                double latti = location.getLatitude();
                double longi = location.getLongitude();

                ((EditText)findViewById(R.id.latitude)).setText(""+latti);
                ((EditText)findViewById(R.id.longitude)).setText(""+longi);
            } else {
                ((EditText)findViewById(R.id.latitude)).setText("Unable to find correct location.");
                ((EditText)findViewById(R.id.longitude)).setText("Unable to find correct location. ");
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}
