package com.example.thefr.gameapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import static java.security.AccessController.getContext;

public class startActivity extends AppCompatActivity {
    /**
     * Background music.
     */
    static MediaPlayer bgm;
    /**
     * Start button.
     */
    private Button start;
    /**
     * Background images
     */
    int image[] = {R.drawable.frontscreen1, R.drawable.frontscreen2, R.drawable.frontscreen3,
            R.drawable.frontscreen4, R.drawable.frontscreen5, R.drawable.frontscreen6};
    /**
     * Number of failure.
     */
    protected static int fail = 0;

    /**
     * I believe onCreate method is like main method in java,
     * which execute code for android activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /**
         * Assign image to imageChanger in startActivity xml.
         */
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageChanger);
        /**
         * Image switcher as image view
         */
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
        if (fail >= 5) {
            fail = 5;
        }
        /**
         * display background image depend on number of failure.
         */
        imageSwitcher.setImageResource(image[fail]);


        /**
         * Used button that I created from startActivity xml.
         */
        start = (Button) findViewById(R.id.start_btn);
        /**
         * Activate when button is clicked.
         */
        start.setOnClickListener(new View.OnClickListener() {
            /**
             * When start button is press, goto next(Main) activity.
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(startActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();


            }
        });
        /**
         * if there is no background music, play background music.
         */
        if (bgm == null) {
            bgm = MediaPlayer.create(this, R.raw.scary);
        }
        bgm.setVolume(0.3f,0.3f);
        bgm.start();
        bgm.setLooping(true);
        /**
         * if background music from Clear Activity is still playing, stop it.
         */
        if (Clear.bgm != null) {
            Clear.bgm.stop();
        }
    }

    /**
     * when back button is press, stop background music.
     */
    public void onBackPressed() {
        super.onBackPressed();
        if (bgm != null) {
            bgm.stop();
            bgm = null;
        }
    }
}
