package com.loftblog.moneytracker.api;


import com.loftblog.moneytracker.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by macbook on 13.11.17.
 */

public interface Api {

    @GET("items")
    Call<List<Item>> items(@Query("type") String type);


}
