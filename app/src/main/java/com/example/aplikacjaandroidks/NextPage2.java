package com.example.aplikacjaandroidks;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextPage2 extends AppCompatActivity {
    Button buttonNext;
    Button buttonBack;
    TextView savedMoney;
    TextView viewTextSaved;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page2);

        buttonNext = (Button) findViewById(R.id.button5);
        buttonBack = (Button) findViewById(R.id.button4);
        savedMoney = (TextView) findViewById(R.id.textViewSaved);
        viewTextSaved = (TextView) findViewById(R.id.textView);
        String txt = getIntent().getStringExtra("dane");



        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newActivity();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldActivity();
            }
        });
    }
    public void newActivity()
    {
        Intent i = new Intent(this, NextPage2.class);
        startActivity(i);
    }
    public void oldActivity()
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
