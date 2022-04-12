package edu.wit.mobileapp.basketballapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BallPhys   {
    int x, y;
    int width;
    int height;
    Bitmap TheBall;
    int moveDir;
    boolean Up = false;

    BallPhys (int ScreenY, Resources Res){
        TheBall = BitmapFactory.decodeResource(Res, R.drawable.ball);
        height = TheBall.getHeight();
        width = TheBall.getWidth();

       // width /= 4;
       // height /=4;


        //TheBall = Bitmap.createScaledBitmap(TheBall, width, height);
    }

    Bitmap Movement (){
        if (moveDir == 0) {
            moveDir++;
        }
        moveDir--;
        return TheBall;
    }
}
