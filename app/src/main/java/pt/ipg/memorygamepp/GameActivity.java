package pt.ipg.memorygamepp;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.GridLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private int numberOfElements;

    private MemoryGame[] buttons;

    private buttons[][]

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


        Display display = getWindowManager().getDefaultDisplay();
        //DisplayMetrics displayMetrics = GameActivity.this.getResources().getDisplayMetrics();

        Point size = new Point();
        display.getSize(size);

        int width = size.x < size.y ? size.x : size.y;


        buttons[0][0] = findViewById(R.id.button00);


        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

            }
        }

        button1.setWidth(width/4);
        button2.setHeight(width/4);



        /*android.support.v7.widget.GridLayout grid = (android.support.v7.widget.GridLayout)findViewById(R.id.grid_layout_4x4);

       // GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout_4x4);

        int numColumns = grid.getColumnCount();
        int numRow = grid.getRowCount();

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
                grid.addView(tempButton);
            }
        }
    */

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
            selectedButton1.setMatched(true);

            selectedButton1.setEnabled(false);
            button.setEnabled(false);

            selectedButton1 = null;

            return;
        } else {
            selectedButton2 = button;
            selectedButton2.flip();
            isBusy = true;

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedButton2.flip();
                    selectedButton1.flip();
                    selectedButton1 = null;
                    selectedButton2 = null;
                    isBusy = false;
                }
            },500);

        }


    }
}
