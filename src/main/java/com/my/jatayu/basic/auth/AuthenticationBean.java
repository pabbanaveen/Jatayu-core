package com.my.jatayu.basic.auth;


public class AuthenticationBean {

    private String message;
    
    public AuthenticationBean(String str) {
        
        this.message = str;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "HelloWorld [message=" + message + "]";
    }
    
    
}
