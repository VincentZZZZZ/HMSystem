package com.example.sion10032.hmsystem.backend;

import java.util.Vector;

/**
 * Created by sion10032
 * On 11/10/17.
 */

public class AccountManager {

    private static final AccountManager single = new AccountManager();

    private AccountManager() {}

    private AccountManager(AccountManager accountManager) {}

    public static AccountManager getInstance() {
        return single;
    }



    private Vector<Account> mAccounts;

    private Account mCurAccount;

    public void addAccount() {

    }

    public void deleteAccount() {

    }

    public void signIn() {

    }

    public void signUp() {

    }



}
