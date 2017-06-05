package com.example.usuario.examlp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.examlp3.dao.UserDAO;

import static com.example.usuario.examlp3.commons.Commons.NAME_DATABASE;

public class MainActivity extends AppCompatActivity {

    EditText edtUserLog;
    EditText edtPasswordLog;
    Button btnIngresar;
    Button btnRegister;
    UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtUserLog = (EditText)findViewById(R.id.edtUserLog);
        edtPasswordLog = (EditText)findViewById(R.id.edtPassowrndLog);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDAO = new UserDAO(MainActivity.this);

                String usss = edtUserLog.getText().toString();
                String passs = edtPasswordLog.getText().toString();

                String pssword = userDAO.getRegistered(usss);

                if (passs.equals(pssword)){

                    Toast.makeText(getApplicationContext(), "as ingresado correctamente!!",Toast.LENGTH_SHORT).show();
                    Intent rawrr = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(rawrr);

                }else {

                    Toast.makeText(MainActivity.this, "Usuario o password estan incorrectos",Toast.LENGTH_SHORT).show();
                    edtUserLog.setText("");
                    edtPasswordLog.setText("");

                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainRegistActivity.class));
            }
        });


    }

   /* public void ingFragment(View view){

        if (view.getId() == R.id.btnIngresar){
            String usss = edtUserLog.getText().toString();
            String passs = edtPasswordLog.getText().toString();
            String pssword = userDAO.finfUserAll(usss);
            if (passs.equals(pssword)){
                Intent rawrr = new Intent(this, MainFragmenActivity.class);
                rawrr.putExtra("Username",usss);
                startActivity(rawrr);
            }else {
                Toast.makeText(MainActivity.this, "User or password invalid !!!!",Toast.LENGTH_SHORT).show();
            }
        }if (view.getId() == R.id.btnRegister){
            Intent in = new Intent(this,MainRegistActivity.class);
            startActivity(in);
        }

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /*public void intoFragment(View view){
        Intent i = new Intent(this, MainFragmenActivity.class);
        startActivity(i);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent in = new Intent(MainActivity.this,MainRegistActivity.class);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
