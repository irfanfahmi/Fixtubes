package com.example.irfanfahmiwijaya.fixtubes.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.irfanfahmiwijaya.fixtubes.R;
import com.example.irfanfahmiwijaya.fixtubes.zakat_maal_binatang_activity;
import com.example.irfanfahmiwijaya.fixtubes.zakat_maal_emas_activity;
import com.example.irfanfahmiwijaya.fixtubes.zakat_maal_pertanian_activity;

public class fragment_zakat2_maal extends Fragment {


    private Button btngotoz1;
    private Button btngotoz2;
    private Button btngotoz3;

    public fragment_zakat2_maal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_zakat2, container, false);
    }

    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        btngotoz1 = (Button) view.findViewById(R.id.z1);
        btngotoz2 = (Button) view.findViewById(R.id.z2);
        btngotoz3 = (Button) view.findViewById(R.id.z3);


        btngotoz1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), zakat_maal_binatang_activity.class);
                getActivity().startActivity(intent);

            }

        });

        btngotoz2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), zakat_maal_emas_activity.class);
                getActivity().startActivity(intent);

            }

        });

        btngotoz3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), zakat_maal_pertanian_activity.class);
                getActivity().startActivity(intent);

            }

        });
    }
}
