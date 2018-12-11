package com.example.thefr.gameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOverBus extends AppCompatActivity {
    private Button startGameAgain;
    MediaPlayer bgm;
    static MediaPlayer bgm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_bus);
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
                Intent mainIntent = new Intent(GameOverBus.this, startActivity.class);
//                bgm2 = MediaPlayer.create(GameOverBus.this, R.raw.scary);
//                bgm2.start();
//                bgm2.setLooping(true);
                startActivity.bgm = null;
                startActivity(mainIntent);
            }
        });
    }
}
