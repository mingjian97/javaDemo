package com.example.springsecuritydemo2jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: mingjian
 * @create: 2020-04-04 11:30
 */
@Entity
public class User implements java.io.Serializable{

    @Id
    @Column
    private Integer id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String role;
    // 省略get set 等

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}