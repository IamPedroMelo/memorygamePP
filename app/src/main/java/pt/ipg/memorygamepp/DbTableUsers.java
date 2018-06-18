package pt.ipg.memorygamepp;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class DbTableUsers implements BaseColumns {
    private final SQLiteDatabase db;

    public DbTableUsers(SQLiteDatabase db) {
        this.db=db;
    }

    public void create() {

    }
}
