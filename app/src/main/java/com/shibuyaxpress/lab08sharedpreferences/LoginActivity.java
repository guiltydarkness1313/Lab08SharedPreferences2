package com.shibuyaxpress.lab08sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUser,editTextPassword;
    private String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUser=findViewById(R.id.edit_username);
        editTextPassword=findViewById(R.id.edit_password);

    }

    public void Check(View view) {
        username = editTextUser.getText().toString();
        password = editTextPassword.getText().toString();
        User u= new User();
        u.CheckUsers(username,password);
        Intent launcher=new Intent(this,MenuActivity.class);
        startActivity(launcher);
    }
}
