package com.example.nttungg.bookstore.screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nttungg.bookstore.BaseActivity;
import com.example.nttungg.bookstore.R;
import com.example.nttungg.bookstore.utils.StringUtils;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
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

    private void initUI() {
        mEditUsername = findViewById(R.id.editText_username_login);
        mEditPassword = findViewById(R.id.edittext_password_login);
        mButtonLogin = findViewById(R.id.button_login);
        mTextRegister = findViewById(R.id.textView_register);
        mButtonLogin.setOnClickListener(this);
        mTextRegister.setOnClickListener(this);
    }

    private void login(String username, String password) {
        username = StringUtils.removeAllWhiteSpace(username);
        password = StringUtils.removeAllWhiteSpace(password);

        if (StringUtils.isNullOrBlank(username) || StringUtils.isNullOrBlank(password)) {
            showToast("Wrong format");
        }
    }
}
