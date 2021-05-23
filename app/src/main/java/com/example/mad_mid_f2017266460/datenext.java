package com.example.mad_mid_f2017266460;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class datenext extends AppCompatActivity {

    TextView itemname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datenext);
        itemname=findViewById(R.id.itemname);

        String name = getIntent().getStringExtra("name");
        itemname.setText(name);

    }

}