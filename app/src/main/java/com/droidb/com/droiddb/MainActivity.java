package com.droidb.com.droiddb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.droidb.com.droiddblibrary.database.Database;
import com.droidb.com.droiddblibrary.database.PreferencesDao;

public class MainActivity extends AppCompatActivity {
  private PreferencesDao mPreferencesDao;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mPreferencesDao = Database.getDataDao();
    mPreferencesDao.addBoolean("DbBooleanDemo", true);
    mPreferencesDao.addInt("DbIntDemo", 4393);
    mPreferencesDao.addLong("DbLongDemo", 4393L);
    mPreferencesDao.addString("DbStringDemo", "DbDemo");

    Log.e("DbBooleanDemo : ", String.valueOf(mPreferencesDao.getBoolean("DbBooleanDemo")));
    Log.e("DbIntDemo : ", String.valueOf(mPreferencesDao.getInt("DbIntDemo")));
    Log.e("DbLongDemo : ", String.valueOf(mPreferencesDao.getLong("DbLongDemo")));
    Log.e("DbStringDemo : ", String.valueOf(mPreferencesDao.getString("DbStringDemo")));
  }
}
