package com.example.mycompany.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        View three = findViewById(R.id.three_minute);
        View five = findViewById(R.id.five_minute);

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.three_minute){
                    Intent intent = new Intent(Title.this, MainActivity.class);

                    startActivity(intent);
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.five_minute){
                    Intent intent = new Intent(Title.this, MainActivity2.class);

                    startActivity(intent);
                }
            }
        });
    }
}