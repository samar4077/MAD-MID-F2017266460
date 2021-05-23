package com.example.mad_mid_f2017266460;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.DateFormat;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class SecondFragment extends Fragment {


    Dialog dialog;
    ImageView showdialog,settime,setdate;
    Button savebutton;
    EditText Edittext;
    int t1Houre,t1Minute;
    TextView timeview,viewdate;
    DatePickerDialog.OnDateSetListener setListener;
    public SecondFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.second, container, false);

        timeview = view.findViewById(R.id.timeview);
        viewdate = view.findViewById(R.id.viewdate);
        setdate = view.findViewById(R.id.setdate);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        setdate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                viewdate.setText(date);
            }
        };


       showdialog = view.findViewById(R.id.showdialog);
       


        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialogbox);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        savebutton = dialog.findViewById(R.id.saveitembutton);
        Edittext = dialog.findViewById(R.id.edittext);




        showdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        settime = view.findViewById(R.id.timeset);
        settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                       android.R.style.Theme_Holo_Light_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                   @Override
                   public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                       t1Houre=hourOfDay;
                       t1Minute=minute;
                       String time = t1Houre + ":" + t1Minute;
                       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
                       try {
                           Date date = simpleDateFormat.parse(time);
                           SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm aa");
                           timeview.setText(simpleDateFormat.format(date));

                       } catch (ParseException e) {
                           e.printStackTrace();
                       }
                   }
               },12,0,false
               );
               timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               timePickerDialog.updateTime(t1Houre,t1Minute);
               timePickerDialog.show();
            }
        });

       savebutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String text = Edittext.getText().toString();
               Intent intent = new Intent(getContext(),datenext.class);
               intent.putExtra("name",text);
               startActivity(intent);

           }


       });


        return view;
    }

}