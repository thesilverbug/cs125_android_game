package com.example.thefr.gameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOverHole extends AppCompatActivity {
    private Button startGameAgain;
    MediaPlayer bgm;
    static MediaPlayer bgm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_hole);
        if(bgm == null) {
            bgm = MediaPlayer.create(this, R.raw.man_scream);
        }
        bgm.start();
        if (startActivity.bgm != null) {
            startActivity.bgm.stop();
        }

        startGameAgain = (Button) findViewById(R.id.play_again_btn);
        startGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GameOverHole.this, startActivity.class);
                startActivity.fail += 1;
                startActivity.bgm = null;
                startActivity(mainIntent);
                finish();
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        startActivity.bgm = null;
    }

}
