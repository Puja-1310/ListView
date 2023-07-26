package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class checkbox extends AppCompatActivity {
    CheckBox ch1,ch2,ch3,ch4;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        ch1=(CheckBox) findViewById(R.id.checkBox1);
        ch2=(CheckBox) findViewById(R.id.checkBox2);
        ch3=(CheckBox) findViewById(R.id.checkBox3);
        ch4=(CheckBox) findViewById(R.id.checkBox4);
        btn=(Button) findViewById(R.id.Btn_submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected Hobbies: ";

                    if (ch1.isChecked())
                        result+= "\nDancing";
                    if (ch2.isChecked())
                        result+= "\nCooking";
                    if (ch3.isChecked())
                        result+= "\nPainting";
                    if (ch4.isChecked())
                        result+= "\nReading";

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                }
        });
    }
    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        String str="";

        int ViewID= view.getId();
        if (ViewID == R.id.checkBox1)
        {
            if (checked) {
                str = checked ? "Dancing Selected" : "Dancing Deselected";
            }
        }else if (ViewID == R.id.checkBox2) {
            if (checked) {
                str = checked ? "Cooking Selected" : "Cooking Deselected";
            }
        } else if (ViewID == R.id.checkBox3) {
            if (checked) {
                str = checked ? "Painting Selected" : "Painting Deselected";
            }
        } else if (ViewID == R.id.checkBox4) {
            if (checked) {
                str = checked ? "Reading Selected" : "Reading Deselected";
            }
        }
    }
}