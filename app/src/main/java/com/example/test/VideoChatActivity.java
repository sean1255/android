package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import us.zoom.sdk.MeetingError;
import us.zoom.sdk.MeetingService;
import us.zoom.sdk.MeetingServiceListener;
import us.zoom.sdk.MeetingStatus;
import us.zoom.sdk.ZoomSDK;
import us.zoom.sdk.ZoomAuthenticationError;
import us.zoom.sdk.ZoomSDKAuthenticationListener;
import us.zoom.sdk.ZoomSDKInitParams;
import us.zoom.sdk.ZoomSDKInitializeListener;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.util.Calendar.getInstance;

public class VideoChatActivity extends AppCompatActivity {

    private JoinMeetingDialog joinMeetingDialog;
    private LoginDialog loginDialog;
    private Button join;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_chat);

        //setting
        join = (Button)findViewById(R.id.join_button);
        login = (Button)findViewById(R.id.login_button);

        join.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                 joinMeetingDialog = new JoinMeetingDialog(getApplicationContext(), joinMeetingListener, joinCancelListener);
                 joinMeetingDialog.show();
            }
        });

        login.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                loginDialog = new LoginDialog(getApplicationContext(), loginListener, loginCancelListener);
                loginDialog.show();
            }
        });
    }

    private View.OnClickListener joinMeetingListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "화상 채팅을 시작합니다.", Toast.LENGTH_SHORT).show();
            joinMeetingDialog.dismiss();
        }
    };

    private View.OnClickListener joinCancelListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "화상 채팅 참여를 취소합니다.", Toast.LENGTH_SHORT).show();
            joinMeetingDialog.dismiss();
        }
    };

    private View.OnClickListener loginListener = new View.OnClickListener() {
        public  void onClick(View v) {
            Toast.makeText(getApplicationContext(), "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
            loginDialog.dismiss();
        }
    };

    private View.OnClickListener loginCancelListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "로그인 참여를 취소합니다.", Toast.LENGTH_SHORT).show();
            loginDialog.dismiss();
        }
    };

    private void initSdk(Context context) {

        ZoomSDK sdk = ZoomSDK.getInstance();

        ZoomSDKInitParams params = new ZoomSDKInitParams();
        params.appKey = Credentials.SDK_KEY;
        params.appSecret = Credentials.SDK_SECRET;
        params.domain = Credentials.SDK_DOMAIN;
        params.enableLog = true;

        ZoomSDKInitializeListener listener = new ZoomSDKInitializeListener() {
            @Override
            public void onZoomSDKInitializeResult(int errorCode, int internalErrorCode) { }

            @Override
            public void onZoomAuthIdentityExpired() { }
        };

        sdk.initialize(context, listener, params);
    }
}