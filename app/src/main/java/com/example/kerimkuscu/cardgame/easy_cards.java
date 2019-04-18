package com.example.kerimkuscu.cardgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatDrawableManager;

public class easy_cards extends AppCompatButton {
    boolean open = false;
    boolean reversible = true;
    int backgroundid;
    int frontgroundid = 0;
    Drawable back;
    Drawable front;

    @SuppressLint("RestrictedApi")
    public easy_cards(Context context, int id) {
        super(context);
        setId(id);
        backgroundid = R.drawable.joker;
        if (id % 8 == 1)
            frontgroundid = R.drawable.sineka;
        if (id % 8 == 2)
            frontgroundid = R.drawable.sinek2;
        if (id % 8 == 3)
            frontgroundid = R.drawable.sinek3;
        if (id % 8 == 4)
            frontgroundid = R.drawable.sinek4;
        if (id % 8 == 5)
            frontgroundid = R.drawable.sinek5;
        if (id % 8 == 6)
            frontgroundid = R.drawable.sinek6;
        if (id % 8 == 7)
            frontgroundid = R.drawable.sinek7;
        if (id % 8 == 0)
            frontgroundid = R.drawable.sinek8;
        back = AppCompatDrawableManager.get().getDrawable(context, backgroundid);
        front = AppCompatDrawableManager.get().getDrawable(context, frontgroundid);
        setBackground(back);
    }

    public void render() {
        if (reversible) {
            if (!open) {//arkası cevriliyse
                setBackground(front);
                open = true;
            } else {
                setBackground(back);
                open = false;
            }
        }
    }
}
