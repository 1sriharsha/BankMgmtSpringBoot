package com.bankMgmtApplication.service;
import com.bankMgmtApplication.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface TransactionServiceInterface {
    Transaction[] trns = new Transaction[20];

    public void addAmount(Transaction t);
    public void withdrawAmount(Transaction t);
    public ArrayList<Transaction> showBalance(String username);
}
