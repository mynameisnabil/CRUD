package com.example.crud.tambah;

public interface TambahBiodataContract {
    interface Presenter{
        void Addbiodata( String nama, String kelas, String email);

    }

    interface View{
        void showProgressDialog();
        void addSucces();
        void addFailed();
        void ShowFormNotValid();


    }
}
