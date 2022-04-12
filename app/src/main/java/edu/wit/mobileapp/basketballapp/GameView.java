package edu.wit.mobileapp.basketballapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("ViewConstructor")
public class GameView extends SurfaceView implements Runnable {


    private Thread thread;
    public boolean isPlaying;
    private Game game;
    //private Context context;
    private int  ScreenX, ScreenY;
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
        this.isPlaying = true;
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
            //isPlaying=false;
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
        Slider.y += 40 * ScreenRatioY;
    }
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas C = getHolder().lockCanvas();
            C.drawBitmap(Slider.Movement(),Slider.x,Slider.y,paint);
            getHolder().unlockCanvasAndPost(C);
        }
    }
    private void sleep() {
        try {
           Thread.sleep(500);
        }
        catch (InterruptedException e) {
           e.printStackTrace();
        }


    }
}
