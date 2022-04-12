package edu.wit.mobileapp.basketballapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

public class GameView extends SurfaceView implements Runnable {


    private Thread thread;
    public boolean isPlaying = true;
    private Context context;
    int ScreenX;
    int ScreenY;
    private Paint paint;
    public float ScreenRatioX;
    public float ScreenRatioY;
    private BallPhys Slider;

    public GameView(Context f, int x, int y) {
        super(f);
        this.ScreenX = x;
        this.ScreenY = y;
        ScreenRatioX = 1980f / ScreenX;
        ScreenRatioY = 1080f / ScreenY;
        Slider = new BallPhys(ScreenY, getResources());
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    private void update() {
    if (Slider.Up) {
    Slider.y -= 40 * ScreenRatioY;
    }
    else {
        Slider.y += 30 * ScreenRatioY;
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
            Thread.sleep(19);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
