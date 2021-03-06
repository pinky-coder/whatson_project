package uk.co.ashawijekoon.whatson.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asha Wijekoon on 23/08/2017.
 */

public class EventBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 7;
    private static final String DATABASE_NAME = "eventDataBase.db";

    public EventBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + EventDbSchema.EventTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                EventDbSchema.EventTable.Cols.UUID + ", " +
                EventDbSchema.EventTable.Cols.TITLE + ", " +
                EventDbSchema.EventTable.Cols.DESCRIPTION + ", " +
                EventDbSchema.EventTable.Cols.DATE + ", " +
                EventDbSchema.EventTable.Cols.TIME + ", " +
                EventDbSchema.EventTable.Cols.LOCATION_NAME + ", " +
                EventDbSchema.EventTable.Cols.CATEGORY +
                ")"
        );
        ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table " + EventDbSchema.EventTable.NAME);
        onCreate(sqLiteDatabase);
    }
}
