package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTxt extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private String[] fruits = {"Apple", "Banana", "Cherry", "Durian", "Elderberry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_txt);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,fruits);

        autoCompleteTextView.setAdapter(adapter);
    }
}