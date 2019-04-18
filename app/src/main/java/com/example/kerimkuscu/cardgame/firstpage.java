package com.example.kerimkuscu.cardgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        ((Button) findViewById(R.id.easy)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easy = new Intent(firstpage.this, easy.class);
                startActivity(easy);
                mp.start();
            }
        });
        ((Button) findViewById(R.id.hard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hard = new Intent(firstpage.this, hard.class);
                startActivity(hard);
                mp.start();
            }
        });
    }
}
