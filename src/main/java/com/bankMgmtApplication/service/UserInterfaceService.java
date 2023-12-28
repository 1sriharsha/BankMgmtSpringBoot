package com.bankMgmtApplication.service;

import com.bankMgmtApplication.model.User;

import java.util.ArrayList;

public interface UserInterfaceService {

    User[] usr = new User[10];

    public boolean signUp(User u);

    public boolean logIn(User u);
    public ArrayList<User> showUsers();


//    public int addmoney(User u);
//    public int removemoney(User u);
//    public User showmoney(String u);
//    public void showAllmoney();
}
