package com.example.irfanfahmiwijaya.fixtubes;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by irfanfahmiwijaya on 07/12/2017.
 */


public class modulsholat_Activity extends Activity {


    PrayTime_modulsholat prayers;
    TextView mFajr, mSunrise, mDhuhr, mAsr, mSunset, mMaghrib, mIsha, mDate;
    RelativeLayout mlayoutDate;

    LocationManager locationManager;
    static final int REQUEST_LOCATION = 1;

    double timezone;

    /* lokasi yg saya gunakan di Bandung
     * lokasi ini akan menentukan kalkulasi waktu,.
     * setiap daerah akan berbeda*/

    double latitude;
    double longitude;


    int year, month, day;

    public String[] months = {"Januari", "Februari", "March", "April",
            "Mei", "Juni", "Juli", "Augustus", "September", "Oktober",
            "November", "Desember"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat);


        //double getlata = getIntent().getDoubleExtra();
        //latitude = getlata;


        getIntent().getStringExtra("data2");

        FusedLocationProviderClient mFusedLocation = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        mFusedLocation.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    double getLat = location.getLatitude();
                    double getLang = location.getLongitude();
                    // Do it all with location
                    Log.d("My Current location", "Lat : " + location.getLatitude() + " Long : " + location.getLongitude());
                    // Display in Toast
                    Toast.makeText(modulsholat_Activity.this,
                            "Lat : " + location.getLatitude() + " Long : " + location.getLongitude() + " Lokasi :" + location.getProvider(),
                            Toast.LENGTH_LONG).show();
                    latitude = getLat;
                    longitude = getLang;
                }
            }
        });



        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        

        mFajr		= findViewById(R.id.fajr_value);
        mSunrise	= findViewById(R.id.Sunrise_value);
        mDhuhr		= findViewById(R.id.Dhuhr_value);
        mAsr		= findViewById(R.id.Asr_value);
        //mSunset		= (TextView) findViewById(R.id.Sunset_value);
        mMaghrib	= findViewById(R.id.Maghrib_value);
        mIsha		= findViewById(R.id.Isha_value);
        mDate		= findViewById(R.id.date_value);
        mlayoutDate	= findViewById(R.id.layout_date);

        /* timezone juga mempengaruhi perbedaan waktu
         * untuk itu timezone sudah di set */
        timezone = (Calendar.getInstance().getTimeZone().getOffset(Calendar.getInstance().getTimeInMillis())) / (1000 * 60 * 60);

        prayers	 = new PrayTime_modulsholat();

        prayers.setTimeFormat(prayers.Time24); //format waktu
        prayers.setCalcMethod(prayers.Makkah); //kalulasi menurut
        prayers.setAsrJuristic(prayers.Shafii);
        prayers.setAdjustHighLats(prayers.MidNight);
        prayers.setTimeZone(prayers.getTimeZone());

        prayers.setFajrAngle(21.9);
        prayers.setIshaAngle(18.6);

        int[] offsets = { 0, 0, 0, 0, 0, 0, 0 }; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
        prayers.tune(offsets);

        Calendar cal	= Calendar.getInstance();
        year			= cal.get(Calendar.YEAR);
        month			= cal.get(Calendar.MONTH);
        day				= cal.get(Calendar.DAY_OF_MONTH);

        ShowPrayTime(year, month, day);

        mlayoutDate.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

    }

    private void ShowPrayTime(int year, int month, int day) {
		/* ArrayList ini yang nantinya akan di gunakan untuk
         * menampilkan jadwal sholat */


        ArrayList<String> prayerTimes = prayers.getPrayerTimes(year, month, day, latitude, longitude, timezone);
//        ArrayList<String> prayerNames = prayers.getTimeNames();

        mFajr.setText(prayerTimes.get(0));
        mSunrise.setText(prayerTimes.get(1));
        mDhuhr.setText(prayerTimes.get(2));
        mAsr.setText(prayerTimes.get(3));
        mMaghrib.setText(prayerTimes.get(4));
        mIsha.setText(prayerTimes.get(6));

        mDate.setText(day + " " + months[month] + " " + year);
    }

    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            ShowPrayTime(selectedYear, selectedMonth, selectedDay);

            year	= selectedYear;
            month	= selectedMonth;
            day		= selectedDay;

        }
    };


}
