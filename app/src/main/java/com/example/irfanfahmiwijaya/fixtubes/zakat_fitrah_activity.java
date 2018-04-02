package com.example.irfanfahmiwijaya.fixtubes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class zakat_fitrah_activity extends AppCompatActivity {
    EditText hrgbrs;
    Double hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_fitrah_activity);
        final EditText hrgbrs = (EditText) this.findViewById(R.id.hrgbrs);
        final TextView hsl = (TextView) this.findViewById(R.id.hsl);
        final Button htg = (Button) this.findViewById(R.id.htg);

        htg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String str = hrgbrs.getText().toString();

                if (str.trim().equals("") ) {
                    hrgbrs.setError("Harus diisi !");
                    //Toast.makeText(getActivity(),"Harus Diisi !",Toast.LENGTH_SHORT).show();
                } else {

                    Double A = Double.parseDouble(String.valueOf(hrgbrs.getText()));

                   // double B = Double.parseDouble(hrgbrs.getText().toString());
                    double hasil = (A/100 * 2.5) *100;
                    hsl.setText("Zakat yang harus anda keluarkan Adalah : Rp."+hasil+",-");
                }
            }
        });
    }


}
