package com.example.aplikacjaandroidks;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class NextPage3 extends AppCompatActivity {
    Button buttonNext;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page3);

        buttonNext = (Button) findViewById(R.id.buttonN);
        buttonBack = (Button) findViewById(R.id.buttonB);
        buttonNext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEvent.ACTION_UP == motionEvent.getAction())
                    Toast.makeText(NextPage3.this, R.string.toastEnd, Toast.LENGTH_SHORT).show();

                return false;
            }
        });


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
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void oldActivity()
    {
        Intent i = new Intent(this, NextPage2.class);
        startActivity(i);
    }
}
