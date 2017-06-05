package com.example.usuario.examlp3.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.examlp3.Usuarios;
import com.example.usuario.examlp3.bean.User;
import com.example.usuario.examlp3.commons.Commons;

import java.util.ArrayList;

import static android.R.attr.id;
import static com.example.usuario.examlp3.commons.Commons.CREATE_TABLE;
import static com.example.usuario.examlp3.commons.Commons.DROP_TABLE;
import static com.example.usuario.examlp3.commons.Commons.NAME_DATABASE;
import static com.example.usuario.examlp3.commons.Commons.NAME_TABLE;

/**
 * Created by Usuario on 02/06/2017.
 */

public class UserDAO extends SQLiteOpenHelper {

    SQLiteDatabase db;
    String passw;

    public UserDAO(Context context) {
        super(context, Commons.NAME_DATABASE, null,VERSION_DATABAS);
    }
    private static final int VERSION_DATABAS = 2;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db;

    }

    public void saveUser(User user){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", user.getName());
        values.put("lastName", user.getLastName());
        values.put("usuario", user.getUsuario());
        values.put("password", user.getPassword());
        values.put("email", user.getEmail());
        db.insert(NAME_TABLE,null,values);
        db.close();

    }

    public String getRegistered(String userName){

        db = this.getReadableDatabase();
       // String where = "id = "+id;

        //new String[] {userName};
        Cursor cursor = db.query(NAME_TABLE, null,"usuario=?",new String[]{userName},null,null,null,null);

        if (cursor.getCount() < 1){
            cursor.close();
            return "Not Exist";
        }else if (cursor.getCount() >= 1 && cursor.moveToFirst()){
            passw = cursor.getString(cursor.getColumnIndex("password"));
            cursor.close();
        }
        return passw;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        this.onCreate(db);

    }
    public ArrayList<String> llenar_list(){
        ArrayList<String> lists = new ArrayList<>();
        db = this.getReadableDatabase();
        String quer = "SELECT * FROM User";
        Cursor regs = db.rawQuery(quer, null);

        //variables para ordenar
        String name = " nombre: ";
        String lastname = " apellido: ";
        String users = " usuario: ";
        if (regs.moveToFirst()){
            User user = new User();
            do {

                user.setId(regs.getInt(0));
                user.setName(name+regs.getString(1)+lastname);
                user.setLastName(regs.getString(2)+users);
                user.setUsuario(regs.getString(3));

                lists.add(user.toString());

            }while (regs.moveToNext());
        }
        return lists;
    }
    public void upDate(User user){
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("lastName", user.getLastName());
        values.put("usuario", user.getUsuario());
        values.put("password", user.getPassword());
        values.put("email", user.getEmail());
        getWritableDatabase().update(NAME_TABLE, values,"id="+user.getId(),null);

    }

    public User findUserById(int id) {
        String columns[]={"id","name","lastName","usuario","password","email"};
        String where="id="+id;
        Cursor cursor = getReadableDatabase().query(NAME_TABLE,columns,where,null,null,null,null);
        User user=null;
        while (cursor.moveToNext()){
            user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setLastName(cursor.getString(2));
            user.setUsuario(cursor.getString(3));
            user.setPassword(cursor.getString(4));
            user.setEmail(cursor.getString(5));
        }
        return user;
    }

    public void deleteUserById(String id){
        String where="id="+id;
        //getWritableDatabase().delete(NAME_TABLE,where,null);
        db.delete(NAME_TABLE, where,null);
    }






    public String getDatabaseName(){
        return NAME_DATABASE;
    }
    public static String getKeyId() {
        return "id";
    }

    public static String getTableContacts() {
        return "User";
    }

    public static int getDatabaseVersion() {
        return VERSION_DATABAS;
    }
}
