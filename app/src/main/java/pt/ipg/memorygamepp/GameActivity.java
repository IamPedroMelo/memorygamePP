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
import android.widget.Button;
import android.widget.GridLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

   // private static final int BUTTONS_MARGIN = 100;


    private Button[][] button = new Button[4][4];


    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        button[0][0] = (Button) findViewById(R.id.button00);
        button[0][1] = (Button) findViewById(R.id.button01);
        button[0][2] = (Button) findViewById(R.id.button02);
        button[0][3] = (Button) findViewById(R.id.button03);
        button[1][0] = (Button) findViewById(R.id.button10);
        button[1][1] = (Button) findViewById(R.id.button11);
        button[1][2] = (Button) findViewById(R.id.button12);
        button[1][3] = (Button) findViewById(R.id.button13);
        button[2][0] = (Button) findViewById(R.id.button20);
        button[2][1] = (Button) findViewById(R.id.button21);
        button[2][2] = (Button) findViewById(R.id.button22);
        button[2][3] = (Button) findViewById(R.id.button23);
        button[3][0] = (Button) findViewById(R.id.button30);
        button[3][1] = (Button) findViewById(R.id.button31);
        button[3][2] = (Button) findViewById(R.id.button32);
        button[3][3] = (Button) findViewById(R.id.button33);




       /* Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        int width = size.x < size.y ? size.x : size.y;
        width -= BUTTONS_MARGIN * 3;


        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                button[row][col].setLayoutParams(new GridLayout.LayoutParams());

                //button[row][col].setWidth(width/4);
                //button[row][col].setHeight(width/4);
            }
        }*/


    }

    @Override
    public void onClick(View v) {

    }
}
