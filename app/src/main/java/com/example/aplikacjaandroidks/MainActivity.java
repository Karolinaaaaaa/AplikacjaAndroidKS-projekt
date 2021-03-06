package com.example.aplikacjaandroidks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

Button button_next;
TextView welcome;
ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_next = (Button) findViewById(R.id.button);
        welcome = (TextView) findViewById(R.id.aplikacja_powitanie);
        imageView = (ImageView) findViewById(R.id.imageView);

        button_next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        newActivity();
    }
});
        button_next.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEvent.ACTION_UP == motionEvent.getAction())
                    Toast.makeText(MainActivity.this, R.string.toastWelcome, Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
    public void newActivity(){
        Intent next = new Intent(this, NextPage.class);
        startActivity(next);
    }

}