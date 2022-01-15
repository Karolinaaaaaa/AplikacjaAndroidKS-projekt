package com.example.aplikacjaandroidks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NextPage extends AppCompatActivity {
    Button buttonNext;
    Button buttonBack;
    EditText editTextNumber;
    String txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page);

         buttonNext = (Button) findViewById(R.id.button2);
         buttonBack = (Button) findViewById(R.id.button3);
         editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextNumber.setText(txt);
        String number = editTextNumber.getText().toString();


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
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("dane", editTextNumber.getText().toString());
        editor.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        txt = sharedPref.getString("dane", "");
    }
    public void newActivity()
    {
        Intent i = new Intent(this, NextPage2.class);
        i.putExtra("dane", txt);
        startActivity(i);
    }
    public void oldActivity()
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
