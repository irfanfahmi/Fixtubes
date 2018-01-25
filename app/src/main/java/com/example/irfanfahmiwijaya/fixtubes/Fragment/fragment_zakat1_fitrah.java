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


public class fragment_zakat1_fitrah extends Fragment {

    public fragment_zakat1_fitrah() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_zakat, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        final EditText hrgbrs = (EditText) view.findViewById(R.id.hrgbrs);
        final TextView hsl = (TextView) view.findViewById(R.id.hsl);
        Button htg = (Button) getActivity().findViewById(R.id.htg);

        htg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double A = Double.parseDouble(hrgbrs.getText().toString());
                int hasil = (int) (A/100 * 2.5) *100;
                hsl.setText("Zakat yang harus anda keluarkan Adalah : Rp."+hasil+",-");
            }
        });

    }


}
