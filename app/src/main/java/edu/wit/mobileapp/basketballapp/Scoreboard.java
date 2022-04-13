package edu.wit.mobileapp.basketballapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scoreboard extends AppCompatActivity {

    private String score;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.score_list);

        Button home_btn = (Button)findViewById(R.id.button4);

        ListView listView = findViewById(R.id.ListView01);

        Bitmap userIcon = BitmapFactory.decodeResource(getResources(), R.drawable.user_icon);

        List<UserRecord> list = new ArrayList<UserRecord>();

        writeFile();

        score = readFile();
        UserRecord record = new UserRecord(userIcon, score);
        list.add(record);

        Collections.sort(list, UserRecord.scoreAscending);
        Collections.reverse(list);

        UserRecordAdapter adapter = new UserRecordAdapter(this, 0, list);
        listView.setAdapter(adapter);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Scoreboard.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void writeFile() {
        String score = "88";

        try {
            FileOutputStream fileOutputStream = openFileOutput("scoreHistory.txt", MODE_PRIVATE);
            fileOutputStream.write(score.getBytes());
            fileOutputStream.close();

            Log.v("myApp", "score saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFile() {
        try {
            FileInputStream fileInputStream = openFileInput("scoreHistory.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            Log.v("myApp", "score = " + stringBuffer.toString());
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
