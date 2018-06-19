package pt.ipg.memorygamepp;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;


public class DbTableHighScores implements BaseColumns{


    public static final String TABLENAME = "HighScores";
    public static final String FIELD_SCORE1 = "score1";
    public static final String FIELD_SCORE2 = "score1";
    public static final String FIELD_SCORE3 = "score1";
    public static final String FIELD_SCORE4 = "score1";
    public static final String FIELD_SCORE5 = "score1";
    public static final String FIELD_USER_ID = "userId";

    private final SQLiteDatabase db;

    public DbTableHighScores(SQLiteDatabase db) {
        this.db = db;
    }

    public void create() {
        db.execSQL(
                "CREATE TABLE " + TABLENAME + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        FIELD_SCORE1 + " TEXT," +
                        FIELD_SCORE2 + " TEXT," +
                        FIELD_SCORE3 + " TEXT," +
                        FIELD_SCORE4 + " TEXT," +
                        FIELD_SCORE5 + " TEXT," +
                        FIELD_USER_ID + " INTEGER," +
                        "FOREIGN KEY(" + FIELD_USER_ID + ") REFERENCES " +
                        DbTableUsers.TABLE_NAME + "(" + DbTableUsers._ID +")" +
                        ")"


        );
    }
}
