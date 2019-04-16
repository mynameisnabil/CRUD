package com.example.crud.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crud.MapsActivity;
import com.example.crud.R;
import com.example.crud.login.login;
import com.example.crud.tambah.TambahBiodataActivity;
import com.example.crud.lihat.LihatBiodataDataActivity;

public class MainActivity extends AppCompatActivity implements MainAcitivityContract.View {
    private Button btnListBiodata, btnAddBiodata, btnout , btnmaps;
    private MainActivityPresenter presenter;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListBiodata = findViewById(R.id.lihatdata);
        btnAddBiodata = findViewById(R.id.tambah);
        btnout = findViewById(R.id.out);
        btnmaps = findViewById(R.id.maps);
        presenter = new MainActivityPresenter(this);
        editor = getSharedPreferences("IDN",MODE_PRIVATE).edit();

        btnListBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.seeAllBiodata();
            }
        });

        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("ingatsaya");
                editor.apply();
                Intent logout = new Intent(MainActivity.this,login.class);
                logout.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                logout.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(logout);
                finish();
            }
        });

        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaps = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(gotomaps);
            }
        });




        btnAddBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addBiodata();
            }
        });

    }

    @Override
    public void gotoListBiodata() {
        Intent gotoListBiodata = new Intent(MainActivity.this, LihatBiodataDataActivity.class);
        startActivity(gotoListBiodata);


    }

    @Override
    public void gotoaddBiodata() {
        Intent gotoAddBiodata = new Intent(MainActivity.this, TambahBiodataActivity.class);
        startActivity(gotoAddBiodata);

    }



}
