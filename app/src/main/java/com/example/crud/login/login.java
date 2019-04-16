package com.example.crud.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.Activity.MainActivity;
import com.example.crud.MapsActivity;
import com.example.crud.R;
import com.example.crud.register.Register;

public class login extends AppCompatActivity implements LoginContract.View{
    private LoginPresenter presenter;
    private EditText editUser ,editPass;
    private Button btnLogin;
    private Button btnregister;
    private CheckBox checkBox;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editUser = findViewById(R.id.etuser);
        editPass = findViewById(R.id.etpass);
        presenter = new LoginPresenter(this);
        checkBox = findViewById(R.id.chklogin);



        editor = getSharedPreferences("IDN",MODE_PRIVATE).edit();
        btnregister = findViewById(R.id.daftar);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregister = new Intent(login.this, Register.class);
                startActivity(gotoregister);
            }
        });
        btnLogin = findViewById(R.id.btnlog);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginClicked(editUser, editPass);
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("IDN",MODE_PRIVATE);
        if (sharedPreferences.getBoolean("ingatsaya",false)) {
            Intent gotomainActivity = new Intent(login.this, MainActivity.class);
            gotomainActivity.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            gotomainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(gotomainActivity);
            finish();
        }
    }

    @Override
    public void showLoggingIn() {
        Toast.makeText(login.this,"Logging in......",Toast.LENGTH_SHORT).show();
        presenter.requestLogin(editUser.getText().toString(),editPass.getText().toString());

    }

    @Override
    public void showToastFormNotValid() {
        Toast.makeText(login.this, "Username And Pass CAnnot be empty", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(login.this, "Login Sucses", Toast.LENGTH_SHORT).show();
        if (checkBox.isChecked()) {

            editor.putBoolean("ingatsaya",true);
        }else{
            editor.putBoolean("ingatsaya",false);
        }
        editor.apply();
        Intent gotomainActivity = new Intent(login.this, MainActivity.class);
        startActivity(gotomainActivity);
        finish();

    }

    @Override
    public void loginFailed() {
        Toast.makeText(login.this, "LoginFailed", Toast.LENGTH_SHORT).show();

    }
}
