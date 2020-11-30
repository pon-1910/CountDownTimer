package com.example.mycompany.countdowntimer;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int ittaddakimasu;

    public SoundPlayer(Context context){

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        ittaddakimasu = soundPool.load(context, R.raw.ittadakkimaasu, 1);
    }

    public void playittadakkimaau(){
        soundPool.play(ittaddakimasu, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
