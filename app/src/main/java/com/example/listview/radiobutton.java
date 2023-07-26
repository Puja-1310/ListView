package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class radiobutton extends AppCompatActivity {
    RadioButton android, java, angular, python;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        android=(RadioButton) findViewById(R.id.rdbAndroid);
        java=(RadioButton) findViewById(R.id.rdbJava);
        angular=(RadioButton) findViewById(R.id.rdbAngular);
        python=(RadioButton) findViewById(R.id.rdbPython);
        btn = (Button)findViewById(R.id.getBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected Course: ";
                result+= (android.isChecked())? "Android":(angular.isChecked())? "Angular":(java.isChecked())? "Java":(python.isChecked())? "Python": "";

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";

        int viewId = view.getId();
        if (viewId == R.id.rdbAndroid)
        {
            if (checked) {
                str = "Android Selected";
            }
        } else if (viewId == R.id.rdbAngular) {
            if (checked) {
                str = "AngularJS Selected";
            }
        } else if (viewId == R.id.rdbJava) {
            if (checked) {
                str = "Java Selected";
            }
        } else if (viewId == R.id.rdbPython) {
            if (checked) {
                str = "Python Selected";
            }
        }

        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}