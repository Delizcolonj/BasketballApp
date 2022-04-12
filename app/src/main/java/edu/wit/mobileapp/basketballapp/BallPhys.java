package edu.wit.mobileapp.basketballapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BallPhys   {
    int x, y, move;
    int width;
    int height;
    Bitmap TheBall;
    int moveDir = 0;
    boolean Up = false;
    private GameView gameView;

    BallPhys (GameView gameView, int ScreenY, Resources Res){
        this.gameView = gameView;

        TheBall = BitmapFactory.decodeResource(Res, R.drawable.ball);

        height = TheBall.getHeight();
        width = TheBall.getWidth();

        width /= 10;
        height /= 10;

        width =(int) (width * gameView.ScreenRatioX);
        height = (int) (height * gameView.ScreenRatioY);

        TheBall = Bitmap.createScaledBitmap(TheBall, width, height, false);

        y = ScreenY / 2;
        x = (int) (64 * gameView.ScreenRatioX);
    }

    Bitmap Movement (){
        if (moveDir != 0) {
            if (move == 1) {
                move++;
                return TheBall;
            }
            moveDir++;
        }
        move = 1;
        moveDir--;
        return TheBall;
    }
}
