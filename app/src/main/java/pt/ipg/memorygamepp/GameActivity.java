package pt.ipg.memorygamepp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private int numberOfElements;

    private MemoryGame[] buttons;

    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    private MemoryGame selectedButton1;
    private MemoryGame selectedButton2;

    private boolean isBusy = false;



    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
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

        buttonGraphicLocations = new int[numberOfElements];

        shuffleButtonGraphics();

        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numColumns; c++) {
                MemoryGame tempButton = new MemoryGame(this,r,c,buttonGraphics[buttonGraphicLocations[r *numColumns+c]]);
                tempButton.setId(View.generateViewId());
                tempButton.setOnClickListener(this);
                buttons[r*numColumns+c] = tempButton;
                gridLayout.addView(tempButton);
            }
        }


    }

    protected void shuffleButtonGraphics(){

        Random rand = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            buttonGraphicLocations[i]= i % (numberOfElements /2);
        }

        for (int i = 0; i < numberOfElements; i++) {
            int temp = buttonGraphicLocations[i];

            int swapIndex = rand.nextInt(16);

            buttonGraphicLocations[i] = buttonGraphicLocations[swapIndex];

            buttonGraphicLocations[swapIndex] = temp;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {

        if(isBusy) return;
        MemoryGame button = (MemoryGame) view;
        if(button.isMatched) return;

        if(selectedButton1 == null){
            selectedButton1 = button;
            selectedButton1.flip();
            return;
        }

        if(selectedButton1.getId()== button.getId()){
            return;
        }

        if(selectedButton1.getFrontDrawableId()==button.getFrontDrawableId()){
            button.flip();
            button.setMatched(true);
            selectedButton1.setEnabled(false);
            selectedButton2.setEnabled(false);
        }

    }
}
