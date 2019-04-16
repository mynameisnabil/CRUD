package com.example.crud.Activity;

public interface MainAcitivityContract {
    interface Presenter{
        void seeAllBiodata();
        void addBiodata();

    }

    interface View{
        void gotoListBiodata();
        void gotoaddBiodata();

    }
}
