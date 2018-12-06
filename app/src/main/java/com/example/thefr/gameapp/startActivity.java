package com.example.thefr.gameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.security.AccessController.getContext;

public class startActivity extends AppCompatActivity {
    static MediaPlayer bgm;
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        start = (Button) findViewById(R.id.start_btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(startActivity.this, MainActivity.class);
                startActivity(mainIntent);

                bgm.start();
                bgm.setLooping(true);

            }
        });
        if (bgm == null) {
            bgm = MediaPlayer.create(this, R.raw.scary);
        }
        bgm.start();
        bgm.setLooping(true);
    }
}
