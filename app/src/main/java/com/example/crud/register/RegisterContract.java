package com.example.crud.register;

public interface RegisterContract {
    interface Presenter{
        void register( String username, String nama, String password, String email);

    }

    interface View{
        void showProgressDialog();
        void registerSucces();
        void registerFailed();
        void ShowFormNotValid();


    }
}
