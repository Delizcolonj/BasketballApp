package edu.wit.mobileapp.basketballapp;

import android.app.GameManager;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {


private GameView GameV;


    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.game_layout);
        //GameV = new GameView(context this);
        this.GameV = GameV;


    }



}

