package com.example.crud.tambah;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.R;

public class TambahBiodataActivity extends AppCompatActivity  implements TambahBiodataContract.View{
    EditText editnama, editkelas, editemail;
    Button btnsimpan;

    private ProgressDialog progressDialog;

    private TambahBiodataPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        editnama = findViewById(R.id.ednama2);
        editkelas = findViewById(R.id.edkelas2);
        editemail = findViewById(R.id.edemail2);
        btnsimpan = findViewById(R.id.simpan2);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");


        presenter = new TambahBiodataPresenter(this);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.Addbiodata(
                        editnama.getText().toString(),
                        editkelas.getText().toString(),
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
    public void addSucces() {
        progressDialog.dismiss();
        Toast.makeText(this, "Tambah Sukses", Toast.LENGTH_SHORT).show();
        finish();

    }

    @Override
    public void addFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "Gagal menambah Data", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void ShowFormNotValid() {
        Toast.makeText(this, "Data Not Valid", Toast.LENGTH_SHORT).show();

    }
}
