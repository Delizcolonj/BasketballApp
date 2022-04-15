package edu.wit.mobileapp.basketballapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static edu.wit.mobileapp.basketballapp.GameView.ScreenRatioX;
import static edu.wit.mobileapp.basketballapp.GameView.ScreenRatioY;

public class Hoop {

    Bitmap hoop;
    public boolean madeShot = true;
    int x, y, width, height;

    Hoop (Resources res) {


        hoop = BitmapFactory.decodeResource(res, R.drawable.the_hoop);

        width = hoop.getWidth();
        height = hoop.getHeight();

        width /= 15;
        height /= 15;

        width = (int) (width * ScreenRatioX);
        height = (int) (height * ScreenRatioY);

        hoop = Bitmap.createScaledBitmap(hoop, width, height, false);

        x = (int) (1100*ScreenRatioX);
        y = (int) (100*ScreenRatioY);
    }

    Bitmap getHoop () {
        return hoop;
    }
}
