package edu.wit.mobileapp.basketballapp;

import static edu.wit.mobileapp.basketballapp.GameView.ScreenRatioX;
import static edu.wit.mobileapp.basketballapp.GameView.ScreenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GameO {
    Bitmap GameO;
    public boolean madeShot = true;
    int x, y, width, height;

    GameO (Resources res, int ScreenX, int ScreenY) {


        GameO = BitmapFactory.decodeResource(res, R.drawable.gameover);

        width = GameO.getWidth();
        height = GameO.getHeight();

        width /= 5;
        height /= 5;

        width = (int) (width * ScreenRatioX);
        height = (int) (height * ScreenRatioY);

        GameO = Bitmap.createScaledBitmap(GameO, width, height, false);

        x = (int) (ScreenX/2 - width/2);
        y = (int) (ScreenY/2 - height/2);

    }
    Bitmap getOver () {

        return GameO;
    }


}

