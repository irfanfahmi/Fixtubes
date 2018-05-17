package com.example.irfanfahmiwijaya.fixtubes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.irfanfahmiwijaya.fixtubes.Database.DBHelper;

import java.io.IOException;


public class splashscreen extends Activity {
    //Set waktu lama splashscreen
    public static String db = "baitulmuslim1.db";
    DBHelper dbHelper;
    private static int splashInterval = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);

        dbHelper = new DBHelper(getApplicationContext(), db);





        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                if (!dbHelper.isDataBaseExists()) {
                    Toast.makeText(getApplicationContext(), "DB Doesn't Exists", Toast.LENGTH_SHORT).show();
                    importDB();
                    Intent i = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(i);
                    this.finish();
                } else {
                    Toast.makeText(getApplicationContext(), "DB Exists", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(i);
                    this.finish();
                }


                //jeda selesai Splashscreen
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub
            }
        }, splashInterval);
    }
    ;
    public void importDB(){
        try {
            dbHelper.importDataBaseFromAssets();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
