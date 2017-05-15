package com.droidb.com.droiddblibrary.database;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public interface ISchema {
  String DB_TABLE_PREFERENCES = "preferences";
  String TABLE_PREFERENCES_KEY = "KEY";
  String TABLE_PREFERENCES_VALUE = "VALUE";
  String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS ";
  String CREATE_PREFERENCES_TABLE = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_PREFERENCES + " ("
      + TABLE_PREFERENCES_KEY + " TEXT PRIMARY KEY, " + TABLE_PREFERENCES_VALUE + " TEXT" + ")";
}
