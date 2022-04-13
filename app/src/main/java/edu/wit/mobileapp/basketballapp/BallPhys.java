package edu.wit.mobileapp.basketballapp;

import static edu.wit.mobileapp.basketballapp.GameView.ScreenRatioX;
import static edu.wit.mobileapp.basketballapp.GameView.ScreenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BallPhys {
    int x, y, move = 1;
    int width;
    int height;
    Bitmap TheBall;
    int moveDir = 0;
    boolean Up = false;
    private GameView gameView;

    BallPhys(GameView gameView, int ScreenY, Resources Res) {
        this.gameView = gameView;

        TheBall = BitmapFactory.decodeResource(Res, R.drawable.ball);

        height = TheBall.getHeight();
        width = TheBall.getWidth();

        width /= 20;
        height /= 20;

        width = (int) (width * ScreenRatioX);
        height = (int) (height * ScreenRatioY);

        TheBall = Bitmap.createScaledBitmap(TheBall, width, height, false);

        y = ScreenY / 2;
        x = (int) (64 * ScreenRatioX);
    }

    Bitmap Movement() {

        if(moveDir != 0) {
            if (move == 1) {
                move++;
                return TheBall;
            }
            move = 1;
            moveDir--;
            gameView.newBall();

            return TheBall;
        }

        return TheBall;
    }
}
