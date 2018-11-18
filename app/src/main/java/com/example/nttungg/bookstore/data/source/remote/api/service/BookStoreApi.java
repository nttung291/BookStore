package com.example.nttungg.bookstore.data.source.remote.api.service;

import com.example.nttungg.bookstore.data.model.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BookStoreApi {

    @FormUrlEncoded
    @POST("LoginServerlet")
    Observable<User> loginByUsernameAndPassword(@Field("username") String username,
                                                @Field("password") String password);
}
