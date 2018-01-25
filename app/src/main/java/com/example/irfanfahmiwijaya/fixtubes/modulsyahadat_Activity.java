package com.example.irfanfahmiwijaya.fixtubes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by irfanfahmiwijaya on 07/12/2017.
 */


public class modulsyahadat_Activity extends Activity {
    TextView isiteks;
    TextView isiteks2;
    Button btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syahadat);

        isiteks = (TextView) findViewById(R.id.bacaan_syahadat);
        isiteks2 = (TextView) findViewById(R.id.arti_syahadat);
        btnShare = (Button) findViewById(R.id.shareit);
        btnShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String status=isiteks.getText().toString();
                String status2=isiteks2.getText().toString();
                shareIt(status);
                shareIt(status2);
            }

        });
    }
    public void shareIt(String pmessage) {
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Syahadat");
        i.putExtra(Intent.EXTRA_TEXT, pmessage);
        startActivity(Intent.createChooser(i,"Syahadat"));
    }

    }

