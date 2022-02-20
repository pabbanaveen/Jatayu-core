package com.my.jatayu.demo.modal;

public class AuthRequest {

    private String username;
    private String password;
    
    public AuthRequest() {
     
    }
    
    public AuthRequest(String userName, String password) {
        super();
        this.username = userName;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
