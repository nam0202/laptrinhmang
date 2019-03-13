package com.example.laptrinhmang.Model;

import com.example.laptrinhmang.Data.User;
import java.util.ArrayList;

public class UserData {
    private ArrayList<User> listUser = new ArrayList<>();
    public UserData(){
        listUser.add(new User("admin","admin"));
        listUser.add(new User("user","user"));
    }
    public boolean addUser(User u){
        try {
            if(u == null) return false;
            listUser.add(u);
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }
    public boolean LoginUser(User user){
        for (User u: listUser) {
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

}
