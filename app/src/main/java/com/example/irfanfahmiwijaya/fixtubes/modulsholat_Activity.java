package com.example.irfanfahmiwijaya.fixtubes;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by irfanfahmiwijaya on 07/12/2017.
 */


public class modulsholat_Activity extends Activity {



    PrayTime_modulsholat prayers;
    TextView mFajr, mSunrise, mDhuhr, mAsr, mSunset, mMaghrib, mIsha, mDate;
    RelativeLayout mlayoutDate;



    double timezone;

    /* lokasi yg saya gunakan di Bandung
     * lokasi ini akan menentukan kalkulasi waktu
     * setiap daerah akan berbeda*/
    double latitude = -6.903429;
    double longitude = 107.5030708;


    int year, month, day;

    public String[] months = { "Januari", "Februari", "March", "April",
            "Mei", "Juni", "Juli", "Augustus", "September", "Oktober",
            "November", "Desember" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat);


        mFajr		= (TextView) findViewById(R.id.fajr_value);
        mSunrise	= (TextView) findViewById(R.id.Sunrise_value);
        mDhuhr		= (TextView) findViewById(R.id.Dhuhr_value);
        mAsr		= (TextView) findViewById(R.id.Asr_value);
        //mSunset		= (TextView) findViewById(R.id.Sunset_value);
        mMaghrib	= (TextView) findViewById(R.id.Maghrib_value);
        mIsha		= (TextView) findViewById(R.id.Isha_value);
        mDate		= (TextView) findViewById(R.id.date_value);
        mlayoutDate	= (RelativeLayout) findViewById(R.id.layout_date);

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

    public void klikkiblat(View view) {
        Intent klikkiblat = new Intent(modulsholat_Activity.this,modulkiblat_Activity.class);
        startActivity(klikkiblat);
    }
}
