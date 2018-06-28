package pt.ipg.memorygamepp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class HighScoresContentProvider extends ContentProvider{

    private static final String AUTHORITY = "pt.ipg.memorygamepp";
    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
    public static final Uri HIGHSCORES_URI = Uri.withAppendedPath(BASE_URI, DbTableHighScores.TABLE_NAME);
    public static final int HIGHSCORES = 100;
    public static final int HIGHSCORES_ID = 101;
    public static final int USERS = 200;
    public static final int USERS_ID = 201;

    public static final String MULTIPLE_ITEMS = "vnd.android.cursor.dir";
    public static final String SINGLE_ITEM = "vnd.android.cursor.item";
    DbMemoryGameOpenHelper dbMemoryGameOpenHelper;

    private static UriMatcher getHighscoresUriMatcher(){

        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(AUTHORITY,"highscores", HIGHSCORES);
        uriMatcher.addURI(AUTHORITY,"highscores/#", HIGHSCORES_ID);

        uriMatcher.addURI(AUTHORITY,"users", USERS);
        uriMatcher.addURI(AUTHORITY,"users/#", USERS_ID);

        return uriMatcher;
    }

    @Override
    public boolean onCreate() {

        dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(getContext());

        return true;
    }


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = dbMemoryGameOpenHelper.getReadableDatabase();

        String id = uri.getLastPathSegment();

        UriMatcher matcher = getHighscoresUriMatcher();

        switch (matcher.match(uri)){
            case HIGHSCORES:
                return new DbTableHighScores(db).query(projection,selection,selectionArgs,null,null,sortOrder);
            case USERS:
                return new DbTableUsers(db).query(projection,selection,selectionArgs,null,null,sortOrder);
            case HIGHSCORES_ID:
                return new DbTableHighScores(db).query(projection,DbTableHighScores._ID + "=?",new String[]{id},null,null,null);
            case USERS_ID:
                return new DbTableUsers(db).query(projection,DbTableUsers._ID +"=?", new String[]{id},null,null,null);
            default:
                throw new UnsupportedOperationException("Invalid URI: " +uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        UriMatcher matcher = getHighscoresUriMatcher();

        switch (matcher.match(uri)){
            case HIGHSCORES:
                return MULTIPLE_ITEMS + "/" + AUTHORITY + "/" + DbTableHighScores.TABLE_NAME;
            case USERS:
                return MULTIPLE_ITEMS + "/" + AUTHORITY + "/" + DbTableUsers.TABLE_NAME;
            case HIGHSCORES_ID:
                return SINGLE_ITEM + "/" + AUTHORITY + "/" + DbTableHighScores.TABLE_NAME;
            case USERS_ID:
                return SINGLE_ITEM + "/" + AUTHORITY + "/" + DbTableUsers.TABLE_NAME;

            default:
                throw new UnsupportedOperationException("Unknown URI: " +uri);

        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = dbMemoryGameOpenHelper.getReadableDatabase();

        UriMatcher matcher = getHighscoresUriMatcher();

        long id = -1;

        switch (matcher.match(uri)){
            case HIGHSCORES:
                id = new DbTableHighScores(db).insert(values);
                break;
            case USERS:
                id = new DbTableUsers(db).insert(values);
            default:
                throw new UnsupportedOperationException("Invalid URI: " + uri);
        }

        if (id > 0){
            notifyChanges(uri);
            return Uri.withAppendedPath(uri,Long.toString(id));
        }else{
            throw new SQLException("Could not insert record");
        }
    }

    private void notifyChanges(Uri uri) {
        getContext().getContentResolver().notifyChange(uri,null);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbMemoryGameOpenHelper.getWritableDatabase();

        UriMatcher matcher = getHighscoresUriMatcher();

        String id = uri.getLastPathSegment();

        int rows = 0;

        switch (matcher.match(uri)){
            case HIGHSCORES_ID:
                rows = new DbTableHighScores(db).delete(DbTableHighScores._ID +"=?", new String[]{id});
                break;
            case USERS_ID:
                rows = new DbTableUsers(db).delete(DbTableUsers._ID +"=?", new String[]{id});
                break;
            default:
                throw new UnsupportedOperationException("Invalid URI: "+uri);
        }

        if (rows > 0) notifyChanges(uri);

        return rows;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbMemoryGameOpenHelper.getWritableDatabase();

        UriMatcher matcher = getHighscoresUriMatcher();

        String id = uri.getLastPathSegment();

        int rows = 0;

        switch (matcher.match(uri)){
            case HIGHSCORES_ID:
                rows = new DbTableHighScores(db).update(values,DbTableHighScores._ID +"=?",new String[]{id});
                break;
            case USERS_ID:
                rows = new DbTableUsers(db).update(values,DbTableUsers._ID +"=?", new String[]{id});
                break;
            default:
                throw new UnsupportedOperationException("Invalide URI " +uri);

        }
        if (rows > 0) notifyChanges(uri);
        return rows;
    }
}
