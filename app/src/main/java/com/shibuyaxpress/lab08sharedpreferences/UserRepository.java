package com.shibuyaxpress.lab08sharedpreferences;

import java.util.ArrayList;

/**
 * Created by paulf on 09-Oct-17.
 */

public class UserRepository {

    private static UserRepository _INSTANCE=null;
    private static ArrayList<User> users=new ArrayList<>();
    private UserRepository(){

    }
    static {
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
    }


}
