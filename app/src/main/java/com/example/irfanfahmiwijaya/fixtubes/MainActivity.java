package com.example.irfanfahmiwijaya.fixtubes;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irfanfahmiwijaya.fixtubes.Database.DBHelper;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private MenuItem btninputlokasi;
    private Button btnLogout;
    private TextView s;
    public static String db = "baitulmuslim1.db";
    DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        s = (TextView) findViewById(R.id.greeting);
        //btninputlokasi = (MenuItem) findViewById(R.id.inputlokasimasjid);

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
////
////                MainActivity.start(MainActivity.this);
////                MainActivity.this.finish();
//                }
//        });





        toolbar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        // Find our drawer view
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.open,  R.string.close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the togg le state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void kliksholat(MenuItem item) {
        Intent kliksholat = new Intent(MainActivity.this,modulsholat_Activity.class);
        startActivity(kliksholat);
    }

    public void kliksyahadat(MenuItem item) {
        Intent kliksyahadat = new Intent(MainActivity.this,modulsyahadat_Activity.class);
        startActivity(kliksyahadat);
    }


    public void kliksyahadat(View view) {
        Intent kliksyahadat = new Intent(MainActivity.this,modulsyahadat_Activity.class);
        startActivity(kliksyahadat);
    }

    public void kliksholat(View view) {
        Intent kliksholat = new Intent(MainActivity.this,modulsholat_Activity_1.class);
        startActivity(kliksholat);
    }


    public void lokasimasjid(View view) {
        Intent lokasimasjid = new Intent(MainActivity.this,modul_tampil_lokasi_masjid_Activity.class);
        startActivity(lokasimasjid);
    }

    public void kliklokasi(MenuItem item) {
        Intent kliklokasi = new Intent(MainActivity.this,modullokasimasjid_Activity.class);
        startActivity(kliklokasi);
    }

    public void klikkajian (View view) {
        Intent klikkajian = new Intent(MainActivity.this,VideoListKajianActivity.class);
        startActivity(klikkajian);
    }

    public void klikkajian(MenuItem item) {
        Intent klikkajian = new Intent(MainActivity.this,modulkajian_Activity.class);
        startActivity(klikkajian);
    }

    public void klikdoa(View view) {
        dbHelper = new DBHelper(getApplicationContext(), db);
        if (!dbHelper.isDataBaseExists()) {
            Toast.makeText(getApplicationContext(), "DB Tidak ada", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
//            this.finish();
        } else {
            Toast.makeText(getApplicationContext(), "DB Ada", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, modul_doa_baru.class);
            startActivity(i);
//            this.finish();
        }

//        Intent klikdoa = new Intent(MainActivity.this,modul_doa_baru.class);
//        startActivity(klikdoa);
    }

    public void klikdoa(MenuItem item) {
        Intent klikdoa = new Intent(MainActivity.this,modul_doa_baru.class);
        startActivity(klikdoa);
    }

    public void klikzakat(MenuItem item) {
        Intent klikzakat = new Intent(MainActivity.this,modulzakat_Activity.class);
        startActivity(klikzakat);
    }

    public void klikzakat(View view) {
        Intent klikzakat = new Intent(MainActivity.this,modulzakat_Activity.class);
        startActivity(klikzakat);
    }


    public void klikpuasa(View view) {
        Intent klikpuasa = new Intent(MainActivity.this,modulpuasa_Activity.class);
        startActivity(klikpuasa);
    }

    public void klikhaji(View view) {
        Intent klikhaji = new Intent(MainActivity.this,modulhaji_Activity.class);
        startActivity(klikhaji);
    }

    public void klikinputlokasi(MenuItem item) {
        Intent klikinputlokasi = new Intent(MainActivity.this,modul_input_lokasi_masjid_Activity.class);
        startActivity(klikinputlokasi);

        //logika if (jika sudah login maka langsung inten masuk jika tidak tampil tost anda belum login)
    }

    public void kliktasbih(View view) {
        Intent kliktasbih = new Intent(MainActivity.this,modultasbih_Activity.class);
        startActivity(kliktasbih);
    }

    public void kliklive(View view) {
        Intent kliklive = new Intent(MainActivity.this,modul_live.class);
        startActivity(kliklive);
    }

    public void klikinputpenginapan(MenuItem item) {
        Intent klikinputpenginapan = new Intent(MainActivity.this,modul_input_lokasi_penginapan_Activity.class);
        startActivity(klikinputpenginapan);
    }

    public void klikinputrestoran(MenuItem item) {
        Intent klikinputrestoran = new Intent(MainActivity.this,modul_input_lokasi_restoran_Activity.class);
        startActivity(klikinputrestoran);
    }

    public void klikpenginapan(View view) {
        Intent klikpenginapan = new Intent(MainActivity.this,modul_tampil_lokasi_penginapan_Activity.class);
        startActivity(klikpenginapan);
    }

    public void klikrestoran(View view) {
        Intent klikrestoran = new Intent(MainActivity.this,modul_tampil_lokasi_restoran_Activity.class);
        startActivity(klikrestoran);
    }

    public void klikkiblat(View view) {
        Intent klikkiblat = new Intent(MainActivity.this,modulkiblat_Activity.class);
        startActivity(klikkiblat);
    }



//    public void kliklogin(View view) {
//        Intent kliklogin = new Intent(MainActivity.this,LoginActivity.class);
//        startActivity(kliklogin);
//
//    }




//        //clear sesion
//    void logoutAct() {
//        PrefUtil.clear(this);
//    }

}