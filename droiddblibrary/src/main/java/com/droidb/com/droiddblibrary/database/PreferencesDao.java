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
    Cursor cursor = super.query(DB_TABLE_PREFERENCES, new String[] {TABLE_PREFERENCES_VALUE},
        TABLE_PREFERENCES_KEY + "=?", new String[] {key});
    if (cursor != null) {
      if (cursor.moveToNext()) {
        data = cursor.getString(cursor.getColumnIndex(TABLE_PREFERENCES_VALUE));
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
    return super.replace(DB_TABLE_PREFERENCES, setContentValue(key, value));
  }

  @Override
  public void addLong(String key, long longValue) {
    addData(key, String.valueOf(longValue));
  }

  @Override
  public void addString(String key, String stringValue) {
    addData(key, stringValue);
  }

  @Override
  public void addInt(String key, int intValue) {
    addData(key, String.valueOf(intValue));
  }

  @Override
  public void addObject(String key, Object object) {
    addData(key, gson.toJson(object));
  }

  @Override
  public void addBoolean(String key, boolean booleanValue) {
    addData(key, String.valueOf(booleanValue));
  }

  @Override
  public long getLong(String key) {
    return Long.valueOf(fetchData(key, "0"));
  }

  @Override
  public String getString(String key) {
    return fetchData(key, "");
  }

  @Override
  public int getInt(String key) {
    return Integer.valueOf(fetchData(key, "0"));
  }

  @Override
  public <T> T getObject(String key, @NonNull Class<T> a) {
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
  public <T> T getObject(String key, @NonNull Type typeToken) {
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
  public boolean getBoolean(String key) {
    return Boolean.valueOf(fetchData(key, "false"));
  }

  @Override
  public void addDouble(String key, double doubleValue) {
    addData(key, String.valueOf(doubleValue));
  }

  @Override
  public double getDouble(String key) {
    return Double.valueOf(fetchData(key, "0"));
  }

  @Override
  public void clearAllData() {
    super.delete(DB_TABLE_PREFERENCES, null, null);
  }

  private ContentValues setContentValue(String key, String value) {
    ContentValues values = new ContentValues();
    values.put(TABLE_PREFERENCES_KEY, key);
    values.put(TABLE_PREFERENCES_VALUE, value);
    return values;
  }
}
