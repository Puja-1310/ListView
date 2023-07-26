package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    SharePreference sharedpreferences;
    Button LoginButton, NewUserButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        LoginButton = findViewById(R.id.LoginButton);
        NewUserButton = findViewById(R.id.NewUser);

        sharedpreferences = new SharePreference(getApplicationContext());

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                String savedUsername = sharedpreferences.getUserName();
                String savedPassword = sharedpreferences.getPassword();
                String savedName = sharedpreferences.getName();

                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    sharedpreferences.setFirstLogin(true);
                    openDashboardActivity(savedName,savedUsername);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        NewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }
    private void openDashboardActivity(String name, String username) {
        sharedpreferences.setFirstLogin(false);
        Intent intent = new Intent(LoginActivity.this, DashBoard.class);
        intent.putExtra("name",name);
        intent.putExtra("username",username);
        startActivity(intent);
        finish();
    }
}
//    private boolean checkCredentials(String username, String password) {
//        saveusername = sharedpreferences.getUserName();
//        savePass = sharedpreferences.getPassword();
//
//        return username.equals(saveusername) && password.equals(savePass);
//    }

//        String savedUsername = sharedpreferences.getUserName();
//        String savedPassword = sharedpreferences.getPassword();
//        String name = sharedpreferences.getName();
//        String username = sharedpreferences.getUserName();

//        if (!savedUsername.isEmpty() && !savedPassword.isEmpty()){
//            openDashboardActivity(name,username );
//            return;
//        }

//    private void validation() {
//        boolean isFirstLogin = sharedpreferences.isFirstlogin();
//        if (username.isEmpty()) {
//            usernameEditText.setError("Username cannot be empty");
//            usernameEditText.requestFocus();
//        }
//        else if ((!isFirstLogin) && (!saveusername.equalsIgnoreCase(username))){
//            usernameEditText.setError("User name missmatch");
//            usernameEditText.setText("");
//            usernameEditText.requestFocus();
//        }
//        else if (password.isEmpty()) {
//            passwordEditText.setError("Password cannot be empty");
//            passwordEditText.requestFocus();
//        }
//        else if ((!isFirstLogin )&& (!savePass.equalsIgnoreCase(password))){
//            passwordEditText.setError("Password missmatch");
//            passwordEditText.setText("");
//            passwordEditText.requestFocus();
//        }
//        else {
//                sharedpreferences.saveUsername(username);
//                sharedpreferences.savePass(password);
//                sharedpreferences.setFirstLogin(false);
//                Intent intent = new Intent(LoginActivity.this, DashBoard.class);
//                startActivity(intent);
//                finish();
//        }
//    }
