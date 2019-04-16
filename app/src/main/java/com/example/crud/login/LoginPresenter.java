package com.example.crud.login;

import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.crud.BaseApp;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    LoginPresenter(LoginContract.View view){
        this.view = view;

    }
    @Override
    public void loginClicked(EditText userName, EditText password){

        if(userName.getText().length()>0&&password.getText().length()>0){
            view.showLoggingIn();
        }else {
            view.showToastFormNotValid();
        }

    }

    @Override
    public void requestLogin(String userName, String password) {
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username",userName);
            jsonBody.put("password",password);
        }catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(BaseApp.BASE_URL + "login")
                .setPriority(Priority.HIGH)
                .addJSONObjectBody(jsonBody)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener(){
            @Override
            public void onResponse(JSONObject response) {
                view.loginSuccess();

            }

            @Override
            public void onError(ANError anError) {
                view.loginFailed();

            }
        });
    }
}
