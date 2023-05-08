package com.example.appreading.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appreading.R;
import com.example.appreading.model.CommentModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {
    ArrayList<CommentModel> arrayListBook;
    Context context;

    public CommentAdapter(ArrayList<CommentModel> arrayListBook, Context context) {
        this.arrayListBook = arrayListBook;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListBook.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.guide_main,null);
        TextView cmtcmt = (TextView) convertView.findViewById(R.id.cmt);
        ImageView imgimg = (ImageView) convertView.findViewById(R.id.av1);

        CommentModel cmtModel = (CommentModel) getItem(position);
        cmtcmt.setText(cmtModel.cmt);
        Picasso.get()
                .load(cmtModel.img)
                .into(imgimg);
        return convertView;
    }
}
