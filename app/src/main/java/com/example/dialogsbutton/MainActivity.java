package com.example.dialogsbutton;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog,btnTimePickerDialog, btnDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews(){
        btnAlertDialog = findViewById(R.id.AlertDialogButton);
        btnTimePickerDialog = findViewById(R.id.TimePicker);
        btnDatePickerDialog = findViewById(R.id.DatePicker);
    }

    private void initListeners(){
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exam Form Submission");
                builder.setMessage("Are you sure you want to submit?");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setPositiveButton("Yes",new AlertDialogButtonClickListener());
                builder.setNegativeButton("No",new AlertDialogButtonClickListener());
     //Way 3 of passing object of anonymous class using dialogue interface
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Neutral Button Pressed!"+i,Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });

        btnTimePickerDialog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TimePickerDialog  timePickerDialog  = new TimePickerDialog(MainActivity.this,new TimePickerDialogButtonOnClickListener(),11,34,true);
                timePickerDialog.show();

            }
        });

        btnDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,new DatePickerDialogueOnClickListener(),2025,01,16);
                datePickerDialog.show();
            }
        });
    }
   //Way 2 of Writing code redundently for multiple Buttons
    class AlertDialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if(which == -1){
                Toast.makeText(MainActivity.this,"Positive Button Clicked!",Toast.LENGTH_LONG).show();
            } else if (which == -2) {
                Toast.makeText(MainActivity.this,"Negative Button Clicked!",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(MainActivity.this,"Neutral Button CLicked",Toast.LENGTH_LONG).show();
            }
        }
    }

//      Way 1- of Writing code for different Buttons
//    class PositiveButtonClickListener implements DialogInterface.OnClickListener{
//        @Override
//        public void onClick(DialogInterface dialogInterface, int which) {
//            Toast.makeText(MainActivity.this, "Positive Btn Clicked  " + which, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    class NegativeButtonClickListener implements DialogInterface.OnClickListener{
//        @Override
//        public void onClick(DialogInterface dialogInterface, int which) {
//            Toast.makeText(MainActivity.this,"Negative Btn Clicked  " + which, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    class NeutralButtonClickListener implements DialogInterface.OnClickListener{
//        @Override
//        public void onClick(DialogInterface dialogInterface, int which) {
//            Toast.makeText(MainActivity.this,"Neutral Btn Clicked  " + which,Toast.LENGTH_LONG).show();
//        }
//    }
    class TimePickerDialogButtonOnClickListener implements TimePickerDialog.OnTimeSetListener {

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Log.e("tag","timePicker"+" "+timePicker+" "+i+" "+i1);
    }
}
    class DatePickerDialogueOnClickListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Log.e("Tag","datePicker"+" "+datePicker+" "+i+" "+i1+" "+i2);
        }
    }
}