package com.example.memorygame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class SimpleAdapter extends ArrayAdapter {

    List<String> mItems;
    Context mContext;

    public SimpleAdapter(Context context, List<String> objects) {
        super(context, R.layout.layout_item, objects);
        mItems = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
        }

        TextView textView = convertView.findViewById(R.id.textLayoutItem);

        textView.setText(mItems.get(position));

        return convertView;
    }


}
