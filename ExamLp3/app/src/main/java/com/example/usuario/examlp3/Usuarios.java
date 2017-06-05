package com.example.usuario.examlp3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.examlp3.bean.User;
import com.example.usuario.examlp3.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.mode;
import static android.R.attr.name;

/**
 * Created by Usuario on 04/06/2017.
 */

public class Usuarios extends Fragment {

    public static int layouts = android.R.layout.simple_list_item_1;


    SQLiteDatabase db;
    UserDAO userDAO;
    ListView listUser;
    int userId;
    ArrayList<String> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.usuarios_tab, container, false);

        userDAO = new UserDAO(getActivity());
        listUser = (ListView) view.findViewById(R.id.listUser);

        lista = userDAO.llenar_list();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), layouts, lista);
        listUser.setAdapter(adapter);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), lista.get(position),Toast.LENGTH_SHORT).show();


            }
        });

        FloatingActionButton floDelt = (FloatingActionButton) view.findViewById(R.id.floDelt);
        floDelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eliminarUser(userId);


            }
        });



       /*
        usuarioId = usuariosReg.getUsuarioId();
       db = userDAO.getReadableDatabase();
        if (db!=null){
            Cursor cursor = db.rawQuery("select * from User", null);
            int cantidad = cursor.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if (cursor.moveToFirst()){
                do {
                    String liner = cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3);

                    arreglo[i] = liner;
                    i++;

                }while (cursor.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), layouts, lista);
            listUser.setAdapter(adapter);




            public void testDelete(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        PersonDAO dao = new PersonDAO(appContext);
        Person person = dao.findPersonById(4L);
        assertNotNull(person);

        dao.deletePersonById(4L);
        person = dao.findPersonById(4L);
        assertNull(person);
    }

    public void deletePersonById(Long id){
        String where="id="+id;
        getWritableDatabase().delete(TABLE_PERSON,where,null);
    }


        }*/
        return view;
    }

    public void eliminarUser(int id){
        UserDAO usDAO = new UserDAO(getActivity());
        SQLiteDatabase db = usDAO.getWritableDatabase();
        String sql = "delete from User where id="+id;
        db.execSQL(sql);
        db.close();

    }


}
