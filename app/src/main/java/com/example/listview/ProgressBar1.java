package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBar1 extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int valueProgress=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

      progressBar=findViewById(R.id.progress2);
      textView=findViewById(R.id.text1);
        UpdateProgress();
    }
    private  void UpdateProgress(){
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        progressBar.setProgress(valueProgress);
        textView.setText(valueProgress+ "%");
        if (valueProgress==100)
        {
            Toast.makeText(this, "Process Finished", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            valueProgress=0;
        }
    }
//    public void decrease(View view) {
//        if (valueProgress >= 20){
//            valueProgress-=20;
//            UpdateProgress();
//        }
//    }
    public void increase(View view) {
//        if (valueProgress <= 10){
            valueProgress+=10;
            UpdateProgress();
//        }
    }
}