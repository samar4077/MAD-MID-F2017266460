package com.example.mad_mid_f2017266460;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fregmant load by default start //

        firstsFragment massagesTabFragmet = new firstsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainliner,massagesTabFragmet);
        transaction.commit();

        // Fregmant load by default End //
    }
}