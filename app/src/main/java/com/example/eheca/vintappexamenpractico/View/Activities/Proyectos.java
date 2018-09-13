package com.example.eheca.vintappexamenpractico.View.Activities;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Switch;
import android.widget.TextView;

import com.example.eheca.vintappexamenpractico.Data.GetRest;
import com.example.eheca.vintappexamenpractico.Model.Construccion;
import com.example.eheca.vintappexamenpractico.R;
import com.example.eheca.vintappexamenpractico.View.Fragments.EnProcesoFragment;
import com.example.eheca.vintappexamenpractico.View.Fragments.FinalizadosFragment;

import java.util.ArrayList;

public class Proyectos extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }
    public static class PlaceholderFragment extends Fragment {
        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment = new PlaceholderFragment();
            //Cambia los fragments entre EnProcceso y Finalizados;
            switch(sectionNumber){
                case 1:
                    fragment = new EnProcesoFragment();
                    break;
                case 2:
                    fragment = new FinalizadosFragment();
                    break;
            }
            return fragment;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Coloca el fragment correcto en el tab activity
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
