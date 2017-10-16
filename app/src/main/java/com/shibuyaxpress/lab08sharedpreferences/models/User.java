package com.shibuyaxpress.lab08sharedpreferences.models;

import com.orm.dsl.Table;
import com.shibuyaxpress.lab08sharedpreferences.repositories.UserRepository;

import java.util.ArrayList;

/**
 * Created by paulf on 09-Oct-17.
 */
@Table
public class User {
    private Long id;

    private String username;
    private String password;
    private String name;
    private String language;
    private String styles;
    private static User _INSTANCE=null;

    public static User getInstance(){
        if(_INSTANCE==null){
            _INSTANCE=new User();
        }
        return _INSTANCE;
    }

    public User() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
