package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TextSpinner extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textspinner);

        spinner = findViewById(R.id.spinner_1);

        List<User> userList = new ArrayList<>();
        User user1 = new User("Puja",22,"puja@gmail.com");
        userList.add(user1);
        User user2 = new User("Pranati",27,"pranati@gmail.com");
        userList.add(user2);
        User user3 = new User("Rohan",25,"rohan@gmail.com");
        userList.add(user3);
        User user4 = new User("Pradip",30,"pradip@gmail.com");
        userList.add(user4);
        User user5 = new User ("Yogish",27,"yogish@gmail.com");
        userList.add(user5);

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
                android.R.layout.simple_spinner_item,userList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), user.getName()+user.getAge()+user.getMail(), Toast.LENGTH_LONG).show();

//                displayUserData(user);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void getSelectedUser(View view){
        User user = (User) spinner.getSelectedItem();
        displayUserData(user);
    }
    private void displayUserData(User user){
        String name = user.getName();
        int age = user.getAge();
        String mail = user.getMail();

        String UserData = "Name:" +name+ "\nAge: "+age+ "\nMail:" +mail;
        Toast.makeText(this, UserData, Toast.LENGTH_LONG).show();


    }
}