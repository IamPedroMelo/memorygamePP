package pt.ipg.memorygamepp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class menuActivity extends AppCompatActivity {

    private Button buttonjogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        buttonjogo = (Button) findViewById(R.id.buttonnovojogo);

        buttonjogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void MudaActivityAjuda(View view) {
        Intent intent = new Intent(this,helpActivity.class);
        startActivity(intent);
    }

    public void Sair(View view) {
        finish();
    }

    public void MudaActivityPontuacao(View view) {
        Intent intent = new Intent(this,RecyclerViewPontuacao.class);
        startActivity(intent);
    }
}
