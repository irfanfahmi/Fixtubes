package com.example.irfanfahmiwijaya.fixtubes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by irfanfahmiwijaya on 18/01/2018.
 */

public class zakat_maal_binatang_activity extends Activity {
    String a;
    RadioGroup rbinatang;
    RadioButton rsapi;
    RadioButton rkambing;
    EditText jml_ternak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_maal_binatang);

        final RadioGroup rbinatang= (RadioGroup) findViewById(R.id.rbinatang);
        final RadioButton rsapi = (RadioButton) findViewById(R.id.rsapi);
        rsapi.setChecked(true);
        final RadioButton rkambing = (RadioButton) findViewById(R.id.rkambing);
        rkambing.setChecked(true);


        Button htg = (Button) findViewById(R.id.hitung);
        jml_ternak = (EditText) findViewById(R.id.jml_ternak);
        final TextView tmpl = (TextView) findViewById(R.id.tampil);

        htg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton choose = (RadioButton) findViewById(rbinatang.getCheckedRadioButtonId());
                String pilihan;
                if (choose != null){
                    pilihan = (String) choose.getText();
                    String a = "";
                    int A = Integer.parseInt(String.valueOf(jml_ternak.getText()));

                    if(pilihan.equals("Sapi")){
                        if (A < 30) a = "Belum mencapai nisabnya";
                        else if (A >= 30 && A <= 39) a = "1 ekor tabi’ atau tabi’ah";
                        else if (A >= 40 && A <= 59 ) a = "1 ekor musinnah";
                        else if (A >= 60 && A <= 69 ) a = "2 ekor tabi’ atau 2 ekor tabi’ah";
                        else if (A >= 70 && A <= 79) a = "1 ekor tabi dan 1 ekor musinah";
                        else if (A >= 80 && A <= 89) a = "2 ekor musinnah";
                        else if (A >= 90 && A <= 99) a = "3 ekor tabi’";
                        else if (A >= 100) a = "2 ekor tabi’ dan 1 ekor musinnah";
                        tmpl.setText(a);
                    }else{
                        if (A < 40) a = "Belum mencapai nisabnya";
                        else if (A >=  40 && A <=119) a = "1 ekor Kambing";
                        else if (A >= 120 && A <= 200) a = "2 ekor Kambing";
                        else if (A >= 201 && A <= 299) a = "3 ekor Kambing";
                        else if (A >= 300) a = "Setiap 100, 1 ekor kambing";
                        tmpl.setText(a);

                    }
                }

            }
        });
    }
}
