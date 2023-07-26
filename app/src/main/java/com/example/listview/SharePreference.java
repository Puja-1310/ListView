package com.example.listview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
public class SharePreference {

    SharedPreferences sharedpreferences;
    Editor editor;
    public final String MyPREFERENCES = "BasicPref";
    Context context;
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_FIRST_LOGIN = "first_login";

    public SharePreference(Context context) {
        this.context = context;
        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }
    public boolean isFirstLogin() {
        return sharedpreferences.getBoolean(KEY_FIRST_LOGIN, true);
    }

    public void setFirstLogin(boolean isFirstLogin) {
        sharedpreferences.edit().putBoolean(KEY_FIRST_LOGIN, isFirstLogin).apply();
    }

    public String getUserName() {
        return sharedpreferences.getString(KEY_USERNAME, "");
    }

    public void saveUsername(String username) {
        sharedpreferences.edit().putString(KEY_USERNAME, username).apply();
    }

    public String getPassword() {
        return sharedpreferences.getString(KEY_PASSWORD, "");
    }

    public void savePassword(String password) {
        sharedpreferences.edit().putString(KEY_PASSWORD, password).apply();
    }
    public String getName(){
        return sharedpreferences.getString("Name","");
    }
   public void savedName(String  name){
        sharedpreferences.edit().putString("Name",name).apply();
   }

    public String getGender() {
        return sharedpreferences.getString("Gender","");
    }

    public String getReTypePassword() {
        return sharedpreferences.getString("ReTypePassword","");
    }
}

//    public String getUserName() {
//        return sharedpreferences.getString("user_name", null);
//    }
//
//    public String getUSerPass() {
//        return sharedpreferences.getString("User_Pass", null);
//    }
//
//    public void savename(String name) {
//        editor.putString("Name", name);
//        editor.commit();
//    }
//


//    public void savePass(String pass) {
//        editor.putString("User_Pass", pass);
//        editor.commit();
//    }
//
//    public void savedesc(String desc) {
//        editor.putString("User_desc", desc);
//        editor.commit();
//    }
//    public void savetime(String time) {
//        editor.putString("User_Time", time);
//        editor.commit();
//    }
//    public String getDesc() {
//        return sharedpreferences.getString("User_desc", "");
//    }
//    public String getTime() {
//        return sharedpreferences.getString("User_Time", "");
//    }

//    public String getMiddleName() {
//        return sharedpreferences.getString("middle_name","");
//    }
//






