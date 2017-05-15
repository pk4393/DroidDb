package com.droidb.com.droiddblibrary.database;

import java.sql.SQLException;

import com.google.gson.Gson;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public class Database {
  private DatabaseHelper mDatabaseHelper;
  private static PreferencesDao mDataDao;
  private final Context mContext;
  private SQLiteDatabase sqLiteDatabase;

  public Database(Context context) {
    this.mContext = context;
  }

  public void open() throws SQLException {
    mDatabaseHelper = new DatabaseHelper(mContext);
    sqLiteDatabase = mDatabaseHelper.getWritableDatabase();
    mDataDao = new PreferencesDao(sqLiteDatabase, new Gson());
  }

  public void close() {
    mDatabaseHelper.close();
  }

  public static PreferencesDao getDataDao() {
    return mDataDao;
  }
}
