package com.shibuyaxpress.lab08sharedpreferences.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.shibuyaxpress.lab08sharedpreferences.R;
import com.shibuyaxpress.lab08sharedpreferences.models.User;
import com.shibuyaxpress.lab08sharedpreferences.repositories.UserRepository;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
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
        Intent launcher=new Intent(this,MenuActivity.class);
        username = editTextUser.getText().toString();
        password = editTextPassword.getText().toString();
        preferences= PreferenceManager.getDefaultSharedPreferences(this);

        if(TextUtils.isEmpty(username)){
            editTextUser.setError("Necesita ingresar datos");
        }else if(TextUtils.isEmpty(password)){
            editTextPassword.setError("Necesita ingresar una contraseña");
        }
        else{
            List<User> lista=UserRepository.list();
            for(int i=0; i<lista.size();i++){
                boolean fail=false;
                System.out.println(lista.get(i).getId()+lista.get(i).getUsername());
                if(lista.get(i).getUsername().equals(username)&&lista.get(i).getPassword().equals(password)){
                    System.out.println("se identifico correctamente");
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("username",username).commit();
                    startActivity(launcher);
                    break;

                }else {
                    if(!(lista.get(i).getPassword().equals(password)) && fail==true){
                        editTextPassword.setError("Contraseña fallida");
                        fail=true;
                    }
                    if(lista.size()==i){
                        UserRepository.create(username,password);
                        SharedPreferences.Editor editor= preferences.edit();
                        editor.putString("username",username).commit();
                        startActivity(launcher);
                        break;
                    }

                }
            }







        }

    }
}
