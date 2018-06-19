package pt.ipg.memorygamepp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.AccessControlContext;

import static java.security.AccessController.getContext;
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
        //getContext().deleteDatabase(DbMemoryGameOpenHelper.DATABASE_NAME);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        AccessControlContext appContext = getContext();

        //DbMemoryGameOpenHelper dbMemoryGameOpenHelper = new DbMemoryGameOpenHelper(appContext);
        //SQLiteDatabase db = dbMemoryGameOpenHelper.getReadableDatabase();

        //assertTrue("Não conseguiu abrir/criar a base de dados",db.isOpen());

    }
}
