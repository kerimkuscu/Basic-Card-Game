package com.example.kerimkuscu.cardgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatDrawableManager;

public class hard_cards extends AppCompatButton {
    boolean open = false;
    boolean reversible = true;
    int backgroundid;
    int frontgroundid = 0;
    Drawable back;
    Drawable front;

    @SuppressLint("RestrictedApi")
    public hard_cards(Context context, int id) {
        super(context);
        setId(id);
        backgroundid = R.drawable.joker;
        if (id % 8 == 1)
            frontgroundid = R.drawable.sineka;
        if (id % 8 == 2)
            frontgroundid = R.drawable.sinek2;
        if (id % 8 == 3)
            frontgroundid = R.drawable.macaa;
        if (id % 8 == 4)
            frontgroundid = R.drawable.maca2;
        if (id % 8 == 5)
            frontgroundid = R.drawable.karoa;
        if (id % 8 == 6)
            frontgroundid = R.drawable.karo2;
        if (id % 8 == 7)
            frontgroundid = R.drawable.kupaa;
        if (id % 8 == 0)
            frontgroundid = R.drawable.kupa2;
        back = AppCompatDrawableManager.get().getDrawable(context, backgroundid);
        front = AppCompatDrawableManager.get().getDrawable(context, frontgroundid);
        setBackground(back);
    }

    public void render() {
        if (reversible) {
            if (!open) {
                //Back
                setBackground(front);
                open = true;
            } else {
                setBackground(back);
                open = false;
            }
        }
    }
}
