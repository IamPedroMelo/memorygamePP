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
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private Button[][] button = new Button[4][4];


    ImageView iv_01,iv_02,iv_03,iv_04,iv_05,iv_06,iv_07,iv_08,iv_09,iv_10,iv_11,iv_12,iv_13,iv_14,iv_15,iv_16;

    //array das imagens
    Integer[] imgarray = {101,102,103,104,105,106,107,108,201,202,203,204,205,206,207,208};

    //imagens atuais
    int imagem101,imagem102,imagem103,imagem104,imagem105,imagem106,imagem107,imagem108,imagem201,imagem202,imagem203,imagem204,imagem205,imagem206,imagem207,imagem208;

    //int firstImage , secondImage;
    //int clickedFirst, clickedSecond;
    //int cardNumber =1;

    int playerScore = 0;


    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iv_01 = (ImageView) findViewById(R.id.iv_01);
        iv_02 = (ImageView) findViewById(R.id.iv_02);
        iv_03 = (ImageView) findViewById(R.id.iv_03);
        iv_04 = (ImageView) findViewById(R.id.iv_04);
        iv_05 = (ImageView) findViewById(R.id.iv_05);
        iv_06 = (ImageView) findViewById(R.id.iv_06);
        iv_07 = (ImageView) findViewById(R.id.iv_07);
        iv_08 = (ImageView) findViewById(R.id.iv_08);
        iv_09 = (ImageView) findViewById(R.id.iv_09);
        iv_10 = (ImageView) findViewById(R.id.iv_10);
        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);
        iv_15 = (ImageView) findViewById(R.id.iv_15);
        iv_16 = (ImageView) findViewById(R.id.iv_16);

        iv_01.setTag("0");
        iv_02.setTag("1");
        iv_03.setTag("2");
        iv_04.setTag("4");
        iv_05.setTag("5");
        iv_06.setTag("6");
        iv_07.setTag("7");
        iv_08.setTag("8");
        iv_09.setTag("9");
        iv_10.setTag("10");
        iv_11.setTag("11");
        iv_12.setTag("12");
        iv_13.setTag("13");
        iv_14.setTag("14");
        iv_15.setTag("15");
        iv_16.setTag("16");

        //carrega imagens
        frontofCardResources();

        //mistura as imgens
        Collections.shuffle(Arrays.asList(imgarray));

        iv_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
            }
        });
        iv_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void frontofCardResources(){
        imagem101 = R.drawable.image101;
        imagem102 = R.drawable.image102;
        imagem103 = R.drawable.image103;
        imagem104 = R.drawable.image104;
        imagem105 = R.drawable.image105;
        imagem106 = R.drawable.image106;
        imagem107 = R.drawable.image107;
        imagem108 = R.drawable.image108;
        imagem201 = R.drawable.image201;
        imagem202 = R.drawable.image202;
        imagem203 = R.drawable.image203;
        imagem204 = R.drawable.image204;
        imagem205 = R.drawable.image205;
        imagem206 = R.drawable.image206;
        imagem207 = R.drawable.image207;
        imagem208 = R.drawable.image208;

    }

    @Override
    public void onClick(View v) {

    }
}
