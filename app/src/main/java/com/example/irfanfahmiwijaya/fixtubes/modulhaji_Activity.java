package com.example.irfanfahmiwijaya.fixtubes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.irfanfahmiwijaya.fixtubes.Adapter.ExpandableListHajiAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by irfanfahmiwijaya on 01/02/2018.
 */

public class modulhaji_Activity extends AppCompatActivity {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haji);

        listView = (ExpandableListView)findViewById(R.id.lvExpandable);
        initData();
        listAdapter = new ExpandableListHajiAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);


    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Pengertian Haji & Umroh");
        listDataHeader.add("Hukum Haji & Umroh");
        listDataHeader.add("Rukun Haji");
        listDataHeader.add("Wajib Haji");
        listDataHeader.add("Sunnah Haji");
        listDataHeader.add("Rukun Umroh");
        listDataHeader.add("Wajib Umroh");
        listDataHeader.add("Sunnah Umroh");


        List<String> pengertianhaji = new ArrayList<>();
        pengertianhaji.add(
                "Pengertian haji menurut bahasa (etimologi) adalah pergi ke Baitullah (Kakbah) untuk melaksanakan ibadah yang telah ditetapkan atau ditentukan Allah swt.\n" +
                        "\n"+
                "Pengertian haji secara istilah (terminologi) adalah pergi beribadah ke tanah suci (Mekah), melakukan tawaf, sa’i, dan wukuf di Padang Arafah serta melaksanakan semua ketentuan-ketentuan haji di bulan Zulhijah." +
                        "\n"+
                "Pengertian umrah menurut bahasa (etimologi) yaitu diambil dari kata “i’tamara” yang artinya berkunjung. Di dalam syariat, umrah artinya adalah berkunjung ke Baitullah (Masjidil Haram) dengan tujuan mendekatkan diri kepada Allah dengan memenuhi syarat tertentu yang waktunya tidak ditentukan seperti halnya haji"+
                        "\n"+""
        );

        List<String> hukumhajidanumroh = new ArrayList<>();
        hukumhajidanumroh.add("Hukum melaksanakan haji adalah wajib bagi setiap muslim yang mampu, sesuai dengan firman Allah dalam Surah Ali Imran Ayat 97.yang artinya.\n" +
                "Artinya: “Padanya terdapat tanda-tanda yang nyata (di antaranya) maqam Ibrahin, barang siapa\n" +
                "memasukinya (Baitullah itu) menjadi amanlah dia. Mengerjakan haji adalah kewajiban manusia terhadap Allah, yaitu (bagi) orang yang sanggup mengadakan perjalanan ke Baitullah. Barang siapa mengingkari (kewajiban haji) maka sesungguhnya Allah Mahakaya (tidak memerlukan sesuatu) dari semesta alam.” (QS Ali Imran: 97).\n" +
                "Sebagai ulama berpendapat bahwa umrah hukumnya mutahabah artinya baik untuk dilakukan dan tidak diwajibkan. Hadis Nabi Muhammad saw. menyatakan sebagai berikut.\n" +
                "Artinya: Haji adalah fardu sedangkan umrah adalah “tatawwu.” (A1 Hadis)" +
                "Tatawwu maksudnya ialah tidak diwajibkan, tetapi baik dilakukan untuk mendekatkan diri kepada Allah dan melakukannya lebih utama daripada meninggalkannya karena tatawwu mempunyai ganjaran pahala");

        List<String> rukunhaji = new ArrayList<>();
        rukunhaji.add(" Rukun haji adalah sebagai berikut.\n" +
                "Ihram\n" +
                "Ihram yaitu berniat untuk mulai mengerjakan ibadah haji dengan memakai kain putih yang tidak dijahit. Ibadah ini dimulai setelah sampai di miqat (batas-batas yang telah ditetapkan).\n" +
                "Miqat ini dibagi dua yaitu:\n" +
                "miqat zamani, yakni batas yang telah ditentukan berdasarkan waktu. Mulai bulan Syawal sampai terbit fajar tanggal 10 Zulhijah. Maksudnya, hanya pada masa itulah ibadah haji bisa dilaksanakan.\n" +
                "miqat makani yakni, batas yang telah ditetapkan berdasarkan tempat. Miqat makani dibagi\n" +
                "ke dalam beberapa temjat yaitu sebagai berikut.\n" +
                "\n" +
                "Bagi orang yang bermukim di Mekah, niat ihram dihitung sejak keluar dari Mekah.\n" +
                "Bagi orang yang berasal dari Madinah dan sekitarnya, niat ihram dimulai sejak mereka sampai di Dzulhulaifah (Bir Ali).\n" +
                "Bagi orang dari Syam, Mesir, dan arah barat, memulai ihram mereka ketika sampai di Juhfah.\n" +
                "Bagi orang yang datang dari Yaman dan Hijaz, ihram dimulai setelah mereka sampai di bukit Qarnul Manazil.\n" +
                "Bagi orang dari India, Indonesia, dan negara yang searah memulai ihram setelah mereka berada di bukit Yalamlam.\n" +
                "Bagi orang yang datang dari arah Irak dan yang searah dengannya, ihram dimulai dari Dzatu Irqin.\n" +
                "Wukuf di Arafah\n" +
                "Wukuf di Arafah adalah berhenti di Padang Arafah sejak tergelintirnya matahari tanggal 9 Zulhijah sampai terbit fajar pada tanggal 10 Zulhijah.\n" +
                "Tawaf Ifadah\n" +
                "Tawaf ifadah adalah mengelilingi Kakbah sebanyak 7 kali dengan syarat sebagai berikut.\n" +
                "1) Suci dari hadas dan najis baik badan maupun pakaian.\n" +
                "2) Menutup aurat.\n" +
                "3) Kakbah berada di sebelah kiri orang yang mengelilinginya.\n" +
                "4) Memulai tawaf dari arah hajar aswad (batu hitam) yang terletak di salah satu pojok di luar Kakbah.\n" +
                "Macam-macam tawaf itu sendiri ada lima macam yaitu seperti berikut ini.\n" +
                "a) Tawaf qudum adalah tawaf yang dilakukan ketika baru sampai di Mekah\n" +
                "b) Tawaf ifadah adalah tawaf yang menjadi rukun haji\n" +
                "c) Tawaf sunah adalah tawaf yang dilakukan semata-mata mencari rida Allah.\n" +
                "d) Tawaf nazar adalah tawaf yang dilakukan untuk memenuhi nazar.\n" +
                "e) Tawaf wada adalah tawaf yang dilakukan sebelum meninggalkan kota Mekah\n" +
                "Sa’i\n" +
                "Sa’i adalah lari-lari kecil atau jalan cepat antara Safa dan Marwa (keterangan lihat QS Al Baqarah: 158). Syarat-syarat sa’i adalah sebagai berikut.\n" +
                "1) Dimulai dari bukit Safa dan berakhir di bukit Marwa.\n" +
                "2) Dilakukan sebanyak tujuh kali.\n" +
                "3) Melakukan sa’i setelah tawaf qudum.\n" +
                "Tahalul\n" +
                "Tahalul adalah mencukur atau menggunting rambut sedikitnya tiga helai. Pihak yang mengatakan bercukur sebagai rukun haji, beralasan karena tidak dapat diganti dengan penyembelihan.\n" +
                "Tertib.\n" +
                "Tertib maksudnya adalah menjalankan rukun haji secara berurutan.");

        List<String> wajibhaji = new ArrayList<>();
        wajibhaji.add(" Wajib haji ada tujuh macam, yakni sebagai berikut.\n" +
                "a. Ihram mulai dari miqat.\n" +
                "b. Bermalam di Muzdalifah pada malam hari raya haji.\n" +
                "c. Melempar Jumratul Aqabah.\n" +
                "d. Melempar tiga jumrah yakni.\n" +
                "1. jumrah ula,\n" +
                "2. jumrah wusta, dan\n" +
                "3. jumrah aqabah.\n" +
                "Melempar jumrah ini dilakukan setiap hari pada tanggal 11, 12, dan 13 bulan Zulhijah dan waktunya setelah tergelincir matahari. Masing-masing jumrah dilempar sebanyak 7 (tujuh) kali dengan batu kecil.\n" +
                "e. Bermalam di Mina.\n" +
                "f. Tawaf wada.\n" +
                "g. Menjauhkan diri dari larangan atau perbuatan yang diharamkan dalam ihram dan umrah yaitu sebagai berikut.\n" +
                "1. Bagi pria dilarang memakai pakaian berjahit.\n" +
                "2. Menutup kepala bagi pria dan menutup muka bagi wanita\n" +
                "3. Memotong kuku.\n" +
                "4. Membunuh hewan buruan.\n" +
                "5. Memakai wangi-wangian.\n" +
                "6. Hubungan suami isteri (bersetubuh)\n" +
                "7. Mengadakan aqad nikah (kawin atau mengawinkan).\n" +
                "8. Memotong rambut atau bulu badan yang lain.");

        List<String> sunnahhaji = new ArrayList<>();
        sunnahhaji.add(" Adapun sunah haji ada enam perkara, yakni sebagai berikut.\n" +
                "1. Cara mengerjakan haji dan umrah. Terdapat tiga macam sunah mengerjakan haji dan umrah yaitu sebagai berikut.\n" +
                "Ifrad : melakukan haji lebih dahulu, kemudian barn umrah.\n" +
                "Tamattu : mendahulukan umrah, kemudian haji.\n" +
                "Qiran : ibadah haji dan umrah dilakukan secara bersama-sama.\n" +
                "2. Membaca talbiyah selama dalam ihram sampai melempar jumrah aqabah pada Hari Raya Haji. (Idul Adha).\n" +
                "3. Berdoa setelah membaca talbiyah.\n" +
                "4. Berzikir sewaktu tawaf.\n" +
                "5. Salat dua rakaat sesudah tawaf.\n" +
                "6. Masuk ke Kakbah (Baitullah).");

        List<String> rukunumroh = new ArrayList<>();
        rukunumroh.add(" a. Ihram disertai niat.\n" +
                "b. Tawaf atau mengelilingi Kakbah.\n" +
                "c. Sa’i lari-lari kecil antara Safa dan Marwa.\n" +
                "d. Bercukur atau memotong rambut minimal tiga helai.");

        List<String> wajibumroh = new ArrayList<>();
        wajibumroh.add("a. Ihram dari miqat yang terbagi menjadi dua macam yaitu sebagai berikut.\n" +
                "1) Miqat zamani (batas waktu) yakni dapat dilakukan sewaktu-waktu.\n" +
                "2) Miqat makani (batas mulai ihram) seperti halnya haji.\n" +
                "b. Menjaga diri dari larangan-larangan ihram yang jumlahnya sama dengan larangan haji.");

        List<String> sunnahumroh = new ArrayList<>();
        sunnahumroh.add(" Sunnah dalam ibadah umroh adalah amalan  pelengkap dan penyempurna bagi pelaksanaan ibadah Umrah; diberi pahala bagi mereka yang mengerjakan tetapi apabila pelaksanaannya tertinggal tidak membatalkan ibadah Umrah dan tidak membayar Dam.\n" +
                " \n" +
                "Yang termasuk amalan sunnah adalah : \n" +
                "Mandi ihram (sebelum ihram) \n" +
                "Memakai wangi-wangian sebelum ihram (bagi laki–laki)\n" +
                "Melafazdkan niat ihram di miqot sesudah shalat \n" +
                "Mengulang bacaan talbiyah\n" +
                "Berdo’a saat memasuki kota Mekkah \n" +
                "Berdo’a saat masuk Masjidil Haram\n" +
                "Berdo’a saat melihat Ka’bah\n" +
                "Mencium Hajar Aswad\n" +
                "Shalat di Hijir Ismail,\n" +
                "Minum Air Zam -zam dan\n" +
                "Memperbanyak melaksanakan Thawaf Sunnah.");

        listHash.put(listDataHeader.get(0),pengertianhaji);
        listHash.put(listDataHeader.get(1),hukumhajidanumroh);
        listHash.put(listDataHeader.get(2),rukunhaji);
        listHash.put(listDataHeader.get(3),wajibhaji);
        listHash.put(listDataHeader.get(4),sunnahhaji);
        listHash.put(listDataHeader.get(5),rukunumroh);
        listHash.put(listDataHeader.get(6),wajibumroh);
        listHash.put(listDataHeader.get(7),sunnahumroh);
    }
}
