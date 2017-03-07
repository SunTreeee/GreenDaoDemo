package com.example.kaogps.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kaogps.greendaodemo.greendao.UserDao;
import com.orhanobut.logger.Logger;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDao = YKApplication.getApp().getDaoSession().getUserDao();
        deleteDB();
        mUserDao.insertOrReplaceInTx(getUsers());
        //        User userS = new User(null, "shy", 23);
        //        mUserDao.insertOrReplace(userS);
        queryUser();

    }

    private void deleteDB() {
        mUserDao.deleteAll();
    }

    private void queryUser() {
        List<User> users = mUserDao.loadAll();
        Logger.d(users.size());
        for (int i = 0; i < users.size(); i++) {
            Logger.d(users.get(i).getId());
        }
    }

    private List<User> getUsers() {
        return mUserDao.loadAll();
    }
}
