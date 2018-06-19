package pt.ipg.memorygamepp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class DbTableUsers implements BaseColumns {


    public static final String TABLE_NAME = "Users";
    public static final String FIELD_USERNAME = "Username";

    private final SQLiteDatabase db;

    public static final String [] ALL_COUMNS = new String[]{_ID,FIELD_USERNAME};

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

    public  static ContentValues getContentValues(Users users){
        ContentValues values = new ContentValues();

        values.put(_ID,users.getId());
        values.put(FIELD_USERNAME,users.getUsername());

        return values;
    }

    public static Users getCurrentUserFromCursor(Cursor cursor){

        final int posId = cursor.getColumnIndex(_ID);
        final int posUsername = cursor.getColumnIndex(FIELD_USERNAME);

        Users user = new Users();

        user.setId(cursor.getInt(posId));
        user.setUsername(cursor.getString(posUsername));


        return user;
    }

    public long insert(ContentValues values){
        return db.insert(TABLE_NAME,null,values);
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
