package com.example.crud.register;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.R;
import com.example.crud.tambah.TambahBiodataPresenter;

public class Register extends AppCompatActivity implements RegisterContract.View {
    EditText editnama2, editpass, editemail, editusername;
    Button btnregister;

    private RegisterPresenter presenter2;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editnama2 = findViewById(R.id.ednama3);
        editpass = findViewById(R.id.edpas);
        editemail = findViewById(R.id.edemail3);
        btnregister = findViewById(R.id.register);
        editusername = findViewById(R.id.edsername);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");


        presenter2 = new RegisterPresenter(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter2.register(
                        editusername.getText().toString(),
                        editnama2.getText().toString(),
                        editpass.getText().toString(),
                        editemail.getText().toString()
                );
            }
        });






    }


    @Override
    public void showProgressDialog() {
        progressDialog.show();

    }

    @Override
    public void registerSucces() {
        progressDialog.dismiss();
        Toast.makeText(this, "Register Sukses", Toast.LENGTH_SHORT).show();
        finish();

    }

    @Override
    public void registerFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "Gagal Register Data", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void ShowFormNotValid() {
        Toast.makeText(this, "Data Not Valid", Toast.LENGTH_SHORT).show();

    }
}
