package edu.wit.mobileapp.basketballapp;

import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    private GameView GameV;

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        //setContentView(R.layout.game_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point p = new Point();
        getWindowManager().getDefaultDisplay().getSize(p);

        GameV= new GameView(this, p.x, p.y);

        setContentView(GameV);

    }
    @Override
    protected void onPause() {
        super.onPause();
        GameV.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GameV.resume();
    }
}


