package com.droidb.com.droiddblibrary.database;

import java.lang.reflect.Type;

import android.support.annotation.NonNull;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public interface IPreferencesDao {
  void addLongValue(@NonNull String key, long longValue);

  void addStringValue(@NonNull String key, String stringValue);

  void addIntValue(@NonNull String key, int intValue);

  void addObject(@NonNull String key, Object object);

  void addBooleanValue(@NonNull String key, boolean booleanValue);

  long getLongValue(@NonNull String key);

  String getStringValue(@NonNull String key);

  int getIntValue(@NonNull String key);

  <T> T getObject(@NonNull String key, @NonNull Class<T> a);

  <T> T getObject(@NonNull String key, Type typeToken);

  boolean getBooleanValue(@NonNull String key);

  void addDoubleValue(@NonNull String key, double doubleValue);

  double getDoubleValue(@NonNull String key);

  void clearAllDroidDbData();
}
