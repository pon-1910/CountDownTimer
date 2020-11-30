package com.example.mycompany.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private TextView timerText;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS", Locale.US);

    private SoundPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        soundPlayer = new SoundPlayer(this);

        //5分 = 5×60×1000 = 300000 msec
        long countNumber = 300000;
        //インターバル　msec
        long interval = 10;

        Button startButton = findViewById(R.id.five_start_button);
        Button stopButton = findViewById(R.id.five_stop_button);

        timerText = findViewById(R.id.five_timer);
        timerText.setText(dateFormat.format(0));

        //インスタンス生成
        final fiveCountDown fivecountDown = new fiveCountDown(countNumber, interval);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fivecountDown.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fivecountDown.cancel();
                timerText.setText(dateFormat.format(0));
            }
        });

        View close = findViewById(R.id.five_close_button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.five_close_button){
                    Intent intent = new Intent(MainActivity2.this, Title.class);

                    startActivity(intent);
                }
            }
        });
    }

    class fiveCountDown extends CountDownTimer{

        fiveCountDown(long millsInFuture, long countDownInterval){
            super(millsInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            //完了
            timerText.setText(dateFormat.format(0));

            soundPlayer.playittadakkimaau();
        }

        //インターバルで呼ばれる
        @Override
        public void onTick(long millisUntilFinished) {

            timerText.setText(dateFormat.format(millisUntilFinished));
        }

    }
}