package pt.ipg.memorygamepp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class memorygametest {

    @Before
    public void setUp(){
        getContext().deleteDatabase(DbMemoryGameOpenHelper.DATABASE_NAME);
    }

    @Test
    public void useAppContext() {
        //Context of the app under test.
        Context appContext = getContext();

        DbMemoryGameOpenHelper dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(appContext);
        SQLiteDatabase db = dbMemoryGameOpenHelper.getReadableDatabase();

        assertTrue("Não conseguiu abrir a Base de Dados",db.isOpen());
        db.close();

    }

    @Test
    public void usersCRUDTest(){
        Context appContext = getContext();
        
        DbMemoryGameOpenHelper dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(appContext);
        SQLiteDatabase db = dbMemoryGameOpenHelper.getReadableDatabase();
        
        DbTableUsers TableUsers = new DbTableUsers(db);
        
        Users user = new Users();
        user.setUsername("JoaquimAbilio");
        
        //Create-CRUD
        long id = TableUsers.insert(DbTableUsers.getContentValues(user));
        
        assertNotEquals("Falhou ao inserir um user",-1,id);
        
        //Read-CRUD
        user = ReadFirstUser(TableUsers,"JoaquimAbilio",id);

        //Update-CRUD
        user.setUsername("Slade");
        int rowsAffected = TableUsers.update(
                DbTableUsers.getContentValues(user),
                DbTableUsers._ID + "=?",
                new String[]{ Long.toString(id)}
        );

        assertEquals("Falhou a dar o update do user",1,rowsAffected);

        user = ReadFirstUser(TableUsers,"Slade",id);

        //Delete- Crud
        rowsAffected = TableUsers.delete(
                DbTableUsers._ID + "=?",
                new String[]{Long.toString(id)}
        );

        assertEquals("Falhou a apagar o user",1,rowsAffected);

        Cursor cursor = TableUsers.query(DbTableUsers.ALL_COLUMNS,null,null,null,null,null);
        assertEquals("Users encontrados depois do delete??",0,cursor.getCount());

    }

    @Test
    public void HighscoresCRUDTest(){

        DbMemoryGameOpenHelper dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(getContext());
        SQLiteDatabase db = dbMemoryGameOpenHelper.getReadableDatabase();

        DbTableUsers TableUsers = new DbTableUsers(db);
        DbTableHighScores TableHighscores = new DbTableHighScores(db);

        Users user = new Users();
        user.setUsername("Pedro");
        long UserId = TableUsers.insert(DbTableUsers.getContentValues(user));

        assertNotEquals("Falhou a inserir um user",-1,UserId);

        //Create - CRUD
        HighScores highScores = new HighScores();

        highScores.setScore(50);
        highScores.setUserId((int) UserId);
        long id = TableHighscores.insert(DbTableHighScores.getContentValues(highScores));
        assertNotEquals("Falhou a inserir os highScores",-1,id);
        
        //Read-CRUD
        highScores = ReadFirstHighScores(TableHighscores,50,UserId,id);

        //Update-CRUD
        highScores.setScore(70);
        int rowsAffected = TableHighscores.update(
                DbTableHighScores.getContentValues(highScores),
                DbTableHighScores._ID + "=?",
                new String[]{Long.toString(id)}
        );
        assertEquals("Falhou a dar update no socre",1,rowsAffected);

        //query/read R - CRUD

        highScores = ReadFirstHighScores(TableHighscores, 70,UserId,id);

        //delete-CRUD

        rowsAffected = TableHighscores.delete(
                DbTableHighScores._ID + "=?",
                new String[]{Long.toString(id)}
        );
        assertEquals("Falhou a apagar",1,rowsAffected);

        Cursor cursor = TableHighscores.query(DbTableHighScores.ALL_COLUMNS, null, null,null,null,null );
        assertEquals("Scores encontrados depois do delete?",0,cursor.getCount());

    }


    private HighScores ReadFirstHighScores(DbTableHighScores tableHighscores, long expectedscore,long useridesperado, long idesperado) {
        Cursor cursor = tableHighscores.query(DbTableHighScores.ALL_COLUMNS,null,null,null,null,null);
        assertEquals("Falhou a ler o highscore",1,cursor.getCount());

        assertTrue("falhou a ler os highscores",cursor.moveToNext());

        HighScores highscores = DbTableHighScores.getCurrentHighScoresFromCursor(cursor);
        assertEquals("Score incorreto",expectedscore,highscores.getScore());
        assertEquals("score userid incorreto",useridesperado,highscores.getUserId());
        assertEquals("Score id",idesperado,highscores.getId());
        return highscores;
    }


    @NonNull
    private Users ReadFirstUser(DbTableUsers TableUsers, String usernameesperado, long idesperado) {
        Cursor cursor = TableUsers.query(DbTableUsers.ALL_COLUMNS, null,null,null,null,null);
        assertEquals("Falhou a leitura",1,cursor.getCount());

        assertTrue("Falhou a ler o primeiro user",cursor.moveToNext());

        Users user = DbTableUsers.getCurrentUserFromCursor(cursor);
        assertEquals("Username incorreto",usernameesperado,user.getUsername());
        assertEquals("id incorreto",idesperado,user.getId());
        return user;
    }


    public Context getContext() {
        return InstrumentationRegistry.getTargetContext();
    }
}
