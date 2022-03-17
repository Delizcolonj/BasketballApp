package edu.wit.mobileapp.basketballapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.score_list);

        Bitmap userIcon = BitmapFactory.decodeResource(getResources(), R.drawable.user_icon); //placeholder

        List<UserRecord> list = new ArrayList<>();

        UserRecord record1 = new UserRecord();
        record1.icon = userIcon;
        record1.name = "John";
        record1.score = 100;
        list.add(record1);

        UserRecord record2 = new UserRecord();
        record2.icon = userIcon;
        record2.name = "Duoduo";
        record2.score = 96;
        list.add(record2);

        UserRecordAdapter adapter = new UserRecordAdapter(this, 0, list);

        ListView listView = findViewById(R.id.ListView01);
        listView.setAdapter(adapter);
    }
}
