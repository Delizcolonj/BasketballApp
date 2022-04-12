package edu.wit.mobileapp.basketballapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

public class GameView extends SurfaceView implements Runnable {


    private Thread thread;
    public boolean isPlaying = true;
    private Game game;
    //private Context context;
    private int ScreenX, ScreenY;
    private Paint paint;
    public float ScreenRatioX;
    public float ScreenRatioY;
    private BallPhys Slider;

    public GameView(Game game, int x, int y) {
        super(game);
        this.ScreenX = x;
        this.ScreenY = y;
        ScreenRatioX = 1980f / ScreenX;
        ScreenRatioY = 1080f / ScreenY;

        Slider = new BallPhys(this, ScreenY, getResources());
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
    if (Slider.Up) {
    Slider.y -= 40 * ScreenRatioY;
    }
    else {
        Slider.y += 30 * ScreenRatioY;
    }
        if (Slider.y < 0)
            Slider.y = 0;

        if (Slider.y >= ScreenY - Slider.height)
            Slider.y = ScreenY - Slider.height;
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {

            Canvas C = getHolder().lockCanvas();
            C.drawBitmap(Slider.Movement(),Slider.x,Slider.y,paint);
            //getHolder().unlockCanvasAndPost(C);
        }
    }
    private void sleep() {
        try {
            Thread.sleep(19);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < ScreenY / 2) {
                    Slider.Up = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                Slider.Up = false;
                if (event.getX() > ScreenY / 2)
                    Slider.moveDir++;
                break;
        }

        return true;
    }
}
