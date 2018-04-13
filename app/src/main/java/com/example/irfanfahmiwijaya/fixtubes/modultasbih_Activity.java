package com.example.irfanfahmiwijaya.fixtubes;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class modultasbih_Activity extends AppCompatActivity {
    TextView text1;
    Button tambah,reset;

    int angka = 0;
    int batas = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modultasbih);

        // Untuk Mendapatkan Vibrate dari Smartphone
        final Vibrator vibe = (Vibrator) this
                .getSystemService(Context.VIBRATOR_SERVICE);

        text1 = (TextView) findViewById(R.id.text1);
        tambah = (Button) findViewById(R.id.tambah);
        reset = (Button) findViewById(R.id.reset);

        text1.setEnabled(false);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka = 0;
                text1.setText("" + angka);
                tambah.setEnabled(true);
            }
        });


        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (angka != batas) {
                    angka++;
                    vibe.vibrate(80);

                    if (angka == batas) {
                        tambah.setEnabled(false);

                        Toast t = Toast.makeText(getApplicationContext(),
                                "WIRIDAN ANDA SUDAH SELESAI",
                                Toast.LENGTH_SHORT);
                        t.show();

                    }
                }

                text1.setText("" + angka);
            }

        });


    }
}
