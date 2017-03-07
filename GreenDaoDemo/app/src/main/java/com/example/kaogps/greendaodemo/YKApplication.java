package com.example.kaogps.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.kaogps.greendaodemo.greendao.DaoMaster;
import com.example.kaogps.greendaodemo.greendao.DaoSession;
import com.example.kaogps.greendaodemo.greendao.MySQLiteOpenHelper;

/**
 * Created by Sun on 2017/3/1.
 */

public class YKApplication extends Application {

    private DaoSession mDaoSession;

    private static YKApplication sYKApplication;

    public static YKApplication getApp() {
        return sYKApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sYKApplication = this;
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this, "test.db", null);
        SQLiteDatabase db = helper.getReadableDatabase();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
