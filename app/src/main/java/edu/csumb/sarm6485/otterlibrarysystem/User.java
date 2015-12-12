package edu.csumb.sarm6485.otterlibrarysystem;

/**
 * Title: AddBook.java
 * Abstract: This is the class for the User Object. Users make rentals and are created at the CreateClass.java activity.
 * Author: Michael Sarmiento
 * ID: 7101
 * Date: 12-11-2015
 */
public class User {
    private String password;
    private String username;
    private int id;

    public User(){

    }

    public User(User user){
        this.username = user.getUsername();
        this.id = user.getId();
    }

    public User(String password, String username){
        this.password=password;
        this.username=username;
    }

    public boolean check(){
        //get the credentials from the DB
        return true;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "user: " + username + "password: " + password;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
