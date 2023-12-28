package com.bankMgmtApplication.service;

import com.bankMgmtApplication.dao.bankdao;
import com.bankMgmtApplication.model.Transaction;
import com.bankMgmtApplication.model.UserBalance;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements TransactionServiceInterface {

    @Autowired
    private bankdao bdao;

    @Autowired
    private UserBalanceInterface ubs;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    UserBalance ub = new UserBalance();

    @Override
    public void addAmount(Transaction t) {
        System.out.println("ts.getamount" + t.getAmount());
        t.setAction("Added");
        ubs.updateTotalBalance(t.getUsername(), t.getAmount(), t.getAction());

        // Send a Kafka message when amount is added
        kafkaTemplate.send("transaction-topic", "Amount Added for user: " + t.getUsername());

        int updatedBalance = ubs.getUserTotalBalance(t.getUsername());
        System.out.println("Updated balance: " + updatedBalance);
        t.setBalance(updatedBalance);
        t.setTransactionID(t.generateRandomTransactionId());
        bdao.addAmount(t);
    }

    @Override
    public void withdrawAmount(Transaction t) {
        t.setAction("withdraw");
        ubs.updateTotalBalance(t.getUsername(), t.getAmount(), t.getAction());
        int updatedBalance = ubs.getUserTotalBalance(t.getUsername());
        t.setBalance(updatedBalance);
        t.setTransactionID(t.generateRandomTransactionId());
        bdao.withdrawAmount(t);
    }

    @Override
    public ArrayList<Transaction> showBalance(String username) {
        System.out.println("yeah man im here");

        // Send a Kafka message when showing balance
        kafkaTemplate.send("transaction-topic", "Showing Balance for user: " + username);

        return (ArrayList<Transaction>) bdao.showBalance(username);
    }
}
