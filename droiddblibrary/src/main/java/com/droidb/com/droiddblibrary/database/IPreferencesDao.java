package com.droidb.com.droiddblibrary.database;

import java.lang.reflect.Type;

import android.support.annotation.NonNull;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public interface IPreferencesDao {
  void addLong(String key, long longValue);

  void addString(String key, String stringValue);

  void addInt(String key, int intValue);

  void addObject(String key, Object object);

  void addBoolean(String key, boolean booleanValue);

  long getLong(String key);

  String getString(String key);

  int getInt(String key);

  <T> T getObject(String key, @NonNull Class<T> a);

  <T> T getObject(String key, Type typeToken);

  boolean getBoolean(String key);

  void addDouble(String key, double doubleValue);

  double getDouble(String key);

  void clearAllData();
}
