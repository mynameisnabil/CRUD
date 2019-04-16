package com.example.crud.update;

public interface UpdateBiodataContarct {
    interface Presenter{
        void updateBiodata(String id, String nama, String kelas, String email);


    }

    interface View{
        void showProgressDialog();
        void updateSucces();
        void updateFailed();
    }
}
