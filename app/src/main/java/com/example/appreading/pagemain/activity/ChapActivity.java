package com.example.appreading.pagemain.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appreading.R;
import com.example.appreading.adapter.ChapAdapter;
import com.example.appreading.adapter.HomeAdapter;
import com.example.appreading.model.ChapModel;
import com.example.appreading.model.HomeItemModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ChapActivity extends AppCompatActivity {
    TextView chap_main, chap_content;
    public static ArrayList<ChapModel> singleItem=new ArrayList<>();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chap);
        RecyclerView mRecyclerView = findViewById(R.id.list_chap);
        ChapAdapter adapter = new ChapAdapter(this,singleItem);

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        JsonFetch jsonFetch =new JsonFetch();
        jsonFetch.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("StaticFieldLeak")
    public class JsonFetch extends AsyncTask<String,String,String> {

        HttpURLConnection httpURLConnection=null;
        String f_main;

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://192.168.1.113:80/" +
                        "admin/select2.php");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new
                        BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuffer = new StringBuilder();
                String line;
                while((line=bufferedReader.readLine())!=null){
                    stringBuffer.append(line);
                }
                f_main=stringBuffer.toString();

                JSONArray jsonArray=new JSONArray(f_main);
                for(int j = 0; j < jsonArray.length(); j++){
                    JSONObject jsonObject=jsonArray.getJSONObject(j);
                    String id = jsonObject.getString("id");
                    String idtr = jsonObject.getString("idtruyen");
                    String chap = jsonObject.getString("chuong");
                    String noidung = jsonObject.getString("noidung");
                    ChapModel chapModel=new ChapModel(id, chap, noidung, idtr);
                    singleItem.add(chapModel);
                }

            }
            catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
