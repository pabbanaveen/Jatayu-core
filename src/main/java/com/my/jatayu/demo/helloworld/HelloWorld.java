package com.my.jatayu.demo.helloworld;


public class HelloWorld {

    private String message;
    
    public HelloWorld(String str) {
        
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
