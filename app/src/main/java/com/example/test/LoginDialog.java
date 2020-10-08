package com.example.test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {

    private Button loginButton;
    private Button cancelButton;

    private View.OnClickListener loginListener;
    private View.OnClickListener cancelListener;


    public LoginDialog(@NonNull Context context, View.OnClickListener loginListener, View.OnClickListener cancelListener) {
        super(context);
        this.loginListener = loginListener;
        this.cancelListener = cancelListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 밖의 화면을 흐리게 만듦
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);

        setContentView(R.layout.login_dialog);

        //setting
        loginButton = (Button)findViewById(R.id.login_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);

        //click listener setting
        loginButton.setOnClickListener(loginListener);
        cancelButton.setOnClickListener(cancelListener);
    }
}
