//package com.bankMgmtApplication.service;
//
//import com.bankMgmtApplication.dao.bankdao;
//import com.bankMgmtApplication.dao.bankdaoInterface;
//import com.bankMgmtApplication.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//@Service
//public class UserService implements UserInterfaceService{
//    @Autowired
//    bankdaoInterface bdao = new bankdao();
//    @Override
//    public int signUp(User u){
//        return bdao.signUp(u);
//    }
//
//    public boolean logIn(User u){
//
//        return bdao.logIn(u);
//    }
//    @Override
//    public ArrayList<User> showUsers() {
//
//        return (ArrayList<User>) bdao.showUsers();
//    }
//
//
//}
package com.bankMgmtApplication.service;

import com.bankMgmtApplication.dao.bankdaoInterface;
import com.bankMgmtApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserInterfaceService {

    @Autowired
    private bankdaoInterface bdao;

    @Override
    public boolean signUp(User u) {return bdao.signUp(u);}

    @Override
    public boolean logIn(User u) {
        return bdao.logIn(u);
    }

    @Override
    public ArrayList<User> showUsers() {
        return (ArrayList<User>) bdao.showUsers();
    }
}
