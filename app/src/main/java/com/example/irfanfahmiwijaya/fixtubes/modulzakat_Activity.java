package com.example.irfanfahmiwijaya.fixtubes;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.irfanfahmiwijaya.fixtubes.Fragment.fragment_zakat1_fitrah;
import com.example.irfanfahmiwijaya.fixtubes.Fragment.fragment_zakat2_maal;
import com.example.irfanfahmiwijaya.fixtubes.Fragment.fragment_zakat3_profesi;

/**
 * Created by irfanfahmiwijaya on 10/01/2018.
 */

public class modulzakat_Activity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**n
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment frag = null;

            if(position == 0){
                frag = new fragment_zakat1_fitrah();
            }else if (position == 1){
                frag = new fragment_zakat2_maal();
            }else if (position == 2){
                frag = new fragment_zakat3_profesi();
            }
            Bundle b = new Bundle();
            b.putInt("Position",position);
            frag.setArguments(b);
            return frag;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Zakat Fitrah";
                case 1:
                    return "Zakat Harta(Maal)";
                case 2:
                    return "Zakat Profesi";
            }
            return null;
        }
    }

}
