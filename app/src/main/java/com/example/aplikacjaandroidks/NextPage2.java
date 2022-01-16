package com.example.aplikacjaandroidks;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextPage2 extends AppCompatActivity {
    Button buttonNext;
    Button buttonBack;
    Button check;
    TextView savedMoney;
    TextView viewTextSaved;
    TextView viewTextSaved2;
    TextView sumaField;
    TextView sumaResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page2);

        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        savedMoney = (TextView) findViewById(R.id.textViewSaved);
        sumaField =(TextView) findViewById(R.id.suma);
        sumaResult = (TextView) findViewById(R.id.sumTwo);
        check = (Button) findViewById(R.id.check);

        Intent i = getIntent();
        int number = i.getIntExtra(NextPage.EXTRA_NUMBER, 0);
        int number2 = i.getIntExtra(NextPage.EXTRA_NUMBER2, 0);
        viewTextSaved = (TextView) findViewById(R.id.textView);
        viewTextSaved2 = (TextView) findViewById(R.id.holdM);
        viewTextSaved.setText("" + number);
        viewTextSaved2.setText("" + number2);

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
        Intent i = new Intent(this, NextPage3.class);
        startActivity(i);
    }
    public void oldActivity()
    {
        Intent i = new Intent(this, NextPage.class);
        startActivity(i);
    }
    public void addNumber(View v){
        int number, number2, result;
        number = Integer.parseInt(viewTextSaved.getText().toString());
        number2 = Integer.parseInt(viewTextSaved2.getText().toString());
        result = number + number2;
        sumaResult.setText(String.valueOf(result));
    }
}
