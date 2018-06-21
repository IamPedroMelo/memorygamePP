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
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private Button[][] button = new Button[4][4];

    TextView tv_01, tv_02;

    //ImageView iv_01, iv_02, iv_03, iv_04, iv_05, iv_06, iv_07, iv_08, iv_09, iv_10, iv_11, iv_12, iv_13, iv_14, iv_15, iv_16;
    ImageView iv [][] = new ImageView[4][4];


    //array das imagens
    //Integer[] imgarray = {101, 102, 103, 104, 105, 106, 107, 108, 201, 202, 203, 204, 205, 206, 207, 208};
    int[][] imagens = new int[][] {
        {101, 102, 103, 104},
        {105, 106, 107, 108},
        {101, 102, 103, 104},
        {105, 106, 107, 108}
    };

    //imagens atuais
    int imagem101, imagem102, imagem103, imagem104, imagem105, imagem106, imagem107, imagem108, imagem201, imagem202, imagem203, imagem204, imagem205, imagem206, imagem207, imagem208;

    int firstImage, secondImage;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    private String username;




    int playerScore = 0;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv_01 = findViewById(R.id.textViewPontuacao);
        tv_02 = findViewById(R.id.textViewUsername);

        iv[0][0] = (ImageView) findViewById(R.id.iv_00);
        iv[0][1] = (ImageView) findViewById(R.id.iv_01);
        iv[0][2] = (ImageView) findViewById(R.id.iv_02);
        iv[0][3] = (ImageView) findViewById(R.id.iv_03);
        iv[1][0] = (ImageView) findViewById(R.id.iv_10);
        iv[1][1] = (ImageView) findViewById(R.id.iv_11);
        iv[1][2] = (ImageView) findViewById(R.id.iv_12);
        iv[1][3] = (ImageView) findViewById(R.id.iv_13);
        iv[2][0] = (ImageView) findViewById(R.id.iv_20);
        iv[2][1] = (ImageView) findViewById(R.id.iv_21);
        iv[2][2] = (ImageView) findViewById(R.id.iv_22);
        iv[2][3] = (ImageView) findViewById(R.id.iv_23);
        iv[3][0] = (ImageView) findViewById(R.id.iv_30);
        iv[3][1] = (ImageView) findViewById(R.id.iv_31);
        iv[3][2] = (ImageView) findViewById(R.id.iv_32);
        iv[3][3] = (ImageView) findViewById(R.id.iv_33);



        final AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
        alertDialog.setMessage("Insira o seu username");

        final EditText input = new EditText(GameActivity.this);
        alertDialog.setView(input);
        alertDialog.setCanceledOnTouchOutside(false);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if(keyCode==KeyEvent.KEYCODE_BACK){
                    finish();
                }
                return true;
            }
        });
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean wantToCloseDialog = false;
                if ((input.getText().toString().length())>15){
                    input.setError(getString(R.string.muito_grande));
                } else if(input.getText().toString().compareTo("") == 0) {
                    input.setError(getString(R.string.nao_tem_caracteres));
                } else if (input.getText().toString().contains(" ")) {
                    input.setError(getString(R.string.tem_espaços));
                } else {
                    tv_02.setText(input.getText().toString());
                    wantToCloseDialog = true;
                }
                if (wantToCloseDialog)
                    alertDialog.dismiss();
            }
        });

        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                iv[linha][coluna].setTag(new Integer(linha * 10 + coluna));

                iv[linha][coluna].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int theImg = (Integer) v.getTag();
                        int linha = theImg / 10;
                        int coluna = theImg % 10;
                        seeImage((ImageView) v, linha, coluna);
                    }
                });
            }
        }


        tv_01.setText(playerScore+" POINTS");

        //carrega imagens
        frontOfCardResources();

        //mistura as imgens
        Collections.shuffle(Arrays.asList(imagens));
    }

    private void seeImage(ImageView imgv, int linha, int coluna){
        if(imagens[linha][coluna] == 101){
            imgv.setImageResource(imagem101);
        }else if(imagens[linha][coluna] == 102){
            imgv.setImageResource(imagem102);
        }else if(imagens[linha][coluna] == 103){
            imgv.setImageResource(imagem103);
        }else if(imagens[linha][coluna] == 104){
            imgv.setImageResource(imagem104);
        }else if(imagens[linha][coluna]  == 105){
            imgv.setImageResource(imagem105);
        }else if(imagens[linha][coluna]  == 106){
            imgv.setImageResource(imagem106);
        }else if(imagens[linha][coluna]  == 107){
            imgv.setImageResource(imagem107);
        }else if(imagens[linha][coluna]  == 108){
            imgv.setImageResource(imagem108);
        }


        // ver imagem selecionada e guardar temporariamente
        if(cardNumber == 1){
            firstImage = imagens[linha][coluna];
            /*if(firstImage > 200){
                firstImage = firstImage-100;
            }*/
            cardNumber = 2;
            clickedFirst = imagens[linha][coluna];

            imgv.setEnabled(false);
        } else if(cardNumber ==2){
            secondImage = imagens[linha][coluna];
            /*if(secondImage > 200){
                secondImage = secondImage-100;
            }*/
            cardNumber = 1;
            clickedSecond = imagens[linha][coluna];

            /*for (int l = 0; linha < 4; linha++) {
                for (int c = 0; coluna < 4; coluna++) {
                    iv[linha][coluna].setEnabled(false);
                }
            }*/
            iv[linha][coluna].setEnabled(false);
            
            /*iv_01.setEnabled(false);
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
            iv_16.setEnabled(false);*/


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
            for (int linha = 0; linha < 4; linha++) {
                for (int coluna = 0; coluna < 4; coluna++) {
                    int tag = (Integer) iv[linha][coluna].getTag();
                    int l= tag/10;
                    int c= tag%0;
                    if(clickedFirst == imagens[l][c]){
                        iv[linha][coluna].setVisibility(View.INVISIBLE);
                    }
                }
            }
            
            /*if (clickedFirst == 0) {
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
            }*/

            for (int linha = 0; linha < 4; linha++) {
                for (int coluna = 0; coluna < 4; coluna++) {
                    int tag = (Integer) iv[linha][coluna].getTag();
                    int l= tag/10;
                    int c= tag%0;
                    if(clickedSecond == imagens[l][c]){
                        iv[linha][coluna].setVisibility(View.INVISIBLE);
                    }
                }
            }

            /*if (clickedSecond == 0) {
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
            }*/

            playerScore = playerScore +10;
            tv_01.setText(playerScore+" POINTS");



        } else {

            if(playerScore>=5){
                playerScore=playerScore-5;
                tv_01.setText(playerScore+" POINTS");
            }

            for (int linha = 0; linha < 4; linha++) {
                for (int coluna = 0; coluna < 4; coluna++) {
                    iv[linha][coluna].setImageResource(R.drawable.image_question_mark);
                }
            }

            /*iv_01.setImageResource(R.drawable.image_question_mark);
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
            iv_16.setImageResource(R.drawable.image_question_mark);*/

        }

        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                iv[linha][coluna].setEnabled(true);
            }
        }

        /*iv_01.setEnabled(true);
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
        iv_16.setEnabled(true);*/

        checkEnd();
    }
    
    private boolean checkVisible(){
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                if(iv[linha][coluna].getVisibility() == View.VISIBLE){
                    return false;
                }
            }
        }
        return true;
    }

        private void checkEnd(){
            if (checkVisible()==true
                    /*iv_01.getVisibility() == View.INVISIBLE &&
                    iv_02.getVisibility() == View.INVISIBLE &&
                    iv_03.getVisibility() == View.INVISIBLE &&
                    iv_04.getVisibility() == View.INVISIBLE &&
                    iv_05.getVisibility() == View.INVISIBLE &&
                    iv_06.getVisibility() == View.INVISIBLE &&
                    iv_07.getVisibility() == View.INVISIBLE &&
                    iv_08.getVisibility() == View.INVISIBLE &&
                    iv_09.getVisibility() == View.INVISIBLE &&
                    iv_10.getVisibility() == View.INVISIBLE &&
                    iv_11.getVisibility() == View.INVISIBLE &&
                    iv_12.getVisibility() == View.INVISIBLE &&
                    iv_13.getVisibility() == View.INVISIBLE &&
                    iv_14.getVisibility() == View.INVISIBLE &&
                    iv_15.getVisibility() == View.INVISIBLE &&
                    iv_16.getVisibility() == View.INVISIBLE*/) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);
                alertDialogBuilder
                        .setMessage("Parabéns, a sua pontuação final é: "+playerScore)
                        .setCancelable(false)
                        .setPositiveButton("Novo Jogo", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                alertDialog.setCanceledOnTouchOutside(false);

            }
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
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Desistir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        //alertDialog.setCanceledOnTouchOutside(false);

    }
}
