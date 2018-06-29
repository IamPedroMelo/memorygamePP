package pt.ipg.memorygamepp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_01, tv_02;

    ImageView iv [][] = new ImageView[4][4];

    private boolean podeInteragir = true;

    //matriz das imagens
    int[][] imagens = new int[][] {
        {101, 102, 103, 104},
        {105, 106, 107, 108},
        {101, 102, 103, 104},
        {105, 106, 107, 108}
    };

    //imagens atuais
    int imagem101, imagem102, imagem103, imagem104, imagem105, imagem106, imagem107, imagem108;

    int firstImage, secondImage;
    int cardNumber = 1;
    private String username;
    private Users user = new Users();
    private HighScores highScores = new HighScores();
    private Cursor cursor;

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


        //abrir a base de dados
        DbMemoryGameOpenHelper dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(getApplicationContext());
        final SQLiteDatabase db = dbMemoryGameOpenHelper.getWritableDatabase();

        final DbTableUsers tableUsers = new DbTableUsers(db);
        final DbTableHighScores tableHighScores = new DbTableHighScores(db);


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
                        verImagem((ImageView) v, linha, coluna);

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

    private void verImagem(ImageView imgv, int linha, int coluna){
        if (!podeInteragir) return;

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

            cardNumber = 2;

            imgv.setEnabled(false);
        } else {
            podeInteragir = false;

            secondImage = imagens[linha][coluna];

            cardNumber = 1;

            imgv.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                    podeInteragir = true;
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
                    int c= tag%10;
                    if(firstImage == imagens[l][c]){
                        iv[linha][coluna].setVisibility(View.INVISIBLE);
                    }
                }
            }

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

        }

        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                iv[linha][coluna].setEnabled(true);
            }
        }
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

            Users users = new Users();
            user.setUsername(tv_02.getText().toString());
            int idUser = (int) DbTableUsers.insert(DbTableUsers.getContentValues(users));
            HighScores highScores = new HighScores();
            highScores.setScore(playerScore);
            highScores.setUserId(idUser);
            DbTableHighScores.insert(DbTableHighScores.getContentValues(highScores));

            if (checkVisible()==true) {


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
        alertDialog.setCanceledOnTouchOutside(false);

    }
}
