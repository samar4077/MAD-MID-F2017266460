package com.example.mad_mid_f2017266460;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class UpdateRecordActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mOccupationEditText;
    private Button mUpdateBtn;

    private PersonDBHelper dbHelper;
    private long receivedPersonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        //init
        mNameEditText = (EditText)findViewById(R.id.userNameUpdate);
        mAgeEditText = (EditText)findViewById(R.id.userAgeUpdate);
        mOccupationEditText = (EditText)findViewById(R.id.userOccupationUpdate);
        mUpdateBtn = (Button)findViewById(R.id.updateUserButton);

        dbHelper = new PersonDBHelper(this);

        try {
            //get intent to get person id
            receivedPersonId = getIntent().getLongExtra("USER_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /***populate user data before update***/
        Person queriedPerson = dbHelper.getPerson(receivedPersonId);
        //set field to this user data
        mNameEditText.setText(queriedPerson.getName());
        mAgeEditText.setText(queriedPerson.getAge());
        mOccupationEditText.setText(queriedPerson.getOccupation());




        //listen to add button click to update
        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                updatePerson();
            }
        });





    }

    private void updatePerson(){
        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String occupation = mOccupationEditText.getText().toString().trim();



        if(name.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
        }

        if(age.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an age", Toast.LENGTH_SHORT).show();
        }

        if(occupation.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an occupation", Toast.LENGTH_SHORT).show();
        }


        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }

    private void goBackHome(){
        startActivity(new Intent(this, MainActivity.class));
    }
}
