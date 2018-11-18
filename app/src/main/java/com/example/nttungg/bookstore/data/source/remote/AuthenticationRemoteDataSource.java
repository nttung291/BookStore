package com.example.nttungg.bookstore.data.source.remote;

import android.support.annotation.NonNull;

import com.example.nttungg.bookstore.data.model.User;
import com.example.nttungg.bookstore.data.source.AuthenticationDataSource;
import com.example.nttungg.bookstore.data.source.remote.api.service.BookStoreApi;

import io.reactivex.Observable;

public class AuthenticationRemoteDataSource implements AuthenticationDataSource.RemoteDataSource {

    private static AuthenticationRemoteDataSource sAuthenticationRemoteDataSource;
    private BookStoreApi mBookStoreApi;

    public static AuthenticationRemoteDataSource getInstance(@NonNull BookStoreApi bookStoreApi) {
        if (sAuthenticationRemoteDataSource == null) {
            sAuthenticationRemoteDataSource = new AuthenticationRemoteDataSource(bookStoreApi);
        }

        return sAuthenticationRemoteDataSource;
    }

    private AuthenticationRemoteDataSource(BookStoreApi bookStoreApi) {
        mBookStoreApi = bookStoreApi;
    }

    @Override
    public Observable<User> loginByUsernameAndPassword(String username, String password) {
        return mBookStoreApi.loginByUsernameAndPassword(username, password);
    }
}
