package pt.ipg.memorygamepp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class pontuacaoActivity extends AppCompatActivity {

    TextView tvp1, tvu1, tvu2;
    int user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        tvu1 = (TextView) findViewById(R.id.textViewUserItem);
        tvp1 = findViewById(R.id.textViewScoreItem);
        tvu2 = findViewById(R.id.textViewUser2);

        DbMemoryGameOpenHelper dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(getApplicationContext());

        SQLiteDatabase db = dbMemoryGameOpenHelper.getWritableDatabase();

        final DbTableUsers tableUsers = new DbTableUsers(db);
        final DbTableHighScores tableHighScores = new DbTableHighScores(db);

        Cursor cursorUser = tableUsers.query(tableUsers.ALL_COLUMNS,null,null,null,null,null);
        cursorUser.moveToFirst();

        Users user = tableUsers.getCurrentUserFromCursor(cursorUser);

        Cursor cursorHighScore = tableHighScores.query(tableHighScores.ALL_COLUMNS,null,null,null,null,null);
        cursorHighScore.moveToFirst();

        HighScores highScores = tableHighScores.getCurrentHighScoresFromCursor(cursorHighScore);

        tvu1.setText(user.getUsername());
        //tvp1.setText(highScores.getScore());
        cursorUser.moveToNext();
        Users user1 = tableUsers.getCurrentUserFromCursor(cursorUser);
        tvu2.setText(user.getUsername());

    }




    public void VoltaMenu(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
