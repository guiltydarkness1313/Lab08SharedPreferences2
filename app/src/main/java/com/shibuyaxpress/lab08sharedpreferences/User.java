package com.shibuyaxpress.lab08sharedpreferences;

import java.util.ArrayList;

/**
 * Created by paulf on 09-Oct-17.
 */

public class User {
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

    public User(String username, String password, String name, String language, String styles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.language = language;
        this.styles = styles;
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

    public void CheckUsers(String username, String password){
            ArrayList<User> userlist=UserRepository.getInstance().getUsers();

            for(int i=0;i<userlist.size();i++){
                if(username.equals(userlist.get(i).getUsername())){
                    if(password.equals(userlist.get(i).getPassword())){

                    }else{
                        User u=new User();
                        u.setUsername(username);
                        u.setPassword(password);
                        UserRepository.getInstance().setUsers(u);
                        User.getInstance().setUsername(u.getUsername());
                        User.getInstance().setPassword(u.getPassword());

                    }
                }else {
                    User u=new User();
                    u.setUsername(username);
                    u.setPassword(password);
                    UserRepository.getInstance().setUsers(u);
                    User.getInstance().setUsername(u.getUsername());
                    User.getInstance().setPassword(u.getPassword());
                }
            }

        }

}
