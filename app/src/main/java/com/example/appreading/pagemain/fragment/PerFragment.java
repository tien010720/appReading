package com.example.appreading.pagemain.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appreading.R;
import com.example.appreading.pagemain.activity.DetailActivity;
import com.example.appreading.pagemain.activity.LoginActivity;

public class PerFragment extends Fragment {
    private Button btn_login_1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.person, container, false);

        btn_login_1 = (Button) root.findViewById(R.id.btn_login_1);
        btn_login_1.setOnClickListener(new View.OnClickListener() {

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
//        Intent intent=new Intent(getContext(), LoginActivity.class);
//        getContext().startActivity(intent);
    }

}
