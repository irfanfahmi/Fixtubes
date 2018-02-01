package com.example.irfanfahmiwijaya.fixtubes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.irfanfahmiwijaya.fixtubes.Adapter.ExpandableListPuasaAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by irfanfahmiwijaya on 01/02/2018.
 */

public class modulpuasa_Activity extends AppCompatActivity{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puasa);

        listView = (ExpandableListView) findViewById(R.id.lvExpandable);
        initData();
        listAdapter = new ExpandableListPuasaAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Pengertian Puasa");
        listDataHeader.add("Macam Puasa");
        listDataHeader.add("Dalil & Hukumnya");
        listDataHeader.add("Syarat Puasa");


        List<String> pengertianpuasa = new ArrayList<>();
        pengertianpuasa.add("Kata puasa dalam bahasa Arab disebut Shaum atau Shiyam, artinya secara bahasa adalah “menahan”.\n" +
                "Definisi puasa dalam syariat adalah beribadah kepada Allah Ta’ala dengan cara menahan diri dari segala hal yang membatalkannya yang dimulai sejak terbit fajar Shubuh hingga tenggelamnya matahari.\n" +
                "Adapun arti kata Ramadhan secara bahasa diambil dari kata ar-Ramd [arab: الرمض] yang artinya panasnya batu karena terkena terik matahari. Makna bulan Ramadhan adalah (يرمض الذنوب ) artinya membakar dosa-dosa, yaitu dengan melakukan amalan-amalan shalih.");

        List<String> macampuasa = new ArrayList<>();
        macampuasa.add("Puasa sendiri terbagi menjadi dua macam, yaitu puasa wajib dan puasa sunnah. Adapun puasa wajib ada tiga yaitu: puasa Ramadhan \n " +
                "puasa kaffarah (puasa tebusan), dan puasa nadzar");

        List<String> dalilpuasa = new ArrayList<>();
        dalilpuasa.add("Hukum puasa Ramadhan adalah fardhu ‘ain, yaitu wajib bagi setiap individu muslim untuk melaksanakannya. Dalil wajibnya puasa Ramadhan adalah firman Allah ta’ala:\n" +
                "يَا أَيُّهَا الَّذِينَ آَمَنُوا كُتِبَ عَلَيْكُمُ الصِّيَامُ كَمَا كُتِبَ عَلَى الَّذِينَ مِنْ قَبْلِكُمْ لَعَلَّكُمْ تَتَّقُونَ (183)\n" +
                "“Wahai orang-orang yang beriman, diwajibkan kepada kalian berpuasa sebagaimana diwajibkan kepada orang-orang sebelum kalian agar kalian bertakwa (QS. Al-Baqarah: 183).”" +
                "");

        List<String> syaratpuasa = new ArrayList<>();
        syaratpuasa.add("Siapakah yang Wajib berpuasa Ramadhan? Orang yang wajib menjalankan puasa Ramadhan memiliki syarat-syarat tertentu yaitu seorang muslim yang berakal, baligh, sehat, mukim, dan bila ia seorang wanita maka harus bersih dari haidh dan nifas.\n" +
                "Sementara itu tidak ada kewajiban puasa terhadap orang kafir, orang gila, anak kecil, orang sakit, musafir, wanita haidh dan nifas, orang tua yang lemah serta wanita hamil dan wanita menyusui.");

        listHash.put(listDataHeader.get(0),pengertianpuasa);
        listHash.put(listDataHeader.get(1),macampuasa);
        listHash.put(listDataHeader.get(2),dalilpuasa);
        listHash.put(listDataHeader.get(3),syaratpuasa);
    }

}
