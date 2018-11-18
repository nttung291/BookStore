package com.example.nttungg.bookstore;


import android.app.Application;

import com.example.nttungg.bookstore.data.source.local.sharedpref.SharedPrefsApi;
import com.example.nttungg.bookstore.data.source.local.sharedpref.SharedPrefsImpl;
import com.example.nttungg.bookstore.data.source.remote.api.service.BookStoreApi;
import com.example.nttungg.bookstore.data.source.remote.api.service.BookStoreService;

public class BookStoreApplication extends Application {

    private static BookStoreApplication sBookStoreApplication;
    private static SharedPrefsApi mSharedPrefsApi;

    @Override
    public void onCreate() {
        super.onCreate();
        sBookStoreApplication = this;
    }

    public static BookStoreApplication getInstance() {
        return sBookStoreApplication;
    }

    public static BookStoreApi getBookStoreApi() {
        return BookStoreService.getInstance(sBookStoreApplication);
    }

    public static SharedPrefsApi getSharedPrefsApi() {
        if (mSharedPrefsApi == null) {
            mSharedPrefsApi = new SharedPrefsImpl(sBookStoreApplication);
        }

        return mSharedPrefsApi;
    }
}
