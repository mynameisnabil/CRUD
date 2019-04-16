package com.example.crud.tambah;

import android.util.Patterns;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.crud.BaseApp;

import org.json.JSONException;
import org.json.JSONObject;

public class TambahBiodataPresenter implements TambahBiodataContract.Presenter {
    TambahBiodataContract.View view;

    TambahBiodataPresenter(TambahBiodataContract.View view){
        this.view = view;
    }


    @Override
    public void Addbiodata(String nama, String kelas, String email) {
        if(nama.length()>0&&kelas.length()>0&&email.length()>0&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            AndroidNetworking.post(BaseApp.BASE_URL+"insertDatasiswa")
                    .setPriority(Priority.HIGH)
                    .addUrlEncodeFormBodyParameter("nama",nama)
                    .addUrlEncodeFormBodyParameter("kelas",kelas)
                    .addUrlEncodeFormBodyParameter("email",email)
                    .build()
                    //banyak kelasnya jika menggunakan getA
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.getBoolean("status")){
                                    view.addSucces();
                                }else {
                                    view.addFailed();

                                }
                            } catch (JSONException e) {
                                view.addFailed();
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onError(ANError anError) {
                            view.addFailed();


                        }
                    });

        }else{
            view.ShowFormNotValid();
        }
    }
}
