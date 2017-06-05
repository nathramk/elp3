package com.example.usuario.examlp3.bean;

/**
 * Created by Usuario on 02/06/2017.
 */

public class User {

    private int id;
    private String name;
    private String lastName;
    private String usuario;
    private String password;




    @Override
    public String toString() {
        return id + name + lastName + usuario;
    }

    public User(){}

    public User(int id, String name, String lastName, String usuario, String password, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
