package com.example.nttungg.bookstore.data.source.local;

import android.support.annotation.NonNull;

import com.example.nttungg.bookstore.data.model.User;
import com.example.nttungg.bookstore.data.source.AuthenticationDataSource;
import com.example.nttungg.bookstore.data.source.local.sharedpref.SharedPrefsApi;
import com.example.nttungg.bookstore.data.source.local.sharedpref.SharedPrefsKey;
import com.google.gson.Gson;

public class AuthenticationLocalDataSource implements AuthenticationDataSource.LocalDataSource {

    private static AuthenticationLocalDataSource sAuthenticationLocalDataSource;
    private SharedPrefsApi mSharedPrefsApi;

    public static AuthenticationLocalDataSource getInstance(@NonNull SharedPrefsApi sharedPrefsApi) {
        if (sAuthenticationLocalDataSource == null) {
            sAuthenticationLocalDataSource = new AuthenticationLocalDataSource(sharedPrefsApi);
        }
        return sAuthenticationLocalDataSource;
    }

    private AuthenticationLocalDataSource(SharedPrefsApi sharedPrefsApi) {
        mSharedPrefsApi = sharedPrefsApi;
    }

    @Override
    public void saveLoggedUser(User loginDataResponse) {
        String data = new Gson().toJson(loginDataResponse);
        mSharedPrefsApi.put(SharedPrefsKey.PREFERENCE_LOGIN_DATA_RESPONSE_KEY, data);
    }

    @Override
    public void deleteLoggedUser() {
        mSharedPrefsApi.delete(SharedPrefsKey.PREFERENCE_LOGIN_DATA_RESPONSE_KEY);
    }

    @Override
    public User getLoggedUser() {
        String data = mSharedPrefsApi.get(SharedPrefsKey.PREFERENCE_LOGIN_DATA_RESPONSE_KEY,
                String.class);
        return new Gson().fromJson(data, User.class);
    }
}
