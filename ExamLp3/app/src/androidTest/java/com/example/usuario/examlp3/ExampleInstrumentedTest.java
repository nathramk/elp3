package com.example.usuario.examlp3;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.usuario.examlp3.bean.User;
import com.example.usuario.examlp3.dao.UserDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.usuario.examlp3", appContext.getPackageName());

        UserDAO dao = new UserDAO(appContext);
        User person = new User();
        person.setName("Omar");
        person.setLastName("Perez");
        person.setUsuario("Perez2");
        dao.saveUser(person);



        dao.close();
    }
}
