package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000;
    SharePreference sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sharedpreferences = new SharePreference(getApplicationContext());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isFirstLogin = sharedpreferences.isFirstLogin();
                if (isFirstLogin) {
                    Intent intent = new Intent(splashScreen.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(splashScreen.this, DashBoard.class);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_DURATION);
    }
}