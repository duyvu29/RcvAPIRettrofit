package com.example.rcvapirettrofit.apiServierce;

import static retrofit2.converter.gson.GsonConverterFactory.*;

import com.example.rcvapirettrofit.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiJSON {
    //https://jsonplaceholder.typicode.com/posts?userId=1
    Gson gson = new GsonBuilder().setLenient().create();
    apiJSON api = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory( GsonConverterFactory.create(gson))
            .build()
            .create(apiJSON.class);

    @GET("posts")
    Call<List<User>> getDataJson(@Query("userId") int userId);

}
