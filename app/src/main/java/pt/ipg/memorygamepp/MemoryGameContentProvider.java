package pt.ipg.memorygamepp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MemoryGameContentProvider extends ContentProvider{

    DbMemoryGameOpenHelper dbMemoryGameOpenHelper;

   // private static UriMatcher getHighscoresUriMatcher(){

        //UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        //uriMatcher.addURI("pt.ipg.memorygamepp","highscores");

    //}


    @Override
    public boolean onCreate() {

        dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
