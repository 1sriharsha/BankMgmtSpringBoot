//package com.bankMgmtApplication.controller;
//
//import com.bankMgmtApplication.model.User;
//import com.bankMgmtApplication.model.Transaction;
//import com.bankMgmtApplication.dao.bankdao;
//import com.bankMgmtApplication.dao.bankdaoInterface;
//import com.bankMgmtApplication.service.TransactionService;
//import com.bankMgmtApplication.service.TransactionServiceInterface;
//import com.bankMgmtApplication.service.UserInterfaceService;
//import com.bankMgmtApplication.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.bankMgmtApplication.model.Transaction;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.ui.Model;
//import java.util.ArrayList;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class BmsController {
//    @Autowired
//    private TransactionService ts;
//    @Autowired
//    private UserService us;
//    bankdaoInterface bdao = new bankdao();
//    public void setts(TransactionServiceInterface ts) {this.ts = (TransactionService) ts;}
//    public void setts(UserInterfaceService us) {this.us = (UserService) us;}
//    @RequestMapping("/hello")
//    public String hello() {
//        return "Hello, Harsha this is test for your Spring Boot application!";
//    }
//    @RequestMapping("/")
//    public String mainPage()
//    {
//        System.out.println("printing from printer");
//        return "login";
//    }
//
//    @RequestMapping("/loggingIn")
//    public String loggingIn(HttpSession session, @RequestParam("username")String username, @RequestParam("password")String password, Model model) {
//        System.out.println(username+","+password);
//        User u = new User();
//        u.setUsername(username);
//        u.setpassword(password);
//        boolean isAuthenticated = us.logIn(u);
//        if (isAuthenticated) {
////            model.addAttribute("username", username);
//            session.setAttribute("username", username);
//            return "redirect:/homepage";
//        } else {
//            System.out.println("I came here to login page again");
//            return "login"; // Refers to login.jsp in the /WEB-INF/jsp/ directory
//        }
//    }
//
//    @RequestMapping("/home")
//    public String home() {
//        return "home";
//    }
//    @RequestMapping("/homepage")
//    public String home(HttpSession session, Model model) {
//        // Get the logged-in user's information
//        String username = (String) session.getAttribute("username");
//
//        System.out.println("I came here to homepage"+username);
//        if (username != null && !username.isEmpty()) {
//            // Fetch user's balance
//            System.out.println("I came here to homepage"+username);
//            int userBalance = bdao.getUserTotalBalance(username);
//
//            // Fetch user's previous transactions
//            ArrayList<Transaction> userTransactions = ts.ShowBalance(username);
//            System.out.println("User Transactions Size: " + userTransactions.size());
//            model.addAttribute("userBalance", userBalance);
//            model.addAttribute("userTransactions", userTransactions);
//            session.setAttribute("username", username);
//            return "home";
//        } else {
//            // Redirect to the login page if the username is not available
//            return "redirect:/";
//        }
//    }
//    @RequestMapping("/creditamount")
//    public String addamount(@RequestParam("amount")int amount, @RequestParam("transactionDate") String transactionDate, HttpSession session)
//    {
//        String username = (String) session.getAttribute("username");
//        System.out.println("Adding amount for " + username + ": " + amount +" on : "+transactionDate);
//        Transaction t = new Transaction();
//        t.setUsername(username);
//        t.setAmount(amount);
//        t.setDate(transactionDate);
//        ts.addAmount(t);
//        return "redirect:/homepage";
//    }
//    @RequestMapping("/withdrawamount")
//    public String withdrawamount(@RequestParam("amount")int amount, @RequestParam("transactionDate") String transactionDate, HttpSession session)
//    {
//        String username = (String) session.getAttribute("username");
//        System.out.println("withdrawn amount for " + username + ": " + amount +" on : "+transactionDate);
//        Transaction t = new Transaction();
//        t.setUsername(username);
//        t.setAmount(amount);
//        t.setDate(transactionDate);
//        ts.withdrawAmount(t);
//        return "redirect:/homepage";
//    }
//
//
//}
package com.bankMgmtApplication.controller;

import com.bankMgmtApplication.model.User;
import com.bankMgmtApplication.model.Transaction;
import com.bankMgmtApplication.model.UserBalance;
import com.bankMgmtApplication.service.TransactionServiceInterface;
import com.bankMgmtApplication.service.UserBalanceInterface;
import com.bankMgmtApplication.service.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bankMgmtApplication.dao.bankdao;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BmsController {

    @Autowired
    private TransactionServiceInterface ts;
    @Autowired
    private UserInterfaceService us;
    @Autowired
    private bankdao bdao;

    @Autowired
    private UserBalanceInterface  ubs;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Harsha this is a test for your Spring Boot application!";
    }

    @RequestMapping("/")
    public String mainPage() {
//        System.out.println("Printing from printer");
        return "login";
    }

    @RequestMapping("/loggingIn")
    public String loggingIn(HttpSession session, @RequestParam("username") String username,
                            @RequestParam("password") String password, Model model) {
//        System.out.println(username + "," + password);
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        boolean isAuthenticated = us.logIn(u);
        if (isAuthenticated) {
            session.setAttribute("username", username);
            return "redirect:/homepage";
        } else {
            return "login";
        }
    }
    @RequestMapping("/signingUp")
    public String signingUp(HttpSession session, @RequestParam("signup-username") String username,
                            @RequestParam("signup-email") String useremail,
                            @RequestParam("signup-dob") String userdob,
                            @RequestParam("signup-password") String password,
                            Model model) {
//        System.out.println(useremail+" , "+username + " , " +userdob +" , "+ password);
        User u = new User();
        u.setUsername(username);
        u.setUseremail(useremail);
        u.setUserdob(userdob);
        u.setPassword(password);
        boolean issignedup = us.signUp(u);

        if (issignedup) {
            session.setAttribute("username", username);
            return "redirect:/homepage";
        } else {
            return "login";
        }
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/homepage")
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");

//        System.out.println("I came here to homepage" + username);
        if (username != null && !username.isEmpty()) {
            UserBalance ub = new UserBalance();
            ub.setUsername(username);
            int userBalance = bdao.getUserTotalBalance(username);
            List<Transaction> userTransactions = ts.showBalance(username);
//            System.out.println("User Transactions Size: " + userTransactions.size());
            model.addAttribute("username", username);
            model.addAttribute("userBalance", userBalance);
            model.addAttribute("userTransactions", userTransactions);
            session.setAttribute("username", username);
            return "home";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/creditamount")
    public String addamount(@RequestParam("amount") int amount, @RequestParam("transactionDate") String transactionDate,
                            HttpSession session) {
        String username = (String) session.getAttribute("username");
//        System.out.println("Adding amount for " + username + ": " + amount + " on : " + transactionDate);
        Transaction t = new Transaction();
        t.setUsername(username);
        t.setAmount(amount);
        t.setDate(transactionDate);
        ts.addAmount(t);
        return "redirect:/homepage";
    }

    @RequestMapping("/withdrawamount")
    public String withdrawamount(@RequestParam("amount") int amount, @RequestParam("transactionDate") String transactionDate,
                                 HttpSession session) {
        String username = (String) session.getAttribute("username");
//        System.out.println("Withdrawn amount for " + username + ": " + amount + " on : " + transactionDate);
        Transaction t = new Transaction();
        t.setUsername(username);
        t.setAmount(amount);
        t.setDate(transactionDate);
        ts.withdrawAmount(t);
        return "redirect:/homepage";
    }
}
