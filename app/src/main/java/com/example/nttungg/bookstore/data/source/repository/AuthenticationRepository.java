package com.example.nttungg.bookstore.data.source.repository;

import android.support.annotation.NonNull;

import com.example.nttungg.bookstore.data.model.User;
import com.example.nttungg.bookstore.data.source.AuthenticationDataSource;

import io.reactivex.Observable;

public class AuthenticationRepository implements AuthenticationDataSource.LocalDataSource,
        AuthenticationDataSource.RemoteDataSource {

    private static AuthenticationRepository sAuthenticationRepository;

    private AuthenticationDataSource.LocalDataSource mLocalDataSource;
    private AuthenticationDataSource.RemoteDataSource mRemoteDataSource;

    public static AuthenticationRepository getInstance(
            @NonNull AuthenticationDataSource.RemoteDataSource remoteDataSource,
            @NonNull AuthenticationDataSource.LocalDataSource localDataSource) {
        if (sAuthenticationRepository == null) {
            sAuthenticationRepository =
                    new AuthenticationRepository(localDataSource, remoteDataSource);
        }

        return sAuthenticationRepository;
    }

    private AuthenticationRepository(AuthenticationDataSource.LocalDataSource localDataSource,
                                     AuthenticationDataSource.RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void saveLoggedUser(User loginDataResponse) {
        mLocalDataSource.saveLoggedUser(loginDataResponse);
    }

    @Override
    public void deleteLoggedUser() {
        mLocalDataSource.deleteLoggedUser();
    }

    @Override
    public User getLoggedUser() {
        return mLocalDataSource.getLoggedUser();
    }

    @Override
    public Observable<User> loginByUsernameAndPassword(String username, String password) {
        return mRemoteDataSource.loginByUsernameAndPassword(username, password);
    }
}
