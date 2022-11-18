package com.example.scrollviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button button_Add_To_Ca;
    EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //passing data between activities

        userInput = findViewById(R.id.userInput);
        button1 = findViewById(R.id.button_Show_me);

        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           String user_wrote = userInput.getText().toString();
                                           Intent i = new Intent(MainActivity.this, TypedActivity.class);
                                           i.putExtra("keyinput", user_wrote);
                                           startActivity(i);

                                       }
                                   }
        );


        //Intent activity to go to scroll activity
        button = findViewById(R.id.button_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }

            private void openNewActivity() {
                Intent intent = new Intent(MainActivity.this, LongTextActivity.class);
                startActivity(intent);
            }
        });


        button_Add_To_Ca = findViewById(R.id.button_Add_To_Ca);
        button_Add_To_Ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addtocalendar();
            }

            private void Addtocalendar() {
                //calender event button
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "WEB DEV Bootcamp");
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 31/12/2022);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 31/12/2022);
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "A bootcamp for people interested in learning web development.");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Tunis, Iset Rades");
                startActivity(Intent.createChooser(intent, "Add to calendar"));
            }
        });
    }}