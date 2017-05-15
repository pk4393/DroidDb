package com.droidb.com.droiddblibrary.database;

import java.lang.reflect.Type;

import com.google.gson.Gson;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public class PreferencesDao extends DbContentProvider implements IPreferencesDao, ISchema {
  private Gson gson;

  public PreferencesDao(SQLiteDatabase mSqLiteDatabase, Gson gson) {
    super(mSqLiteDatabase);
    this.gson = gson;
  }

  @Override
  protected boolean checkDataAvailability(String key) {
    return false;
  }

  @Override
  protected String fetchData(String key, String defaultValue) {
    String data = "";
    Cursor cursor = super.query(DROID_DB_TABLE_PREFERENCES, new String[] {DROID_DB_TABLE_PREFERENCES_VALUE},
        DROID_DB_TABLE_PREFERENCES_KEY + "=?", new String[] {key});
    if (cursor != null) {
      if (cursor.moveToNext()) {
        data = cursor.getString(cursor.getColumnIndex(DROID_DB_TABLE_PREFERENCES_VALUE));
      }
      cursor.close();
    }
    if (data.isEmpty()) {
      return defaultValue;
    }
    return data;
  }

  @Override
  protected long addData(String key, String value) {
    return super.replace(DROID_DB_TABLE_PREFERENCES, setContentValue(key, value));
  }

  @Override
  public void addLongValue(@NonNull String key, long longValue) {
    addData(key, String.valueOf(longValue));
  }

  @Override
  public void addStringValue(@NonNull String key, String stringValue) {
    addData(key, stringValue);
  }

  @Override
  public void addIntValue(@NonNull String key, int intValue) {
    addData(key, String.valueOf(intValue));
  }

  @Override
  public void addObject(@NonNull String key, Object object) {
    addData(key, gson.toJson(object));
  }

  @Override
  public void addBooleanValue(@NonNull String key, boolean booleanValue) {
    addData(key, String.valueOf(booleanValue));
  }

  @Override
  public long getLongValue(@NonNull String key) {
    return Long.valueOf(fetchData(key, "0"));
  }

  @Override
  public String getStringValue(@NonNull String key) {
    return fetchData(key, "");
  }

  @Override
  public int getIntValue(@NonNull String key) {
    return Integer.valueOf(fetchData(key, "0"));
  }

  @Override
  public <T> T getObject(@NonNull String key, @NonNull Class<T> a) {
    String gsonData = fetchData(key, null);
    if (gsonData == null) {
      return null;
    } else {
      try {
        return gson.fromJson(gsonData, a);
      } catch (Exception e) {
        throw new IllegalArgumentException(
            "Object storaged with key " + key + " is instanceof other class");
      }
    }
  }

  @Override
  public <T> T getObject(@NonNull String key, @NonNull Type typeToken) {
    String gsonData = fetchData(key, null);
    if (gsonData == null) {
      return null;
    } else {
      try {
        return gson.fromJson(gsonData, typeToken);
      } catch (Exception e) {
        throw new IllegalArgumentException(
            "Object storaged with key " + key + " is instanceof other class");
      }
    }
  }

  @Override
  public boolean getBooleanValue(@NonNull String key) {
    return Boolean.valueOf(fetchData(key, "false"));
  }

  @Override
  public void addDoubleValue(@NonNull String key, double doubleValue) {
    addData(key, String.valueOf(doubleValue));
  }

  @Override
  public double getDoubleValue(@NonNull String key) {
    return Double.valueOf(fetchData(key, "0"));
  }

  @Override
  public void clearAllDroidDbData() {
    super.delete(DROID_DB_TABLE_PREFERENCES, null, null);
  }

  private ContentValues setContentValue(String key, String value) {
    ContentValues values = new ContentValues();
    values.put(DROID_DB_TABLE_PREFERENCES_KEY, key);
    values.put(DROID_DB_TABLE_PREFERENCES_VALUE, value);
    return values;
  }
}
