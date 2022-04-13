package edu.wit.mobileapp.basketballapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserRecordAdapter extends ArrayAdapter<UserRecord> {

    private LayoutInflater mInflater;

    public UserRecordAdapter(Context context, int rid, List<UserRecord> list){
        super(context, rid, list);
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        UserRecord record = getItem(position);

        View view = mInflater.inflate(R.layout.user_record, null);

        ImageView icon = view.findViewById(R.id.icon);
        icon.setImageBitmap(record.icon);

        TextView score = view.findViewById(R.id.score);
        score.setText(record.score);

        return view;
    }
}
