package com.example.crud;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.onesignal.OneSignal;

import okhttp3.OkHttpClient;
public class BaseApp extends Application {
    //Base Url
    public static String BASE_URL = "http://idn-nabil.000webhostapp.com/api_rpla/index.php/Api/";
    @Override
    public void onCreate() {
        super.onCreate();
        //http client yang bisa melakukan method yang ada api
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("IDN",message);
        //untuk membaca requestny
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        AndroidNetworking.initialize(this,okHttpClient);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
