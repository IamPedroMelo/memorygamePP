package pt.ipg.memorygamepp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

public class menuActivity extends AppCompatActivity {

    private Button buttonjogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        buttonjogo = (Button) findViewById(R.id.buttonnovojogo);

        buttonjogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });

    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    /*public void MudaActivityGame(View view) {

        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);

    }*/



    public void MudaActivityAjuda(View view) {
        Intent intent = new Intent(this,helpActivity.class);
        startActivity(intent);
    }

    public void Sair(View view) {
        finish();
    }

    public void MudaActivityPontuacao(View view) {
        Intent intent = new Intent(this,pontuacaoActivity.class);
        startActivity(intent);
    }
}
