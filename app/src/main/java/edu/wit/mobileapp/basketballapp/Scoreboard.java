package edu.wit.mobileapp.basketballapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Scoreboard extends AppCompatActivity {

    private String databaseURL = "https://basketballapp-scoreboard-default-rtdb.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.score_list);

        ListView listView = findViewById(R.id.ListView01);

        List<UserRecord> list = new ArrayList<>();
        Bitmap userIcon = BitmapFactory.decodeResource(getResources(), R.drawable.user_icon);
        UserRecordAdapter adapter = new UserRecordAdapter(this, 0, list);

        //writeScore();

        FirebaseDatabase database = FirebaseDatabase.getInstance(databaseURL);
        DatabaseReference myRef = database.getReference("score");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String score = dataSnapshot.getValue().toString();
                score = score.replaceAll("[^?0-9]+", "");
                List<String> scoreList = Arrays.asList(score.trim().split(""));
                for (int i = 0; i < scoreList.size(); i++) {
                    UserRecord record = new UserRecord(userIcon, scoreList.get(i));
                    list.add(record);
                }
                adapter.notifyDataSetChanged();
                Collections.sort(list, UserRecord.scoreAscending);
                Collections.reverse(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        listView.setAdapter(adapter);

    }

    private void writeScore() {
        FirebaseDatabase database = FirebaseDatabase.getInstance(databaseURL);
        DatabaseReference myRef = database.getReference("score");
        String uuid = UUID.randomUUID().toString().replaceAll("[0-9]", "");
        myRef.child("" + uuid).setValue(3);
    }
}
