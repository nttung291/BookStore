package com.example.nttungg.bookstore.data.source;

import com.example.nttungg.bookstore.data.model.User;

import io.reactivex.Observable;

public interface AuthenticationDataSource {

    interface RemoteDataSource {
        Observable<User> loginByUsernameAndPassword(String username, String password);
    }

    interface LocalDataSource {
        void saveLoggedUser(User loginDataResponse);

        void deleteLoggedUser();

        User getLoggedUser();
    }
}
