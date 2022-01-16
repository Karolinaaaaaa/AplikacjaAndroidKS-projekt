package com.example.aplikacjaandroidks;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NextPage extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";
    public static final String EXTRA_NUMBER2 = "com.example.application.example.EXTRA_NUMBER2";

    Button buttonNext;
    Button buttonBack;
    EditText editTextNumber;
    EditText editTextNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page);

         buttonNext = (Button) findViewById(R.id.button2);
         buttonBack = (Button) findViewById(R.id.button3);
         editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
         editTextNumber = (EditText) findViewById(R.id.editTextNumber);


        editTextNumber.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEvent.ACTION_UP == motionEvent.getAction())
                    Toast.makeText(NextPage.this, R.string.toastCommunicat, Toast.LENGTH_SHORT).show();

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
        Intent i = new Intent(this, NextPage2.class);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        int number = Integer.parseInt(editTextNumber.getText().toString());

        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        int number2 = Integer.parseInt(editTextNumber2.getText().toString());
        i.putExtra(EXTRA_NUMBER2, number2);
        i.putExtra(EXTRA_NUMBER, number);
        startActivity(i);
    }
    public void oldActivity()
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
