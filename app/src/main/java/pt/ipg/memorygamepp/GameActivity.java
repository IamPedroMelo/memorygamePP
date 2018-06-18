package pt.ipg.memorygamepp;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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

    TextView tv_01;

    ImageView iv_01,iv_02,iv_03,iv_04,iv_05,iv_06,iv_07,iv_08,iv_09,iv_10,iv_11,iv_12,iv_13,iv_14,iv_15,iv_16;

    //array das imagens
    Integer[] imgarray = {101,102,103,104,105,106,107,108,201,202,203,204,205,206,207,208};

    //imagens atuais
    int imagem101,imagem102,imagem103,imagem104,imagem105,imagem106,imagem107,imagem108,imagem201,imagem202,imagem203,imagem204,imagem205,imagem206,imagem207,imagem208;

    int firstImage , secondImage;
    int clickedFirst, clickedSecond;
    int cardNumber =1;

    int playerScore = 0;


    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        tv_01 = findViewById(R.id.textViewPontuacao);

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
        iv_04.setTag("3");
        iv_05.setTag("4");
        iv_06.setTag("5");
        iv_07.setTag("6");
        iv_08.setTag("7");
        iv_09.setTag("8");
        iv_10.setTag("9");
        iv_11.setTag("10");
        iv_12.setTag("11");
        iv_13.setTag("12");
        iv_14.setTag("13");
        iv_15.setTag("14");
        iv_16.setTag("15");

        tv_01.setText(playerScore+" POINTS");

        //carrega imagens
        frontOfCardResources();

        //mistura as imgens
        Collections.shuffle(Arrays.asList(imgarray));

        iv_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_01, theImg);
            }
        });
        iv_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_02, theImg);
            }
        });
        iv_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_03, theImg);
            }
        });
        iv_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_04, theImg);
            }
        });
        iv_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_05, theImg);
            }
        });
        iv_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_06, theImg);
            }
        });
        iv_07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_07, theImg);
            }
        });
        iv_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_08, theImg);
            }
        });
        iv_09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_09, theImg);
            }
        });
        iv_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_10, theImg);
            }
        });
        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_11, theImg);
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_12, theImg);
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_13, theImg);
            }
        });
        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_14, theImg);
            }
        });
        iv_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_15, theImg);
            }
        });
        iv_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theImg = Integer.parseInt((String)view.getTag());
                seeImage(iv_16, theImg);
            }
        });


    }

    private void seeImage(ImageView iv, int numcard){
        if(imgarray[numcard] == 101){
            iv.setImageResource(imagem101);
        }else if(imgarray[numcard] == 102){
            iv.setImageResource(imagem102);
        }else if(imgarray[numcard] == 103){
            iv.setImageResource(imagem103);
        }else if(imgarray[numcard] == 104){
            iv.setImageResource(imagem104);
        }else if(imgarray[numcard] == 105){
            iv.setImageResource(imagem105);
        }else if(imgarray[numcard] == 106){
            iv.setImageResource(imagem106);
        }else if(imgarray[numcard] == 107){
            iv.setImageResource(imagem107);
        }else if(imgarray[numcard] == 108){
            iv.setImageResource(imagem108);
        }else if(imgarray[numcard] == 201){
            iv.setImageResource(imagem201);
        }else if(imgarray[numcard] == 202){
            iv.setImageResource(imagem202);
        }else if(imgarray[numcard] == 203){
            iv.setImageResource(imagem203);
        }else if(imgarray[numcard] == 204){
            iv.setImageResource(imagem204);
        }else if(imgarray[numcard] == 205){
            iv.setImageResource(imagem205);
        }else if(imgarray[numcard] == 206){
            iv.setImageResource(imagem206);
        }else if(imgarray[numcard] == 207){
            iv.setImageResource(imagem207);
        }else if (imgarray[numcard] == 208){
            iv.setImageResource(imagem208);


        }


        // ver imagem selecionada e guardar temporariamente
        if(cardNumber == 1){
            firstImage = imgarray[numcard];
            if(firstImage > 200){
                firstImage = firstImage-100;
            }
            cardNumber = 2;
            clickedFirst = numcard;

            iv.setEnabled(false);
        } else if(cardNumber ==2){
            secondImage = imgarray[numcard];
            if(secondImage > 200){
                secondImage = secondImage-100;
            }
            cardNumber = 1;
            clickedSecond = numcard;

            iv_01.setEnabled(false);
            iv_02.setEnabled(false);
            iv_03.setEnabled(false);
            iv_04.setEnabled(false);
            iv_05.setEnabled(false);
            iv_06.setEnabled(false);
            iv_07.setEnabled(false);
            iv_08.setEnabled(false);
            iv_09.setEnabled(false);
            iv_10.setEnabled(false);
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_15.setEnabled(false);
            iv_16.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },1000);

        }
    }

    //se as imagens forem iguais vão desaparecer e contar para o score
    private void calculate() {
        if (firstImage == secondImage) {
            if (clickedFirst == 0) {
                iv_01.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_02.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_03.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_04.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_05.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_06.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_07.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_08.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_09.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv_16.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_01.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_02.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_03.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_04.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_05.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_06.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_07.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_08.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_09.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv_16.setVisibility(View.INVISIBLE);
            }

            playerScore = playerScore +10;
            tv_01.setText(playerScore+" POINTS");



        } else {

            if(playerScore>=5){
                playerScore=playerScore-5;
                tv_01.setText(playerScore+" POINTS");
            }

            iv_01.setImageResource(R.drawable.image_question_mark);
            iv_02.setImageResource(R.drawable.image_question_mark);
            iv_03.setImageResource(R.drawable.image_question_mark);
            iv_04.setImageResource(R.drawable.image_question_mark);
            iv_05.setImageResource(R.drawable.image_question_mark);
            iv_06.setImageResource(R.drawable.image_question_mark);
            iv_07.setImageResource(R.drawable.image_question_mark);
            iv_08.setImageResource(R.drawable.image_question_mark);
            iv_09.setImageResource(R.drawable.image_question_mark);
            iv_10.setImageResource(R.drawable.image_question_mark);
            iv_11.setImageResource(R.drawable.image_question_mark);
            iv_12.setImageResource(R.drawable.image_question_mark);
            iv_13.setImageResource(R.drawable.image_question_mark);
            iv_14.setImageResource(R.drawable.image_question_mark);
            iv_15.setImageResource(R.drawable.image_question_mark);
            iv_16.setImageResource(R.drawable.image_question_mark);

        }

        iv_01.setEnabled(true);
        iv_02.setEnabled(true);
        iv_03.setEnabled(true);
        iv_04.setEnabled(true);
        iv_05.setEnabled(true);
        iv_06.setEnabled(true);
        iv_07.setEnabled(true);
        iv_08.setEnabled(true);
        iv_09.setEnabled(true);
        iv_10.setEnabled(true);
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_15.setEnabled(true);
        iv_16.setEnabled(true);

    }

        private void frontOfCardResources () {
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

    public void Sair(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setMessage("Se desistir perde o seu progresso! Têm a certeza que quer sair?");
        builder.setCancelable(true);
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Desistir!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
