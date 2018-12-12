package com.example.thefr.gameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOverDog extends AppCompatActivity {
    /**
     * Play again button.
     */
    private Button startGameAgain;
    /**
     * background music.
     */
    MediaPlayer bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_dog);
        /**
         * if there is no background music in this Activity, Play man_scream from raw.
         */
        if(bgm == null) {
            bgm = MediaPlayer.create(this, R.raw.man_scream);
        }
        bgm.start();
        /**
         * if startActivity's background music is playing, stop it.
         */
        if (startActivity.bgm != null) {
            startActivity.bgm.stop();
        }
        /**
         * Activate when play again button is press.
         */
        startGameAgain = (Button) findViewById(R.id.play_again_btn);
        startGameAgain.setOnClickListener(new View.OnClickListener() {
            /**
             * Go back to startActivity(starting page) and exit current Activity.
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GameOverDog.this, startActivity.class);
                startActivity.bgm = null;
                startActivity.fail += 1;
                startActivity(mainIntent);
                finish();
            }
        });
    }
    /**
     * when back button is press, initialize background music to none.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity.bgm = null;
    }
}
