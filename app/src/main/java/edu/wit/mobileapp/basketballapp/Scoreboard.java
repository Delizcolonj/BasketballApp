package edu.wit.mobileapp.basketballapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Scoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.score_list);

        ListView listView = findViewById(R.id.ListView01);

        Bitmap userIcon = BitmapFactory.decodeResource(getResources(), R.drawable.user_icon); //placeholder

        List<UserRecord> list = new ArrayList<UserRecord>();

        UserRecord record1 = new UserRecord(userIcon, "John", "60");
        list.add(record1);

        UserRecord record2 = new UserRecord(userIcon,"Duoduo", "96");
        list.add(record2);

        Collections.sort(list, UserRecord.scoreAscending);
        Collections.reverse(list);

        UserRecordAdapter adapter = new UserRecordAdapter(this, 0, list);
        listView.setAdapter(adapter);
    }

}
