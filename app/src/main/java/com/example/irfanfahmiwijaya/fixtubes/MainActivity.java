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

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent kliksholat = new Intent(MainActivity.this,modulsholat_Activity.class);
        startActivity(kliksholat);
    }


    public void lokasimasjid(View view) {
        Intent lokasimasjid = new Intent(MainActivity.this,modullokasimasjid_Activity.class);
        startActivity(lokasimasjid);
    }

    public void kliklokasi(MenuItem item) {
        Intent lokasimasjid = new Intent(MainActivity.this,modullokasimasjid_Activity.class);
        startActivity(lokasimasjid);
    }

    public void klikkajian (View view) {
        Intent klikkajian = new Intent(MainActivity.this,modulkajian_Activity.class);
        startActivity(klikkajian);
    }

    public void klikkajian(MenuItem item) {
        Intent klikkajian = new Intent(MainActivity.this,modulkajian_Activity.class);
        startActivity(klikkajian);
    }

    public void klikdoa(View view) {
        Intent klikdoa = new Intent(MainActivity.this,moduldoa_Activity.class);
        startActivity(klikdoa);
    }

    public void klikdoa(MenuItem item) {
        Intent klikdoa = new Intent(MainActivity.this,moduldoa_Activity.class);
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
        Intent klikinputlokasi = new Intent(MainActivity.this,modullokasi_Activity.class);
        startActivity(klikinputlokasi);
    }
}