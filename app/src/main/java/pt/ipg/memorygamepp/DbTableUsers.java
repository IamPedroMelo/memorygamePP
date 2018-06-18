package pt.ipg.memorygamepp;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class DbTableUsers implements BaseColumns {


    public static final String TABLE_NAME = "Users";
    public static final String FIELD_USERNAME = "Username";

    private final SQLiteDatabase db;

    public DbTableUsers(SQLiteDatabase db) {
        this.db=db;
    }

    public void create() {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + "(" + _ID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        FIELD_USERNAME + " TEXT NOT NULL" +
                        ")"

        );
    }
}
