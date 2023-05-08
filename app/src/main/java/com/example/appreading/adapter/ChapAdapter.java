package com.example.appreading.adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appreading.R;
import com.example.appreading.model.ChapModel;
import com.example.appreading.pagemain.activity.ContentActivity;

import java.util.ArrayList;

public class ChapAdapter extends RecyclerView.Adapter<ChapAdapter.MyViewHolder> {
    private final ArrayList<ChapModel> list;
    Context context;
    public ChapAdapter(Context context, ArrayList<ChapModel> list){
        this.list= list;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chap_item,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ChapModel chapItem = list.get(position);
        holder.txtChap.setText(chapItem.getChap1());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ContentActivity.class);
                intent.putExtra("chap_pos", (Parcelable) chapItem);
                context.startActivity(intent);
            }
        });
        holder.txtContent.setText(chapItem.getContent1());
        holder.txtId.setText(chapItem.getId1());
        holder.txtIdtr.setText(chapItem.getId_tr1());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtChap, txtContent, txtId, txtIdtr;
        ConstraintLayout layout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.layout_chap);
            txtChap=itemView.findViewById(R.id.chap_item);
            txtContent=itemView.findViewById(R.id.content1);
            txtId=itemView.findViewById(R.id.id_chap);
            txtIdtr=itemView.findViewById(R.id.idtruyen1);
        }
    }
}