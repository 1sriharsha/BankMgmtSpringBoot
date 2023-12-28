package com.bankMgmtApplication.service;


import com.bankMgmtApplication.dao.bankdao;
import com.bankMgmtApplication.model.User;
import com.bankMgmtApplication.model.UserBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserBalanceService implements UserBalanceInterface {

    @Autowired
    private bankdao bdao;

    @Override
    public int getUserTotalBalance(String username) {
        return bdao.getUserTotalBalance(username);
    }

    @Override
    public void updateTotalBalance(String username, int amount, String action) {
        bdao.updateTotBalance(username,amount,action);
    }
}
