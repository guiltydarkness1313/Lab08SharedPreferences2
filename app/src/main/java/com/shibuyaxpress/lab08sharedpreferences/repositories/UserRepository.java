package com.shibuyaxpress.lab08sharedpreferences.repositories;

import com.orm.SugarRecord;
import com.shibuyaxpress.lab08sharedpreferences.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulf on 09-Oct-17.
 */

public class UserRepository {

    private static UserRepository _INSTANCE=null;
    private static ArrayList<User> users=new ArrayList<>();
    private UserRepository(){

    }
    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String username, String password){
        User user = new User(username, password);
        SugarRecord.save(user);
    }

    public static void update(String fullname, String password, String username, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setName(fullname);
        user.setPassword(password);
        user.setUsername(username);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }





    /*static {
        User u=new User("pedro12","123","","spanish","");
        users.add(u);
        u=new User("enrique","123","","english","");
        users.add(u);
        u=new User("paul","123","","english","");
        users.add(u);


    }

    public static UserRepository getInstance(){
        if(_INSTANCE==null){
            _INSTANCE=new UserRepository();
        }
        return _INSTANCE;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        this.users.add(user);
    }*/


}
