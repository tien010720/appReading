package com.example.appreading.pagemain.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appreading.R;

public class RegisterFragment extends Fragment {
    TextView change_login2;
    ImageView change_login;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.register, container, false);
        change_login= root.findViewById(R.id.change_login);
        change_login2= root.findViewById(R.id.change_login2);
        change_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLogin();
            }
        });
        change_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLogin();
            }
        });
        return root;
    }

    public void changeLogin(){
        Fragment mFragment = new LoginFragment();
        getParentFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, mFragment).commit();
    }
}
