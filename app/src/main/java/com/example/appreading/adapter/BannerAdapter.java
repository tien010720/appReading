package com.example.appreading.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.appreading.R;
import com.example.appreading.model.HomeItemModel;
import com.example.appreading.pagemain.activity.DetailActivity;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.MyItemViewHolder> implements Filterable {
    private ArrayList<HomeItemModel> list;
    ArrayList<HomeItemModel> listFull;
    Context context;
    public BannerAdapter(Context context, ArrayList<HomeItemModel> list){
        this.list= list;
        this.context=context;
        listFull = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public MyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_item,
                parent, false);
        return new MyItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyItemViewHolder holder, final int position) {
        final HomeItemModel singleItem = list.get(position);
        holder.txtView.setText(singleItem.getName());
        if (singleItem.getImage().isEmpty()) {
            holder.itemImage.setImageResource(R.drawable.book1);
        } else{
            Glide.with(holder.itemImage.getContext())
                    .load(singleItem.getImage())
                    .placeholder(R.drawable.book1)
                    .error(R.drawable.book1)
                    .into(holder.itemImage);
        }
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("pos", singleItem);
                context.startActivity(intent);
            }
        });
        holder.tvAuthor.setText(singleItem.getAuthor());
        holder.tvChap.setText(singleItem.getChap());
        holder.tvContent.setText(singleItem.getContent());
        holder.tvTrangthai.setText(singleItem.getTrangthai());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return FilterTruyen;
    }

    private Filter FilterTruyen = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String searchText = charSequence.toString().toLowerCase();
            ArrayList<HomeItemModel> tempList = new ArrayList<>();
            if(searchText.length()==0 || searchText.isEmpty()){
                tempList.addAll(listFull);
            }
            else {
                for(HomeItemModel item:listFull){
                    if(item.getName().toLowerCase().contains(searchText)){
                        tempList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = tempList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
            list.addAll((Collection<? extends HomeItemModel>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    static class MyItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView txtView, tvAuthor, tvChap, tvContent, tvTrangthai;
        ConstraintLayout layout;

        MyItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.bnImg);
            txtView=itemView.findViewById(R.id.bnTitle);
            layout=itemView.findViewById(R.id.layout6);
            tvChap=itemView.findViewById(R.id.bnAuthor);
            tvContent=itemView.findViewById(R.id.bnContent);
            tvAuthor=itemView.findViewById(R.id.bnChap);
            tvTrangthai=itemView.findViewById(R.id.bnTrangthai);
        }
    }
}