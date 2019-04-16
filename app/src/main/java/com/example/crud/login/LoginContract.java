package com.example.crud.login;

import android.widget.EditText;

public interface LoginContract {
    interface View{
        void showLoggingIn();
        void showToastFormNotValid();
        void loginSuccess();
        void loginFailed();


    }

    interface Presenter{
        void loginClicked(EditText userName, EditText password);
        void requestLogin(String userName, String password);

    }
}
