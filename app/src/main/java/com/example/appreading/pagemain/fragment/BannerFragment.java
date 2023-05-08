package com.example.appreading.pagemain.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appreading.R;
import com.example.appreading.adapter.BannerAdapter;
import com.example.appreading.adapter.HomeAdapter;
import com.example.appreading.model.BannerModel;
import com.example.appreading.model.HomeItemModel;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

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
import java.util.List;
import java.util.Locale;

public class BannerFragment extends Fragment {
    SliderLayout sliderLayout;
    List<BannerModel> list_dataList;

    private static final int RESULT_OK = 1;
    public static ArrayList<HomeItemModel> singleItem = new ArrayList<>();
    BannerAdapter myAdapter;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.banner, container, false);
        sliderLayout = root.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.WORM);

        list_dataList = new ArrayList<>();
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews(container);
        RecyclerView mRecyclerView = root.findViewById(R.id.listbanner);
        myAdapter = new BannerAdapter(container.getContext(),singleItem);

        setHasOptionsMenu(true);

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(container.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(myAdapter);

        JsonFetch jsonFetch =new JsonFetch();
        jsonFetch.execute();
        return root;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText.toString());
                return false;
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    public class JsonFetch extends AsyncTask<String,String,String> {

        HttpURLConnection httpURLConnection=null;
        String f_main;

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://192.168.1.113:80/" +
                        "admin/select1.php");
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
                    String id =jsonObject.getString("id_truyen");
                    String name = jsonObject.getString("title");
                    String image = jsonObject.getString("anh");
                    String content = jsonObject.getString("content");
                    String author = jsonObject.getString("tacgia");
                    String trangthai = jsonObject.getString("phanloai");
                    String chap = jsonObject.getString("trangthai");
                    HomeItemModel homeItemModel=new HomeItemModel(id, name, image, author,
                            trangthai, chap, content);
                    singleItem.add(homeItemModel);
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
    private void setSliderViews(View v) {
        list_dataList.add(new BannerModel("https://i.pinimg.com/736x/20/1a/c4/201ac4246b9ffdbce79872dc6fa47f06.jpg?q=60"));
        list_dataList.add(new BannerModel("https://i.pinimg.com/originals/db/30/f3/db30f3efc80eb3dff371fe57a5453fa0.jpg"));
        list_dataList.add(new BannerModel("https://wallpaperaccess.com/full/133878.jpg"));
        list_dataList.add(new BannerModel("https://cutewallpaper.org/21/cute-wallpapers-pc/Cute-Cartoon-Adventure-Time-Wallpaper-Background-Wallpaper-HD.png"));
        setupdata(list_dataList);
    }
    private void setupdata(List<BannerModel> list_dataList) {

        for (int i = 0; i <= 3; i++) {
            final BannerModel ld = list_dataList.get(i);
            SliderView sliderView = new SliderView(getContext());
            sliderView.setImageUrl(ld.getImg());

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);

        }
    }
}
