package pt.ipg.memorygamepp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import static pt.ipg.memorygamepp.DbTableUsers.TABLE_NAME;


public class DbTableHighScores implements BaseColumns{


    public static final String TABLENAME = "HighScores";
    public static final String FIELD_SCORE1 = "score1";
    public static final String FIELD_SCORE2 = "score2";
    public static final String FIELD_SCORE3 = "score3";
    public static final String FIELD_SCORE4 = "score4";
    public static final String FIELD_SCORE5 = "score5";
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
                        TABLE_NAME + "(" + DbTableUsers._ID +")" +
                        ")"


        );
    }

    public  static ContentValues getContentValues(HighScores highScores){
        ContentValues values = new ContentValues();

        values.put(_ID,highScores.getId());
        values.put(FIELD_SCORE1,highScores.getScore1());
        values.put(FIELD_SCORE2,highScores.getScore2());
        values.put(FIELD_SCORE3,highScores.getScore3());
        values.put(FIELD_SCORE4,highScores.getScore4());
        values.put(FIELD_SCORE5,highScores.getScore5());
        values.put(FIELD_USER_ID,highScores.getUserId());

        return values;
    }

    public static HighScores getCurrentHighScoresFromCursor(Cursor cursor){

        final int posId = cursor.getColumnIndex(_ID);
        final int posScore1 = cursor.getColumnIndex(FIELD_SCORE1);
        final int posScore2 = cursor.getColumnIndex(FIELD_SCORE2);
        final int posScore3 = cursor.getColumnIndex(FIELD_SCORE3);
        final int posScore4 = cursor.getColumnIndex(FIELD_SCORE4);
        final int posScore5 = cursor.getColumnIndex(FIELD_SCORE5);
        final int posUserId = cursor.getColumnIndex(FIELD_USER_ID);

        HighScores highScores = new HighScores();

        highScores.setId(cursor.getInt(posId));
        highScores.setScore1(cursor.getString(posScore1));
        highScores.setScore2(cursor.getString(posScore2));
        highScores.setScore3(cursor.getString(posScore3));
        highScores.setScore4(cursor.getString(posScore4));
        highScores.setScore5(cursor.getString(posScore5));
        highScores.setUserId(cursor.getInt(posUserId));

        return highScores;

    }

    public long insert(ContentValues values){
        return db.insert(TABLENAME,null,values);
    }

    public int update(ContentValues values, String whereClause, String[] whereArgs){
        return db.update(TABLE_NAME, values, whereClause, whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs){
        return db.delete(TABLE_NAME, whereClause, whereArgs);
    }

    public Cursor query (String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return db.query(TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
}
