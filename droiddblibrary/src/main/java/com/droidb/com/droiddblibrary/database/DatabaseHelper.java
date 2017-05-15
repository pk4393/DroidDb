package com.droidb.com.droiddblibrary.database;

import static com.droidb.com.droiddblibrary.database.ISchema.CREATE_PREFERENCES_TABLE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PrashantKumar on 5/15/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
  // Database Name
  private static final String DATABASE_NAME = "droiddb.db";
  // Increment DB Version on any schema change
  private static final int DATABASE_VERSION = 1;

  DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_PREFERENCES_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // No Implementation required
  }
}
