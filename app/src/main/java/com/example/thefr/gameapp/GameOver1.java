package com.example.thefr.gameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOver1 extends AppCompatActivity {
    private Button startGameAgain;
    MediaPlayer bgm;
    static MediaPlayer bgm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_over1);

        if(bgm == null) {
            bgm = MediaPlayer.create(this, R.raw.man_scream);
        }
        bgm.start();
        if (startActivity.bgm != null) {
            startActivity.bgm.stop();
        }
//        if (GameOver1.bgm2 != null) {
//            GameOver1.bgm2.stop();
//        }

        startGameAgain = (Button) findViewById(R.id.play_again_btn);
        startGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GameOver1.this, startActivity.class);

                startActivity.bgm = null;
                startActivity.fail += 1;
                startActivity(mainIntent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity.bgm = null;
    }
}
