package com.droidb.com.droiddb;

import android.app.Application;
import android.util.Log;

import com.droidb.com.droiddblibrary.database.Database;

import java.sql.SQLException;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public class MyApplication extends Application {
  private Database mDatabase;

  @Override
  public void onCreate() {
    mDatabase = new Database(this);
    try {
      mDatabase.open();
    } catch (SQLException e) {
      Log.e("SQLException", e.getMessage());
    }
    super.onCreate();
  }

  @Override
  public void onTerminate() {
    mDatabase.close();
    super.onTerminate();
  }
}
