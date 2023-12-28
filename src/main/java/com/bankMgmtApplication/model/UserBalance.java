package com.bankMgmtApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserBalance")  // Specify the table name
public class UserBalance {

    @Id
    private String username;
    private int balance;

    public UserBalance(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    public UserBalance() {

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
