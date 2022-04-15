package edu.wit.mobileapp.basketballapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;


public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    private Game game;
    //private Context context;
    private int ScreenX, ScreenY;
    private Paint paint;
    public static float ScreenRatioX;
    public static float ScreenRatioY;
    private BallPhys Slider;
    private Background background1;
    private Hoop hoop;
    boolean go = false;
    int score;
    int lives;

    public GameView(Game game, int x, int y) {

        super(game);
        this.lives = 3;
        this.score = 0;
        this.game = game;

        this.ScreenX = x;
        this.ScreenY = y;
        ScreenRatioX = 1980f / ScreenX;
        ScreenRatioY = 1080f / ScreenY;

        background1 = new Background(ScreenX, ScreenY, getResources());
        //background1.x = ScreenX;

        hoop = new Hoop(getResources());

        Slider = new BallPhys(this, ScreenY, getResources());

        paint = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.WHITE);
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

    public void resume(){
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
    private void ballReset(){
        Slider.x = (int) (64 * ScreenRatioX);
        Slider.y = ScreenY/2;
        go=false;
        Slider.Up = false;
    }
    public boolean DidItMakeIt(){
        if (Slider.y <= (int) (200*ScreenRatioY)) {
            return true;
        }

        return false;
    }
    private void update() {
        if (Slider.x >= (int) (1150 * ScreenRatioX)) {
            if (DidItMakeIt()) {
                score = score + 1;
                ballReset();
            }
        }

        if (Slider.x >= ScreenX - Slider.width) {
         ballReset();
         lives = lives -1;
            if (lives == 0) {
                        //INTRODUCE CLASS SWAP HERE
            }
        }
        //Keeps the ball moving to the right
        if (go) {
            Slider.x += 55 * ScreenRatioX;
        } else {


            if (background1.x + background1.background.getWidth() < 0) {
                background1.x = ScreenX;
            }
            if (Slider.Up) {
                Slider.y += (20+score*2) * ScreenRatioY;
            } else {
                Slider.y -= (20+score*2) * ScreenRatioY;
            }
            if (Slider.y < 0) {
                Slider.y = 0;
                Slider.Up = true;
            }
            if (Slider.y >= (ScreenY - Slider.height)) {
                Slider.y = ScreenY - Slider.height;
                Slider.Up = false;
            }
        }
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {

            Canvas C = getHolder().lockCanvas();

            C.drawBitmap(background1.background, background1.x, background1.y, paint);
            C.drawBitmap(Slider.Movement(),Slider.x,Slider.y, paint);
            C.drawBitmap(hoop.getHoop(), hoop.x, hoop.y, paint);

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

    public void newBall() {
        BallPhys Slider2 = new BallPhys(this, ScreenY, getResources());
        Slider2.y = Slider.y + (Slider.height/2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getY() < ScreenY / 2) {
               //     Slider.Up = true;
                    go = true;
                }
                break;
            case MotionEvent.ACTION_UP:
         //       Slider.Up = false;
                if (event.getY() > ScreenY / 2)
                    Slider.moveDir++;
                break;
        }

        return true;
    }
}
