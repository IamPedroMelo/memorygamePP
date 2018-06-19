package pt.ipg.memorygamepp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import static pt.ipg.memorygamepp.DbTableUsers.TABLE_NAME;


public class DbTableHighScores implements BaseColumns{


    public static final String TABLENAME = "HighScores";
    public static final String FIELD_SCORE = "score";
    public static final String FIELD_USER_ID = "userId";

    private final SQLiteDatabase db;

    public static final String[] ALL_COLUMNS = new String[]{_ID,FIELD_SCORE,FIELD_USER_ID};


    public DbTableHighScores(SQLiteDatabase db) {
        this.db = db;
    }

    public void create() {
        db.execSQL(
                "CREATE TABLE " + TABLENAME + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        FIELD_SCORE + " INTEGER," +
                        FIELD_USER_ID + " INTEGER," +
                        "FOREIGN KEY(" + FIELD_USER_ID + ") REFERENCES " +
                        TABLE_NAME + "(" + DbTableUsers._ID +")" +
                        ")"


        );
    }

    public  static ContentValues getContentValues(HighScores highScores){
        ContentValues values = new ContentValues();

        values.put(_ID,highScores.getId());
        values.put(FIELD_SCORE,highScores.getScore());
        values.put(FIELD_USER_ID,highScores.getUserId());

        return values;
    }

    public static HighScores getCurrentHighScoresFromCursor(Cursor cursor){

        final int posId = cursor.getColumnIndex(_ID);
        final int posScore = cursor.getColumnIndex(FIELD_SCORE);
        final int posUserId = cursor.getColumnIndex(FIELD_USER_ID);

        HighScores highScores = new HighScores();

        highScores.setId(cursor.getInt(posId));
        highScores.setScore(cursor.getInt(posScore));
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
