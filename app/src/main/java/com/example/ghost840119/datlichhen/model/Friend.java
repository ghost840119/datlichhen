package com.example.ghost840119.datlichhen.model;

/**
 * Created by ghost840119 on 6/10/2017.
 */

public class Friend {
    String Name;
    String userName;
    String ImgUser;

    public Friend(String name, String userName, String imgUser) {
        Name = name;
        this.userName = userName;
        ImgUser = imgUser;
    }

    public Friend() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgUser() {
        return ImgUser;
    }

    public void setImgUser(String imgUser) {
        ImgUser = imgUser;
    }
}
