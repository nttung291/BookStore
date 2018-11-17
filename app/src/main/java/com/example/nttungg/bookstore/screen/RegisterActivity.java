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

public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private EditText mEditFullname;
    private EditText mEditUsername;
    private EditText mEditRePassword;
    private EditText mEditPassword;
    private Button mButtonRegister;
    private TextView mTextLogin;

    public static Intent getRegisterIntent(Context context) {
        Intent mIntent = new Intent(context, RegisterActivity.class);
        return mIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();

    }

    private void initUI() {
        mEditUsername = findViewById(R.id.editText_username_register);
        mEditPassword = findViewById(R.id.editText_password_register);
        mEditFullname = findViewById(R.id.editText_fullname_register);
        mEditRePassword = findViewById(R.id.editText_repassword_register);
        mButtonRegister = findViewById(R.id.button_register);
        mTextLogin = findViewById(R.id.textView_login);
        mTextLogin.setOnClickListener(this);
        mButtonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_register:
                if (!mEditPassword.getText().toString().equals(mEditRePassword.getText().toString())){
                    showToast("Password does not match");
                } else {

                }
                break;
            case R.id.textView_login:
                onBackPressed();
                this.finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
