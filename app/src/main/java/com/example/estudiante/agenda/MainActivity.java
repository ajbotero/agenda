package com.example.estudiante.agenda;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.estudiante.agenda.adapter.ViewPagerAdapter;
import com.example.estudiante.agenda.fragment.DummyFragment;
import com.example.estudiante.agenda.fragment.FormFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.tab_layout) TabLayout mTabLayout;
    @Bind(R.id.viewpager) ViewPager mviewPager;

    DummyFragment dummyFragment;
    FormFragment formFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dummyFragment = new DummyFragment();
        formFragment = new FormFragment();

        setSupportActionBar(mToolbar);

        //se crean los nombres de las columnas
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("NUEVO CONTACTO"));

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Se le ingresa un fragmento a cada columna
        viewPagerAdapter.addFrag(dummyFragment);
        viewPagerAdapter.addFrag(formFragment);



        mviewPager.setAdapter(viewPagerAdapter);
        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                mviewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()){
                    case 0:
                        Log.d("AGENDACONTACTOS", "TAB#1");
                        break;
                    case 1:
                        Log.d("AGENDACONTACTOS", "TAB#1");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        };
    public void newData(long id){ //patron observer
        dummyFragment.refresh(id);
    }
    }

