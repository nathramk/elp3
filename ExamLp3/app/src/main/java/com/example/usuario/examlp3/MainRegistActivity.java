package com.example.usuario.examlp3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.examlp3.bean.User;
import com.example.usuario.examlp3.dao.UserDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.usuario.examlp3.commons.Commons.NAME_DATABASE;

public class MainRegistActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtLastName;
    EditText edtUser;
    EditText edtPassword;
    EditText edtRepeatPassword;
    Button btnIngres;
    EditText edtEmail;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "mypref";
    public static final String Username1 = "nameKey";
    public static final String Username2 = "lastNameKey";

    UserDAO userDAO = new UserDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_regist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtName = (EditText)findViewById(R.id.edtName);
        edtLastName = (EditText)findViewById(R.id.edtLastName);
        edtUser = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtRepeatPassword = (EditText)findViewById(R.id.edtRepeatPassword);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        btnIngres = (Button)findViewById(R.id.btnSave);

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        btnIngres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtName.getText().toString();
                String lastName = edtLastName.getText().toString();
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();
                String repeatPassword = edtRepeatPassword.getText().toString();
                String email = edtEmail.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Username1, name);
                editor.putString(Username2, lastName);
                editor.commit();

                if (repeatPassword.equals(password) && isValidEmail(email) && isValidPassword(password)) {
                    User users = new User();
                    users.setName(name);
                    users.setLastName(lastName);
                    users.setUsuario(user);
                    users.setPassword(password);
                    users.setEmail(email);
                    userDAO.saveUser(users);
                    Toast.makeText(MainRegistActivity.this, "registrado", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                 } else {

                    edtEmail.setError("el correo deve contener un ...@mail.com");
                    edtPassword.setError("la contraseña deve de tener mas de 6 carecteres");
                    Toast.makeText(getApplicationContext(), "Campos vacios ", Toast.LENGTH_SHORT).show();

                }
                }

        });



    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 6) {
            return true;
        }
        return false;
    }

   /* public void ingresClik(View view){

    }*/

}
