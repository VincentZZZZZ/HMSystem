package com.example.sion10032.hmsystem.backend;

import java.util.Vector;

/**
 * Created by sion10032
 * On 11/10/17.
 */

public class UserManager {

    private static final UserManager single = new UserManager();
    private UserManager() {}
    private UserManager(UserManager accountManager) {}
    public static UserManager getInstance() {
        return single;
    }



    private Vector<User> mUsers;
    private User mCurUser;

    public User getCurUser() {
        return mCurUser;
    }

    public void setCurUser(User CurUser) {
        this.mCurUser = CurUser;
    }

    public void addUser() {

    }

    public void deleteUser() {

    }

    public void signIn() {

    }

    public void signUp() {

    }



}
