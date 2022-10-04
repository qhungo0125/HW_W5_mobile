package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends FragmentActivity implements MainCallBack {

    ListFragment listFragment;
    FragmentTransaction ft;
    InfoFragment infoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft=getSupportFragmentManager().beginTransaction();
        listFragment= listFragment.newInstance();
        ft.replace(R.id.listFrag,listFragment).commit();

        ft=getSupportFragmentManager().beginTransaction();
        infoFragment= infoFragment.newInstance();
        ft.replace(R.id.infoFrag,infoFragment).commit();

    }

    @Override
    public void MainToFrag(Person value) {
        infoFragment.FragToMain(value);
    }

    @Override
    public Person getPersonFromList(int id) {
        return listFragment.getPerson(id);
    }

    @Override
    public int getSize() {
        return listFragment.getSize();
    }
}