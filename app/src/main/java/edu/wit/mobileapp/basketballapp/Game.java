package edu.wit.mobileapp.basketballapp;

import android.app.GameManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    private GameView GameV;
    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.game_layout);

        Point p = new Point();
        getWindowManager().getDefaultDisplay().getSize(p);

        GameView GameV2 = new GameView(this, p.x, p.y);
        this.GameV = GameV2;


    }



}

