package pt.ipg.memorygamepp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
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

        
    }

    @NonNull
    private Users ReadFirstUser(DbTableUsers TableUsers, String usernameesperado, long idesperado) {
        Cursor cursor = TableUsers.query(DbTableUsers.ALL_COUMNS, null,null,null,null,null);
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
