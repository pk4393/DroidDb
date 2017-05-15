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
    mPreferencesDao.addBooleanValue("DbBooleanDemo", true);
    mPreferencesDao.addIntValue("DbIntDemo", 4393);
    mPreferencesDao.addLongValue("DbLongDemo", 4393L);
    mPreferencesDao.addStringValue("DbStringDemo", "DbDemo");
    mPreferencesDao.addObject("DbObjectDemo", "DbDemo");

    Log.e("DbBooleanDemo : ", String.valueOf(mPreferencesDao.getBooleanValue("DbBooleanDemo")));
    Log.e("DbIntDemo : ", String.valueOf(mPreferencesDao.getIntValue("DbIntDemo")));
    Log.e("DbLongDemo : ", String.valueOf(mPreferencesDao.getLongValue("DbLongDemo")));
    Log.e("DbStringDemo : ", String.valueOf(mPreferencesDao.getStringValue("DbStringDemo")));
    Log.e("DbObjectDemo : ",
        String.valueOf(mPreferencesDao.getObject("DbObjectDemo", String.class)));
  }
}
