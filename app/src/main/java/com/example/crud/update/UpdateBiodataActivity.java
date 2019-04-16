package com.example.crud.update;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.R;
import com.example.crud.model.DataItem;

public class UpdateBiodataActivity extends AppCompatActivity implements UpdateBiodataContarct.View{
    private UpdateBiodataPresenter presenter;
    EditText upnama, upkelas, upemail;
    Button btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        final DataItem dataItem = (DataItem) getIntent().getSerializableExtra("biodata");

        upnama = findViewById(R.id.upnama);
        upkelas = findViewById(R.id.upkelas);
        upemail = findViewById(R.id.upemail);
        btnupdate = findViewById(R.id.update);

        upnama.setText(dataItem.getNamaSiswa());
        upemail.setText(dataItem.getEmailSiswa());
        upkelas.setText(dataItem.getKelasSiswa());

        presenter = new UpdateBiodataPresenter(this);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateBiodata(
                        dataItem.getIdSiswa()
                        ,upnama.getText().toString()
                        ,upkelas.getText().toString()
                        ,upemail.getText().toString()
                );
            }
        });

    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void updateSucces() {
        Toast.makeText(this, "Update Berhasil", Toast.LENGTH_SHORT).show();
        finish();

    }

    @Override
    public void updateFailed() {
        Toast.makeText(this, "Update Gagal", Toast.LENGTH_SHORT).show();

    }
}
