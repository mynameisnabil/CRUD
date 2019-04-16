package com.example.crud.register;


import android.util.Patterns;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.crud.BaseApp;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterPresenter implements RegisterContract.Presenter {
    RegisterContract.View view;

    RegisterPresenter(RegisterContract.View view){
        this.view = view;
    }


    @Override
    public void register(String username, String nama, String password, String email) {
        if(nama.length()>0&&username.length()>0&&password.length()>0&&email.length()>0&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            AndroidNetworking.post(BaseApp.BASE_URL+"register")
                    .setPriority(Priority.HIGH)
                    .addUrlEncodeFormBodyParameter("username",username)
                    .addUrlEncodeFormBodyParameter("nama",nama)
                    .addUrlEncodeFormBodyParameter("password",password)
                    .addUrlEncodeFormBodyParameter("email",email)
                    .build()
            .getAsJSONObject(new JSONObjectRequestListener() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response.getBoolean("status")) {
                            view.registerSucces();
                        } else {
                            view.registerFailed();

                        }
                    } catch (JSONException e) {
                        view.registerFailed();
                        e.printStackTrace();
                    }

                }

                @Override
                public void onError(ANError anError) {
                    view.registerFailed();


                }
            });

        }else{
            view.ShowFormNotValid();
        }
    }
}