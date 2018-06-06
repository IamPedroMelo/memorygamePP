package pt.ipg.memorygamepp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    private int numberOfElements;

    private MemoryGame[] buttons;

    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    private MemoryGame selectedButton1;
    private MemoryGame selectedButton2;

    private boolean isBusy = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout_4x4);

        int numColumns = gridLayout.getColumnCount();
        int numRow = gridLayout.getRowCount();

        numberOfElements = numColumns * numRow;

        buttons = new MemoryGame[numberOfElements];
        buttonGraphics = new int[numberOfElements/2];

        buttonGraphics[0]=R.drawable.botao_11;
        buttonGraphics[1]=R.drawable.botao_12;
        buttonGraphics[2]=R.drawable.botao_13;
        buttonGraphics[3]=R.drawable.botao_14;
        buttonGraphics[4]=R.drawable.botao_15;
        buttonGraphics[5]=R.drawable.botao_16;
        buttonGraphics[6]=R.drawable.botao_17;
        buttonGraphics[7]=R.drawable.botao_18;



    }

}
