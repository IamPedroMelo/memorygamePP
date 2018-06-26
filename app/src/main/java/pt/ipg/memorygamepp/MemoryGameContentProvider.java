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
import android.widget.Switch;

public class MemoryGameContentProvider extends ContentProvider{

    public static final int HIGHSCORES = 100;
    public static final int HIGHSCORES_ID = 101;
    public static final int USERS = 200;
    public static final int USERS_ID = 201;
    DbMemoryGameOpenHelper dbMemoryGameOpenHelper;

    private static UriMatcher getHighscoresUriMatcher(){

        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI("pt.ipg.memorygamepp","highscores", HIGHSCORES);
        uriMatcher.addURI("pt.ipg.memorygamepp","highscores/#", HIGHSCORES_ID);

        uriMatcher.addURI("pt.ipg.memorygamepp","users", USERS);
        uriMatcher.addURI("pt.ipg.memorygamepp","users/#", USERS_ID);

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
        return null;
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
        return 0;
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
