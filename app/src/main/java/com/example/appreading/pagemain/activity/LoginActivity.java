package com.example.appreading.pagemain.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appreading.R;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class LoginActivity extends AppCompatActivity {
    View day,night;
    TextView dn, dk;
    Button btn_login1, btn_dk;
    DayNightSwitch dayNightSwitch;
//
//    SharedPreferences sharedPreferences = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        day = findViewById(R.id.day_bg);
        night = findViewById(R.id.night_bg);
        dn = findViewById(R.id.dn);
        dk = findViewById(R.id.dk);
        btn_dk = findViewById(R.id.btn_dk);
        btn_login1 = findViewById(R.id.btn_login1);
        dayNightSwitch= findViewById(R.id.day_night_switch);
        dayNightSwitch.setDuration(450);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
                if(isNight)
                {
                    Toast.makeText(LoginActivity.this,"Đăng Nhập",Toast.LENGTH_SHORT).show();
                    day.setAlpha(1f);
                    dn.setVisibility(View.VISIBLE);
                    dk.setVisibility(View.INVISIBLE);
                    btn_login1.setVisibility(View.VISIBLE);
                    btn_dk.setVisibility(View.INVISIBLE);

                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Đăng Ký",Toast.LENGTH_SHORT).show();
                    day.setAlpha(0f);
                    dn.setVisibility(View.INVISIBLE);
                    dk.setVisibility(View.VISIBLE);
                    btn_login1.setVisibility(View.INVISIBLE);
                    btn_dk.setVisibility(View.VISIBLE);
                }
            }
        });



    }
}