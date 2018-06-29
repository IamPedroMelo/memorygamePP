package pt.ipg.memorygamepp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class pontuacaoActivity extends AppCompatActivity {

    TextView tvp1, tvu1;
    int user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        tvu1 = (TextView) findViewById(R.id.textViewUser1);
        tvp1 = findViewById(R.id.textViewScore1);

        DbMemoryGameOpenHelper dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(getApplicationContext());

        SQLiteDatabase db = dbMemoryGameOpenHelper.getWritableDatabase();

        final DbTableUsers tableUsers = new DbTableUsers(db);
        final DbTableHighScores tableHighScores = new DbTableHighScores(db);

        Cursor cursorUser = tableUsers.query(tableUsers.ALL_COLUMNS,null,null,null,null,null);
        cursorUser.moveToFirst();

        Users user = tableUsers.getCurrentUserFromCursor(cursorUser);






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
