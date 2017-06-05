package com.example.usuario.examlp3.commons;

import com.example.usuario.examlp3.dao.UserDAO;

/**
 * Created by Usuario on 02/06/2017.
 */

public class Commons {

    public static final String NAME_DATABASE = "usuarios.db";
    public static final String NAME_TABLE = "User";
    public static final String CREATE_TABLE = "create table User" +
            "(" +
            "id integer primary key," +
            "name text," +
            "lastName text," +
            "usuario text," +
            "password text," +
            "email text" +
            ");";
    public static final String DROP_TABLE = "DROP TABLE IF EXIST User";

}
