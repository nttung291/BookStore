package com.example.nttungg.bookstore.screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nttungg.bookstore.BaseActivity;
import com.example.nttungg.bookstore.BookStoreApplication;
import com.example.nttungg.bookstore.R;
import com.example.nttungg.bookstore.data.model.User;
import com.example.nttungg.bookstore.data.source.local.AuthenticationLocalDataSource;
import com.example.nttungg.bookstore.data.source.remote.AuthenticationRemoteDataSource;
import com.example.nttungg.bookstore.data.source.repository.AuthenticationRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private AuthenticationRepository mAuthenticationRepository;
    private CompositeDisposable mCompositeDisposable;

    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mButtonLogin;
    private TextView mTextRegister;

    public static Intent getLoginIntent(Context context) {
        Intent mIntent = new Intent(context, LoginActivity.class);
        return mIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mCompositeDisposable = new CompositeDisposable();
        mAuthenticationRepository = AuthenticationRepository.getInstance(
                AuthenticationRemoteDataSource.getInstance(BookStoreApplication.getBookStoreApi()),
                AuthenticationLocalDataSource
                        .getInstance(BookStoreApplication.getSharedPrefsApi()));
        initUI();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                login(mEditUsername.getText().toString(), mEditPassword.getText().toString());
                break;
            case R.id.textView_register:
                startActivity(RegisterActivity.getRegisterIntent(this));
                break;
        }
    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
        super.onStop();
    }

    private void initUI() {
        mEditUsername = findViewById(R.id.editText_username_login);
        mEditPassword = findViewById(R.id.edittext_password_login);
        mButtonLogin = findViewById(R.id.button_login);
        mTextRegister = findViewById(R.id.textView_register);
        mButtonLogin.setOnClickListener(this);
        mTextRegister.setOnClickListener(this);
    }

    private void login(String username, String password) {
        mCompositeDisposable.add(mAuthenticationRepository.loginByUsernameAndPassword("", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) {

                    }
                })
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        Toast.makeText(LoginActivity.this,
                                user.getUsername() + " " + user.getPassword(),
                                Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Toast.makeText(LoginActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT)
                                .show();
                    }
                }));

//        username = StringUtils.removeAllWhiteSpace(username);
//        password = StringUtils.removeAllWhiteSpace(password);
//
//        if (StringUtils.isNullOrBlank(username) || StringUtils.isNullOrBlank(password)) {
//            showToast("Wrong format");
//        }
    }
}
