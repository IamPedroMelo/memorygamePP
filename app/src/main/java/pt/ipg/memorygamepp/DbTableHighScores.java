package pt.ipg.memorygamepp;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;


public class DbTableHighScores implements BaseColumns{


    public static final String TABLENAME = "HighScores";
    public static final String FILED_SCORE1 = "score1";
    public static final String FILED_SCORE2 = "score2";
    public static final String FILED_SCORE3 = "score3";
    public static final String FILED_SCORE4 = "score4";
    public static final String FILED_SCORE5 = "score5";
    public static final String FIELD_USER_ID = "userId";

    private final SQLiteDatabase db;

    public DbTableHighScores(SQLiteDatabase db) {
        this.db = db;
    }

    public void create() {
        db.execSQL(
                "CREATE TABLE " + TABLENAME + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "type" + " INTEGER NOT NULL," +
                        FILED_SCORE1 + " TEXT," +
                        FILED_SCORE2 + " TEXT," +
                        FILED_SCORE3 + " TEXT," +
                        FILED_SCORE4 + " TEXT," +
                        FILED_SCORE5 + " TEXT," +
                        FIELD_USER_ID + " INTEGER," +
                        "FOREIGN KEY(" + FIELD_USER_ID + ") REFERENCES " +
                        DbTableUsers.TABLE_NAME + "(" + DbTableUsers._ID +")" +
                        ")"


        );
    }
}
