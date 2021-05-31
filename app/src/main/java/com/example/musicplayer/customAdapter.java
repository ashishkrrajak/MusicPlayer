package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class customAdapter extends ArrayAdapter<String> {

    private String[] items;
    private Context context;
    public static  final String Extra_Name ="com.example.musicplayer.extra.NAME";

    public customAdapter(@NonNull Context context, int resource, @NonNull String[] items) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return items[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_listview,parent,false);
        TextView t = convertView.findViewById(R.id.songName1);
        t.setText(getItem(position));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click on"+getItem(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,MainActivity2.class);
                String currentSong = getItem(position).toString();
                intent.putExtra("songList",items);
                intent.putExtra("currentSong",currentSong);
                intent.putExtra("position",position);
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}
