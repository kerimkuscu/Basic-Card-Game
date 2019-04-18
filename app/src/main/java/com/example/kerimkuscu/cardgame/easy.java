package com.example.kerimkuscu.cardgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class easy extends AppCompatActivity {
    int lastCard = 0;
    int score;
    int error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        Intent i = getIntent();
        GridLayout gl = (GridLayout) findViewById(R.id.easycards);
        easy_cards card[] = new easy_cards[16];
        for (int j = 1; j <= 16; j++) {
            card[j - 1] = new easy_cards(this, j);
            card[j - 1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final easy_cards k = (easy_cards) v;
                    k.render();
                    if (lastCard > 0) {
                        final easy_cards k2 = (easy_cards) findViewById(lastCard);
                        if (k2.frontgroundid == k.frontgroundid && k2.getId() != k.getId()) {
                            //MATCHİNG PORTİON
                            k2.reversible = false;
                            k.reversible = false;
                            score++;
                            k.setClickable(false);
                            k2.setClickable(false);
                            TextView tv = (TextView) findViewById(R.id.score);
                            tv.setText("SCORE = " + score);
                            if (score == 8) {
                                Intent lastpage = new Intent(easy.this, lastpage.class);
                                lastpage.putExtra("point", error);
                                startActivity(lastpage);
                            }
                        } else {
                            //NO MATCHİNG
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.render();
                                    k2.render();
                                }
                            }, 300);
                            error++;
                            TextView tv = (TextView) findViewById(R.id.error);
                            tv.setText("YOUR ERROR POINT =" + error);
                            lastCard = 0;
                        }
                    } else {
                        lastCard = k.getId();
                    }
                }
            });
        }
        //RANDOM CARD
        for (int j = 0; j < 16; j++) {
            int rg = (int) (Math.random() * 16);
            easy_cards c = card[rg];
            card[rg] = card[j];
            card[j] = c;
        }
        for (int j = 0; j < 16; j++)
            gl.addView(card[j]);
    }
}
