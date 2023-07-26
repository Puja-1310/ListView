package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MultiAutoComplete extends AppCompatActivity {

    private static final String[] COUNTRIES = new String[]{
            "Afghanistan","Albania","Algeria","Andra","Angola"
    };
    private MultiAutoCompleteTextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_auto_complete);

        editText =findViewById(R.id.mactv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,COUNTRIES);

        editText.setAdapter(adapter);
        editText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    public void showInput(View view){
        String input = editText.getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

    }
}