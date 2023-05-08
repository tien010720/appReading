package com.example.appreading.pagemain.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appreading.R;
import com.vishnusivadas.advanced_httpurlconnection.FetchData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class LoginFragment extends Fragment {
    TextView change_register2;
    ImageView change_register;

    EditText ed_email,ed_password;
    Button button;
    String str_email,str_password;
    String url = "http://192.168.1.113:80/admin/login.php";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login, container, false);
        change_register= root.findViewById(R.id.change_register);
        change_register2= root.findViewById(R.id.change_register2);
        button=root.findViewById(R.id.btn_login);

        ed_email = root.findViewById(R.id.email_login);
        ed_password = root.findViewById(R.id.password_login);
        change_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRegister();
            }
        });
        change_register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRegister();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(v);
            }
        });
        return root;
    }
    public void changeRegister(){
        Fragment mFragment = new RegisterFragment();
        getParentFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, mFragment).commit();
    }

    public void Login(final View view) {

        if(ed_email.getText().toString().equals("")){
            Toast.makeText(view.getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(ed_password.getText().toString().equals("")){
            Toast.makeText(view.getContext(), "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{
            final ProgressDialog progressDialog = new ProgressDialog(view.getContext());
            progressDialog.setMessage("Please Wait..");
            progressDialog.show();

            str_email = ed_email.getText().toString().trim();
            str_password = ed_password.getText().toString().trim();
            final String[] field = new String[2];
                field[0] = "aduser";
                field[1] = "adpassword";
                    //Creating array for data
            final String[] data = new String[2];
                data[0] = str_email;
                data[1] = str_password;
//                    progressBar.setVisibility(View.VISIBLE);
                    //Starting Read data from URL
            Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    PutData putData = new PutData("http://192.168.1.113:80/admin/login1.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
//                                    progressBar.setVisibility(View.GONE);
                            if (result.equals("Login Successfull")) {
                                Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
                                Fragment mFragment = new HomeFragment();
                                getParentFragmentManager().beginTransaction()
                                        .replace(R.id.nav_host_fragment, mFragment).commit();
                            } else {
                                Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });
            };
        }
    }

