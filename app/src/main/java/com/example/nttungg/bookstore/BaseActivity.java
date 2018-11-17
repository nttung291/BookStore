package com.example.nttungg.bookstore;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(@StringRes int id) {
        Toast.makeText(this, getString(id), Toast.LENGTH_SHORT).show();
    }

    protected void notifyErrorConnectionToServer() {
        showToast("Lỗi kết nối! Vui lòng thử lại!");
    }

}
