package com.example.crud;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.crud.lihat.LihatBiodataContract;
import com.example.crud.model.DataItem;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<DataItem> dataItems;
    private LihatBiodataContract.Presenter presenter;

    public Adapter(LihatBiodataContract.Presenter presenter, List<DataItem> dataItems){
        this.presenter = presenter;
        this.dataItems = dataItems;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder myViewHolder, final int i) {


        myViewHolder.nama.setText(dataItems.get(i).getNamaSiswa());
        myViewHolder.kelas.setText(dataItems.get(i).getKelasSiswa());
        myViewHolder.email.setText(dataItems.get(i).getEmailSiswa());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToEditBiodata(dataItems.get(i));


            }
        });

        myViewHolder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.confirmDeletion(dataItems.get(i).getIdSiswa());
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama, kelas, email;
        Button btndelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.namal);
            kelas = itemView.findViewById(R.id.kelasl);
            email = itemView.findViewById(R.id.emaill);
            btndelete = itemView.findViewById(R.id.btndelete);
        }
    }
}