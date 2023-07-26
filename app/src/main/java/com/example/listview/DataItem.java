package com.example.listview;

public class DataItem {
        private int imageResId;
        private String name;
        private String desc;
    private String time;

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DataItem(int imageResId, String name, String desc, String time) {
        this.imageResId = imageResId;
        this.name = name;
        this.desc = desc;
        this.time = time;
    }


    }


