package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<DataItem> dataItems;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        dataItems = new ArrayList<>();
        dataItems.add(new DataItem(R.drawable.image, "Murgan Sir"," How are you!!","01:00"));
        dataItems.add(new DataItem(R.drawable.image, "Matin Sir","Fine","12:52"));
        dataItems.add(new DataItem(R.drawable.image, "Naresh Sir","How are you!!","07:12"));
        dataItems.add(new DataItem(R.drawable.image, "Shankar Sir","Fine","05:15 "));
        dataItems.add(new DataItem(R.drawable.image, "Naveen Sir","How are you!!","11:30"));
        dataItems.add(new DataItem(R.drawable.image, "Ratnadeep Sir","Fine","06:00"));
        dataItems.add(new DataItem(R.drawable.image, "Sandesh sir ","How are you!!","07:45"));
        dataItems.add(new DataItem(R.drawable.image, "Yogish sir "," Fine","03:47"));
        dataItems.add(new DataItem(R.drawable.image, "Rohan ","How are you!!","08:19"));
        dataItems.add(new DataItem(R.drawable.image, "Pradip Sir "," Fine","02:55"));
        dataItems.add(new DataItem(R.drawable.image, "Saurabh","How are you!!","10:20"));
        dataItems.add(new DataItem(R.drawable.image, "Ganesh"," Fine","09:32"));
        dataItems.add(new DataItem(R.drawable.image, "Vinaya ","How are you!!","11:42"));
        dataItems.add(new DataItem(R.drawable.image, "Ashwini "," Fine","01:55"));
        dataItems.add(new DataItem(R.drawable.image, "Sarika ","How are you!!","03:39"));
        dataItems.add(new DataItem(R.drawable.image, "Poornima "," Fine","12:59"));
        dataItems.add(new DataItem(R.drawable.image, "Pradnya","How are you!!","05:30"));
        dataItems.add(new DataItem(R.drawable.image, "Mohini"," Fine","06:15"));
        dataItems.add(new DataItem(R.drawable.image, "Puja","How are you!!","11:20"));
        dataItems.add(new DataItem(R.drawable.image, "Pranati"," Fine","02:17"));

        customAdapter = new CustomAdapter(this,dataItems);
        listView.setAdapter(customAdapter);
    }
}
