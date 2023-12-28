package com.bankMgmtApplication.service;

import com.bankMgmtApplication.model.User;
import com.bankMgmtApplication.model.UserBalance;

import java.util.ArrayList;

public interface UserBalanceInterface {

    UserBalance[] usr = new UserBalance[10];
    public int getUserTotalBalance(String username);

    public  void updateTotalBalance(String username, int amount, String action);
}