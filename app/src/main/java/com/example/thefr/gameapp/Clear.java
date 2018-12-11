package com.example.thefr.gameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class Clear extends AppCompatActivity {
    static MediaPlayer bgm;
    private  gameClear gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(bgm == null) {
            bgm = MediaPlayer.create(this, R.raw.cake);
        }
        bgm.start();
        if (startActivity.bgm != null) {
            startActivity.bgm.stop();
        }

        gameView = new gameClear(this);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        }, 0, Interval);

    }
}
