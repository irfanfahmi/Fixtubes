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
 * Created by irfanfahmiwijaya on 19/01/2018.
 */

public class zakat_maal_pertanian_activity extends Activity {

    String a;
    RadioGroup rpertanian;
    RadioButton rhj;
    RadioButton rma;
    EditText jml_kg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_maal_pertanian);

        final RadioGroup rpertanian= (RadioGroup) findViewById(R.id.rpertanian);
        final RadioButton rhj = (RadioButton) findViewById(R.id.rhj);
        rhj.setChecked(true);
        final RadioButton rma = (RadioButton) findViewById(R.id.rma);
        rma.setChecked(true);

        Button htg = (Button) findViewById(R.id.hitung);
        jml_kg= (EditText) findViewById(R.id.jml_kg);
        final TextView tmpl = (TextView) findViewById(R.id.tampil);

        htg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton choose = (RadioButton) findViewById(rpertanian.getCheckedRadioButtonId());
                String pilihan;
                if (choose != null){
                    pilihan = (String) choose.getText();
                    String a = "";
                    int hasil;
                    Double A = Double.parseDouble(String.valueOf(jml_kg.getText()));

                    if(pilihan.equals("Hujan/Mata air")){
                        if (A < 900) {
                            a = "Belum mencapai nisabnya";
                            tmpl.setText(a);
                        }else{
                            hasil= (int) (A/100 *10);
                            tmpl.setText("zakat yang harus di bayar sebesar : "+hasil+" Kg dari hasil panen");
                        }

                    }else{
                        if (A < 900) {
                            a = "Belum mencapai nisabnya";
                            tmpl.setText(a);
                        }else{
                            hasil= (int) (A/100 *5);
                            tmpl.setText("zakat yang harus di bayar sebesar : "+hasil+" Kg dari hasil panen");
                        }

                    }
                }

            }
        });

    }
}
