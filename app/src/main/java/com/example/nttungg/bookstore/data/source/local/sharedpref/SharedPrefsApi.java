package com.example.nttungg.bookstore.data.source.local.sharedpref;

public interface SharedPrefsApi {
    <T> T get(String key, Class<T> clazz);

    <T> void put(String key, T data);

    void delete(String key);

    void clear();
}
