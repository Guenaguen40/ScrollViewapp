package com.example.scrollviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TypedActivity extends AppCompatActivity {
    TextView UserOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typed);

        UserOutput = findViewById(R.id.UserOutput);

        String userInput = getIntent().getStringExtra("keyinput");
        UserOutput.setText(userInput);

    }
}