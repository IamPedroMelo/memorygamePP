package pt.ipg.memorygamepp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RecyclerViewPontuacao extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

   private static final int HIGHSCORES_CURSOR_LOADER_ID = 0;

   private HighScoreCursorAdapter highScoreCursorAdapter;
   private RecyclerView recyclerViewHighScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pontuacao);

        recyclerViewHighScores = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerViewHighScores.setLayoutManager(new LinearLayoutManager(this));
        highScoreCursorAdapter = new HighScoreCursorAdapter(this);
        recyclerViewHighScores.setAdapter(highScoreCursorAdapter);
        getSupportLoaderManager().initLoader(HIGHSCORES_CURSOR_LOADER_ID,null,this);

    }

    @Override
    protected void onResume(){
        super.onResume();
        getSupportLoaderManager().restartLoader(HIGHSCORES_CURSOR_LOADER_ID,null,this);
    }

    public Loader<Cursor> onCreateLoader(int id, @NonNull Bundle args){
        if(id == HIGHSCORES_CURSOR_LOADER_ID){
            return new android.support.v4.content.CursorLoader(this,HighScoresContentProvider.HIGHSCORES_URI,DbTableHighScores.ALL_COLUMNS,null,null,null);
        }
        return null;
    }


    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        highScoreCursorAdapter.refreshData(data);
    }


    public void onLoaderReset(@NonNull Loader<Cursor> loader){
        highScoreCursorAdapter.refreshData(null);
    }

}
