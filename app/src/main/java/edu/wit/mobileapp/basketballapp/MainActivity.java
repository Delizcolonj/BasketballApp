package edu.wit.mobileapp.basketballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play_butn = (Button)findViewById(R.id.btn_play);
        Button score_butn = (Button)findViewById(R.id.btn_score);
        Button exit_butn = (Button)findViewById(R.id.btn_exit);

        TextView MainTitle = (TextView)findViewById(R.id.txt_title);
    }
}