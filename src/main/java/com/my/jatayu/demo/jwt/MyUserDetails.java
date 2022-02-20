package com.my.jatayu.demo.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.my.jatayu.demo.modal.User;

public class MyUserDetails implements UserDetails{
    private String username;
    private String password;
    private String emailId;

    
    public MyUserDetails(User user) {
        super();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.emailId = user.getEmailId();
    }

    public MyUserDetails() {
        
    }
    
//    public String getUsername() {
//        return username;
//    }

    public void setUsername(String userName) {
        this.username = userName;
    }
    
    

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return emailId;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}

