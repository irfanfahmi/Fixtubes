package com.example.irfanfahmiwijaya.fixtubes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.irfanfahmiwijaya.fixtubes.R;

public class fragment_zakat3_profesi extends Fragment {
    public fragment_zakat3_profesi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_zakat3, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        final EditText totalpenghasilan = (EditText) view.findViewById(R.id.totalpenghasilan);
        final EditText hargabrs = (EditText) view.findViewById(R.id.hargabrs);
        final TextView hsl = (TextView) view.findViewById(R.id.hsl);
        Button htg = (Button) getActivity().findViewById(R.id.hitung);

        htg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String in1 = totalpenghasilan.getText().toString();
                String in2 = hargabrs.getText().toString();

                if (in1.trim().equals("") && in2.trim().equals("") ) {
                    totalpenghasilan.setError("Harus diisi !");
                    hargabrs.setError("Harus diisi !");
                    //Toast.makeText(getActivity(),"Harus Diisi !",Toast.LENGTH_SHORT).show();
                }else {

                    double A = Double.parseDouble(totalpenghasilan.getText().toString());
                    double B = Double.parseDouble(hargabrs.getText().toString());
                    int nisab = (int) (520 * B);

                    if (A<nisab){
                        hsl.setText("Belum Mencapai Nisabnya");
                    }else{
                        int hasil = (int) (A/100 * 2.5);
                        hsl.setText("Zakat yang harus anda keluarkan Adalah : Rp."+hasil+",-");
                    }

                }


            }
        });

    }

}
