package com.example.crud.update;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.crud.BaseApp;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateBiodataPresenter implements UpdateBiodataContarct.Presenter {
    private UpdateBiodataContarct.View view;
    UpdateBiodataPresenter(UpdateBiodataContarct.View view) {
        this.view = view;
    }

    @Override
    public void updateBiodata(String id, String nama, String kelas, String email) {
        AndroidNetworking.post(BaseApp.BASE_URL+"updateDataSiswa")
                .setPriority(Priority.HIGH)
                .addBodyParameter("id" , id)
                .addBodyParameter("nama", nama)
                .addBodyParameter("email",email)
                .addBodyParameter("kelas", kelas)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getBoolean("status"))
                                view.updateSucces();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        view.updateFailed();

                    }
                });

    }
}
