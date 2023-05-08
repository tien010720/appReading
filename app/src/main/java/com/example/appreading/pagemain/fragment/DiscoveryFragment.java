package com.example.appreading.pagemain.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appreading.R;
import com.example.appreading.adapter.CommentAdapter;
import com.example.appreading.model.CommentModel;
import com.example.appreading.model.HomeItemModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class DiscoveryFragment extends Fragment {
    CommentAdapter commentAdapter;
    ListView listView;
    ArrayList<CommentModel> list;
    String url = "https://wikidth.com/truyen/benh-kieu-xuong-doc-tieu-cung-nu-YEiXlVS4CETMlsRE";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.comment, container, false);
//        listView = root.findViewById(R.id.list_view);
        list = new ArrayList<>();
//        RequestQueue requestQueue = Volley.newRequestQueue(container.getContext());
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                String cmt = "";
//                String img = "";
//                Document document = Jsoup.parse(response);
//                if (document != null){
//                    Elements elements = document.select("div.book-desc-detail");
//                    for (Element element : elements){
//                        Element elemencmt = element.getElementsByTag("p").first();
//                        Element elemenimg = element.getElementsByTag("img").first();
//                        if(elemencmt != null){
//                            cmt = elemencmt.text();
//                        }
//                        if(elemenimg != null){
//                            img = elemenimg.attr("src");
//                        }
//
//                        list.add(new CommentModel(cmt,img));
//                    }
//                    commentAdapter = new CommentAdapter(list, getContext());
//                    listView.setAdapter(commentAdapter);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(stringRequest);

        return root;
    }
}