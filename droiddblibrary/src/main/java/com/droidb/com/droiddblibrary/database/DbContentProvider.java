package com.droidb.com.droiddblibrary.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public abstract class DbContentProvider {
  private SQLiteDatabase mSqLiteDatabase;

  public DbContentProvider(SQLiteDatabase mSqLiteDatabase) {
    this.mSqLiteDatabase = mSqLiteDatabase;
  }

  public Cursor query(String tableName, String[] columns, String selection,
      String[] selectionArgs) {
    return mSqLiteDatabase.query(tableName, columns, selection, selectionArgs, null, null, null);
  }

  public long insert(String tableName, ContentValues values) {
    return mSqLiteDatabase.insert(tableName, null, values);
  }

  public Cursor rawQuery(String sql, String[] selectionArgs) {
    return mSqLiteDatabase.rawQuery(sql, selectionArgs);
  }

  public int update(String tableName, ContentValues values, String selection,
      String[] selectionArgs) {
    return mSqLiteDatabase.update(tableName, values, selection, selectionArgs);
  }

  public long replace(String tableName, ContentValues values) {
    return mSqLiteDatabase.replace(tableName, null, values);
  }

  public int delete(String tableName, String whereClause, String[] whereArgs) {
    return mSqLiteDatabase.delete(tableName, whereClause, whereArgs);
  }

  protected abstract boolean checkDataAvailability(String key);

  protected abstract String fetchData(String key, String defaultValue);

  protected abstract long addData(String key, String value);
}
