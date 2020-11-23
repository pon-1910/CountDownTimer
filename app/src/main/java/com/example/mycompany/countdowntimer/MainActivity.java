package com.example.mycompany.countdowntimer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private TextView timerText;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3分= 3×60×1000 = 180000 msec
        long countNumber = 180000;
        //インターバル　msec
        long interval = 10;

        Button startButton = findViewById(R.id.three_start_button);
        Button stopButton = findViewById(R.id.three_stop_button);

        timerText = findViewById(R.id.three_timer);
        timerText.setText(dateFormat.format(0));

        //インスタンス生成

        final CountDown countDown = new CountDown(countNumber, interval);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDown.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDown.cancel();
                timerText.setText(dateFormat.format(0));
            }
        });

        View close = findViewById(R.id.three_close_button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.three_close_button){
                    Intent intent = new Intent(MainActivity.this, Title.class);

                    startActivity(intent);
                }
            }
        });
    }

    class CountDown extends CountDownTimer {

        CountDown(long millisInFuture, long countDownInterval){
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            //完了
            timerText.setText(dateFormat.format(0));
        }

        //インターバルで呼ばれる
        @Override
        public void onTick(long millisUntilFinished) {

            timerText.setText(dateFormat.format(millisUntilFinished));
        }
    }
}