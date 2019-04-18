package com.example.kerimkuscu.cardgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lastpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastpage);
        TextView tv = (TextView) findViewById(R.id.output);
        Intent i = getIntent();
        int score = i.getIntExtra("point", 0);
        tv.setText("CONGRATULATIONS" + "\n" + "WIN WITH " + score + " MISTAKE!!!");
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        ((Button) findViewById(R.id.playagain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(lastpage.this, firstpage.class);
                startActivity(i);
                mp.start();
            }
        });
    }
}
