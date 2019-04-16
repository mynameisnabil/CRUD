package com.example.crud.lihat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.crud.Adapter;
import com.example.crud.R;
import com.example.crud.update.UpdateBiodataActivity;
import com.example.crud.model.DataItem;

import java.util.List;

public class LihatBiodataDataActivity extends AppCompatActivity implements LihatBiodataContract.View {
    private LihatBiodataPresenter presenter;
    private RecyclerView recyclerView;
    private Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        recyclerView = findViewById(R.id.rvBiodata);
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(llm);

        presenter = new LihatBiodataPresenter(this);
        presenter.getListBiodata();




    }


    @Override
    public void showListBiodata(List Biodata) {




        if(Biodata != null&& Biodata.size()>0){
            Toast.makeText(this, "Biodata sidah didapat", Toast.LENGTH_SHORT).show();

            adapter = new Adapter(presenter,Biodata);
            recyclerView.setAdapter(adapter);
        }else {
            recyclerView.setAdapter(null);
            Toast.makeText(this, "Biodata Kosong", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void goToEditBiodata(DataItem biodata) {
        Intent intent = new Intent(LihatBiodataDataActivity.this, UpdateBiodataActivity.class);
        intent.putExtra("biodata",biodata);
        startActivity(intent);
    }

    @Override
    public void showMessageDeleteSucces() {
        Toast.makeText(this, "Berhasil Menghapus", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showMessageDeleteFailed() {
        Toast.makeText(this, "Gagal Menghapus", Toast.LENGTH_SHORT).show();

    }



    @Override
    public void showDeletion(final String id) {
        new AlertDialog.Builder(this)
                .setMessage("Ingin menghapus")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.deleteBiodata(id);
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();


    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.getListBiodata();
    }
}
