package pt.ipg.memorygamepp;

import android.app.Instrumentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.AccessControlContext;

public class DbMemoryGameOpenHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "memorygamepp.db";
    public static final int DATABASE_VERSION = 1;

    public DbMemoryGameOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Context appContext = getContext();

        DbTableUsers dbTableUsers = new DbTableUsers(db);
        dbTableUsers.create();

        DbTableHighScores dbTableHighScores = new DbTableHighScores(db);
        dbTableHighScores.create();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //public Context getContext() {
    //    return InstrumentationRegistry.getTargetContext();
    //}
}
