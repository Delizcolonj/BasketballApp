package edu.wit.mobileapp.basketballapp;

import android.graphics.Bitmap;
import java.util.Comparator;

public class UserRecord {
    public Bitmap icon;
    public String name;
    public String score;

    public UserRecord(Bitmap icon, String name, String score) {
        this.icon = icon;
        this.name = name;
        this.score = score;
    }

    public Bitmap getIcon() { return icon; }

    public void setIcon(Bitmap icon) { this.icon = icon; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getScore() { return score; }

    public void setScore(String score) { this.score = score; }

    public static Comparator<UserRecord> scoreAscending = new Comparator<UserRecord>() {
        @Override
        public int compare(UserRecord record1, UserRecord record2) {
            int score1 = Integer.valueOf(record1.getScore());
            int score2 = Integer.valueOf(record2.getScore());
            return Integer.compare(score1, score2);
        }
    };
}
