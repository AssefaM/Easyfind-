package com.example.asse.sweapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 5/15/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ Table_Data.Tableinfo.TABLE_NAME+"("+ Table_Data.Tableinfo.USER_NAME+" TEXT, "+ Table_Data.Tableinfo.USER_PASS+" TEXT);";
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public DatabaseOperations(Context context) {
        super(context, Table_Data.Tableinfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database Created");
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase sdb) {

        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created");

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

    public void putInformation(DatabaseOperations dop, String name, String pass) {
        SQLiteDatabase SQL = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Table_Data.Tableinfo.USER_NAME, name);
        cv.put(Table_Data.Tableinfo.USER_PASS, pass);
        long k = SQL.insert(Table_Data.Tableinfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "One row inserted");
    }

    public Cursor loginInfo(DatabaseOperations db1) {
        SQLiteDatabase SQL = db1.getReadableDatabase();
        String[] fields = {Table_Data.Tableinfo.USER_NAME, Table_Data.Tableinfo.USER_PASS};
        Cursor cursor = SQL.query(Table_Data.Tableinfo.TABLE_NAME, fields, null,null, null,null,null);

        return cursor;
    }

}
