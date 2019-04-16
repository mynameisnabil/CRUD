package com.example.crud.lihat;


import com.example.crud.model.DataItem;

import java.util.List;

public interface LihatBiodataContract {
    interface Presenter{
        void getListBiodata();
        void deleteBiodata(String id);
        void goToEditBiodata(DataItem biodata);
        void confirmDeletion(String id);
    }

    interface View{
        void showListBiodata(List Biodata);
        void goToEditBiodata(DataItem biodata);
        void showMessageDeleteSucces();
        void showMessageDeleteFailed();
        void showDeletion(String id);


    }
}
