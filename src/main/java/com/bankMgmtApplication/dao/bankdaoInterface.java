package com.bankMgmtApplication.dao;

import com.bankMgmtApplication.model.Transaction;
import com.bankMgmtApplication.model.User;
import com.bankMgmtApplication.model.UserBalance;

import java.util.List;

public interface bankdaoInterface {

    public boolean signUp(User u);
    public boolean logIn(User u);
    public List<User> showUsers();
    public int addAmount(Transaction t);
    public int withdrawAmount(Transaction t);
//    public List<Transaction> showBalance();

    public int getUserTotalBalance(String username);

    public void updateTotBalance(String username, int balance, String action);
    public List<Transaction> showBalance(String username);
}
