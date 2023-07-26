package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class LoadingScreen extends AppCompatActivity {
     private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        progressBar = findViewById(R.id.progressBar);

        // Update the progress bar
        progressBar.setProgress(90);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}