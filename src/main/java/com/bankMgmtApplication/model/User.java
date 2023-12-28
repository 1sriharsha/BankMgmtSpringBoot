package com.bankMgmtApplication.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    public static int usercount;
    @Id
    private String useremail;

    public User(String useremail, String username, String userdob, String useraddress, int userphno, String password) {
        this.useremail = useremail;
        this.username = username;
        this.userdob = userdob;
        this.useraddress = useraddress;
        this.userphno = userphno;
        this.password = password;
    }

    public User() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    private String username;
    private String password;
    private String userdob;
    private long userphno;
    private String useraddress;
    public String getUseremail() {
        return useremail;
    }
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setUserdob(String userdob) {
        this.userdob = userdob;
    }
    public String getUserdob() {
        return userdob;
    }
    public void setUserphno(long userphno) {
        this.userphno = userphno;
    }
    public long getUserphno() {
        return userphno;
    }
    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }
    public String getUseraddress() {
        return useraddress;
    }
    public static void incUserCount(){
        usercount++;
    }
    public static void decUserCount(){
        usercount--;
    }
    public void display(){
        System.out.println("useremail - "+ useremail + " | username - " + username + " | userdob - "+
                userdob + " | useraddress -  "+useraddress +" | userphno - "+userphno + "\n");
    }
}
