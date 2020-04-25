package com.cookandroid.myapplication6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar.Tab tabDog, tabCat, tabRabbit, tabHorse;
    MyTabFragment myFrags[] = new MyTabFragment[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabDog = bar.newTab();
        tabDog.setIcon(R.drawable.ic_dog);
        tabDog.setTabListener(this);
        bar.addTab(tabDog);

        tabCat = bar.newTab();
        tabCat.setIcon(R.drawable.ic_cat);
        tabCat.setTabListener(this);
        bar.addTab(tabCat);

        tabRabbit = bar.newTab();
        tabRabbit.setIcon(R.drawable.ic_rabbit);
        tabRabbit.setTabListener(this);
        bar.addTab(tabRabbit);

        tabHorse = bar.newTab();
        tabHorse.setIcon(R.drawable.ic_horse);
        tabHorse.setTabListener(this);
        bar.addTab(tabHorse);
    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()]==null){
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putInt("tabPosition", tab.getPosition());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        }
        else
            myTabFrag = myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        int tabPosition;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabPosition = data.getInt("tabPosition");
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View myView = null;
            Bundle data = getArguments();

            if (tabPosition == 0)
                myView = inflater.inflate(R.layout.activity_dog, null);
            if (tabPosition == 1)
                myView = inflater.inflate(R.layout.activity_cat, null);
            if (tabPosition == 2)
                myView = inflater.inflate(R.layout.activity_rabbit, null);
            if (tabPosition == 3)
                myView = inflater.inflate(R.layout.activity_horse, null);

            return myView;
        }
    }
}


