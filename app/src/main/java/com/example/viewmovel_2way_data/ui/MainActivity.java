package com.example.viewmovel_2way_data.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.viewmovel_2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = new Object(){}.getClass().getEnclosingMethod().getName();


        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragmentConteiner);

        if (fragment == null) {
            fragment = new Fragment1();
            fm.beginTransaction().
                    add(R.id.fragmentConteiner, fragment)
                    .commit();
        }


        Fragment fragment1 = fm.findFragmentById(R.id.fragmentConteiner2);
        if (fragment1 == null) {
            fragment1 = new Fragment2();
            fm.beginTransaction().
                    add(R.id.fragmentConteiner2, fragment1)
                    .commit();
        }


    }
}