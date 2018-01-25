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

public class zakat_maal_emas_activity extends Activity {
    String a;
    RadioGroup rpilih;
    RadioButton remas;
    RadioButton rperak;
    EditText jml_gram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_maal_emas);

        final RadioGroup rpilih= (RadioGroup) findViewById(R.id.rpilih);
        final RadioButton remas = (RadioButton) findViewById(R.id.remas);
        remas.setChecked(true);
        final RadioButton rperak = (RadioButton) findViewById(R.id.rperak);
        rperak.setChecked(true);

        Button htg = (Button) findViewById(R.id.hitung);
        jml_gram = (EditText) findViewById(R.id.jml_gram);
        final TextView tmpl = (TextView) findViewById(R.id.tampil);

        htg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton choose = (RadioButton) findViewById(rpilih.getCheckedRadioButtonId());
                String pilihan;
                if (choose != null){
                    pilihan = (String) choose.getText();
                    String a = "";
                    double hasil;
                    Double A = Double.parseDouble(String.valueOf(jml_gram.getText()));

                    if(pilihan.equals("Emas")){
                        if (A < 85) {
                            a = "Belum mencapai nisabnya emas";
                            tmpl.setText(a);
                        }else{
                            hasil=((A/100 *0.25) * 10);
                            tmpl.setText("zakat yang di bayar : "+hasil+" gram");
                        }

                    }else{
                        if (A < 595) {
                            a = "Belum mencapai nisabnya perak";
                            tmpl.setText(a);
                        }else{
                            hasil= ((A/100 *0.25) * 10);
                            tmpl.setText("zakat yang di bayar : "+hasil+" gram");
                        }

                    }
                }

            }
        });

    }
}
