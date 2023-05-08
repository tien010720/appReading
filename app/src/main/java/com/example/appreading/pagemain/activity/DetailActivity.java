package com.example.appreading.pagemain.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.appreading.R;
import com.example.appreading.model.HomeItemModel;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    ImageView image;
    TextView title, author, trangthai, content, chap;
    HomeItemModel position;
    Button button;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);

        image       = findViewById(R.id.image_detail);
        title       = findViewById(R.id.title_detail);
        author      = findViewById(R.id.author_detail);
        chap        = findViewById(R.id.chap_detail);
        content     = findViewById(R.id.content_detail);
        trangthai   = findViewById(R.id.trangthai_detail);
        button      = findViewById(R.id.btn_read);
        position = getIntent().getParcelableExtra("pos");

        assert position != null;
        title.setText(position.getName());
        Log.i("TAG", "onCreate: " + position.getImage());
        if (position.getImage().isEmpty()) {
            image.setImageResource(R.drawable.galaxy1);
        } else {
            Glide.with(this).load(position.getImage()).into(image);
        }
        author.setText("Tác giả: "+position.getAuthor());
        trangthai.setText("Trạng thái: "+position.getTrangthai());
        content.setText("Mô tả: "+position.getContent());
        chap.setText("Số chương: "+position.getChap());
        button.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ChapActivity.class);
            intent.putExtra("pos1",position.getId());
            startActivity(intent);
        });
    }
}
