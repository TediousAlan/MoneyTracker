package com.loftblog.moneytracker;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loftblog.moneytracker.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macbook on 13.11.17.
 */

public class App extends Application {

    private Api api;

    @Override
    public void onCreate() {
        super.onCreate();


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        Level loggingLevel = BuildConfig.DEBUG ? Level.BODY : Level.NONE;
        interceptor.setLevel(loggingLevel);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://loftschoolandroid1117.getsandbox.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }
}
