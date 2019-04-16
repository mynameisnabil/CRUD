package com.example.crud.lihat;

import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.crud.BaseApp;
import com.example.crud.model.DataItem;
import com.example.crud.model.ResponseData;

import org.json.JSONException;
import org.json.JSONObject;

public class LihatBiodataPresenter implements LihatBiodataContract.Presenter {

    LihatBiodataContract.View view;

    LihatBiodataPresenter(LihatBiodataContract.View view){
        this.view = view;
    }

    @Override
    public void getListBiodata() {
        AndroidNetworking.get(BaseApp.BASE_URL+"getAllSiswa")
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponseData.class, new ParsedRequestListener<ResponseData>() {
                    @Override
                    public void onResponse(ResponseData response) {
                        view.showListBiodata(response.getData());

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    @Override
    public void deleteBiodata(String id) {
        AndroidNetworking.post(BaseApp.BASE_URL + "DeleteDataSiswa")
                .setPriority(Priority.HIGH)
                .addBodyParameter("id", id)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    //masuk onrespons jika 200 dan terusannya
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getBoolean("status")){
                                getListBiodata();
                                view.showMessageDeleteSucces();
                            }else {
                                view.showMessageDeleteFailed();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.showMessageDeleteFailed();

                    }
                });

    }

    @Override
    public void goToEditBiodata(DataItem biodata) {
        view.goToEditBiodata(biodata);

    }

    @Override
    public void confirmDeletion(String id) {
        view.showDeletion(id);
    }
}
