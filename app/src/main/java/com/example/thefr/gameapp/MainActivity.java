package com.example.thefr.gameapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    /**
     * MainActivity is just a container for level1. All the Event and control will be happen through
     * level1 and MainActivity update (or loop) every set time interval.
     */
    private  level1 gameView;
    /**
     * Handler move data from background thread to the UI.
     */
    private Handler handler = new Handler();
    /**
     * Time interval for every loop.
     */
    private final static long Interval = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Set level1 for this Activity.
         */
        gameView = new level1(this);
        setContentView(gameView);

        /**
         * update and send data to UI.
         */
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

    /**
     * when back button is press, stop background music.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (startActivity.bgm != null) {
            startActivity.bgm.stop();
            startActivity.bgm = null;
        }
    }
}
