package com.my.jatayu.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
//https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
//https://jasonwatmore.com/post/2018/05/23/angular-6-jwt-authentication-example-tutorial#authentication-service-ts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="email_id")
    private String emailId;

    @Column(name="user_name")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
        
    }
    public User(Integer id, String emailId, String userName, String password, String role) {
        super();
        this.id = id;
        this.emailId = emailId;
        this.username = userName;
        this.password = password;
        this.role = role;
    }
    
}
