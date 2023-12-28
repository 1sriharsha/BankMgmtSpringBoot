package com.bankMgmtApplication.model;
import java.sql.Date;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
    private int amount;
    private String date;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Transaction(int transactionID, String username, String action, int amount, String date, int balance) {
            this.transactionID = transactionID;
            this.username = username;
            this.action = action;
            this.amount = amount;
            this.date = date;
            this.balance = balance;
    }

    public Transaction() {}
    private String username;
    private String action;//added, removed
    private int balance;
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    @Id
    private int transactionID;
    public int getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int generateRandomTransactionId() {
        Random random = new Random();
        // Ensure the generated ID is positive
        return Math.abs(random.nextInt(100000000));
    }
    public void display(){
        System.out.println("username - "+ username + " | transactionID - "+ transactionID + " | action - "+
                action + " | amount -  "+ amount +" | Balance - "+ balance + "\n");

    }
}
