package edu.wit.mobileapp.basketballapp;

import android.content.Context;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    public boolean isPlaying = true;
    private Context context;


    public GameView(Context f) {
        super(f);
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            sleep();
        }
    }

    private void update() {
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
