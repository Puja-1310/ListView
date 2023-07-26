package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {
    TextView textView;
    SharePreference sharedpreferences;
String name,desc,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        sharedpreferences = new SharePreference(getApplicationContext());

        textView = findViewById(R.id.textView);
//        Intent intent = getIntent();
//        // Retrieve the selected data item from the intent
//        String name = intent.getStringExtra("name");
//        String desc = intent.getStringExtra("desc");
//        String time = intent.getStringExtra("time");


//         String name = sharedpreferences.getName();
//         String desc = sharedpreferences.getDesc();
//         String time = sharedpreferences.getTime();

//        DataItem selectedDataItem = getIntent().getParcelableExtra("selectedDataItem");

                    textView.setText(name +desc +time);
                }
            }
