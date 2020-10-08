package com.example.test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

public class JoinMeetingDialog extends Dialog {

    private Button joinButton;
    private Button cancelButton;

    private View.OnClickListener joinListener;
    private View.OnClickListener cancelListener;

    public JoinMeetingDialog(@NonNull Context context, View.OnClickListener joinListener, View.OnClickListener cancelListener) {
        super(context);
        this.joinListener = joinListener;
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

        setContentView(R.layout.activity_join_meeting_dialog);

        //셋팅
        joinButton = (Button)findViewById(R.id.join_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);

        //클릭 리스너 셋팅
        joinButton.setOnClickListener(joinListener);
        cancelButton.setOnClickListener(cancelListener);

    }
}
