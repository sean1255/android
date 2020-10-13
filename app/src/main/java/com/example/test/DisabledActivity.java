package com.example.test;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.android.material.textfield.TextInputEditText;

import us.zoom.sdk.JoinMeetingOptions;
import us.zoom.sdk.JoinMeetingParams;
import us.zoom.sdk.MeetingService;
import us.zoom.sdk.StartMeetingOptions;
import us.zoom.sdk.ZoomApiError;
import us.zoom.sdk.ZoomAuthenticationError;
import us.zoom.sdk.ZoomSDK;
import us.zoom.sdk.ZoomSDKAuthenticationListener;
import us.zoom.sdk.ZoomSDKInitParams;
import us.zoom.sdk.ZoomSDKInitializeListener;

public class DisabledActivity extends AppCompatActivity {

    private ZoomSDKAuthenticationListener authLsitener = new ZoomSDKAuthenticationListener() {
        @Override
        public void onZoomSDKLoginResult(long result) {
            if (result == ZoomAuthenticationError.ZOOM_AUTH_ERROR_SUCCESS) {
                startMeeting(DisabledActivity.this);
            }
        }

        @Override
        public void onZoomSDKLogoutResult(long l) { }
        @Override
        public void onZoomIdentityExpired() { }
        @Override
        public void onZoomAuthIdentityExpired() { }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disabled);

        findViewById(R.id.Videocall).setOnClickListener(onClickListener);
        findViewById(R.id.connection).setOnClickListener(onClickListener);
        initSdk(this);
        initViews();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //case R.id.Videocall:
                //    Log.e("화상통화","화상통화");
                //    break;
                case R.id.connection:
                    Log.e("호출","호출");

                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    NotificationCompat.Builder builder = null;

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                        String channelID = "channel_01";
                        String channelName = "MyChannel01";

                        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT);

                        notificationManager.createNotificationChannel(channel);
                        builder = new NotificationCompat.Builder(DisabledActivity.this, channelID);
                    } else {
                        builder = new NotificationCompat.Builder(DisabledActivity.this, null);
                    }

                    builder.setContentTitle("호출 등록");
                    builder.setContentText("해당 위치에서 사회복지사님을 호출하였어요. 최대 10(분)이 소요됩니다.");

                    Notification notification = builder.build();
                    notificationManager.notify(1, notification);
                    notificationManager.cancel(1);

                    startMainActivity();
            }
        }

        private void startMainActivity() {
            Intent intent = new Intent(DisabledActivity. this, NaverMapActivity.class);
            startActivity(intent);
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

    // 1. the join Meeting function
    private void joinMeeting(Context context, String meetingNumber, String password) {

        MeetingService meetingService = ZoomSDK.getInstance().getMeetingService();
        JoinMeetingOptions options = new JoinMeetingOptions();
        JoinMeetingParams params = new JoinMeetingParams();
        params.displayName = "";
        params.meetingNo = meetingNumber;
        params.password = password;
        meetingService.joinMeetingWithParams(context, params, options);
    }
    // 2-1. the login function
    private void login(String username, String password) {
        int result = ZoomSDK.getInstance().loginWithZoom(username, password);
        if (result == ZoomApiError.ZOOM_API_ERROR_SUCCESS) {

            // 2-2. After request is executed, listen for the authentication result prior to starting a meeting
            ZoomSDK.getInstance().addAuthenticationListener(authLsitener);
        }
    }

    // 2-3. the start Meeting function
    private void startMeeting(Context context) {
        ZoomSDK sdk = ZoomSDK.getInstance();
        if(sdk.isLoggedIn()) {
            MeetingService meetingService = sdk.getMeetingService();
            StartMeetingOptions options = new StartMeetingOptions();
            meetingService.startInstantMeeting(context, options);
        }
    }

    // create a dialog to join meeting
    private void createJoinMeetingDialog() {
        new
                AlertDialog.Builder(this).setView(R.layout.activity_join_meeting_dialog)
                .setPositiveButton("JOIN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        AlertDialog dialog = (AlertDialog) dialogInterface;
                        TextInputEditText numberInput = dialog.findViewById(R.id.meeting_no_input);
                        TextInputEditText passwordInput = dialog.findViewById(R.id.password_input);
                        if (numberInput != null && numberInput.getText() != null && passwordInput != null && passwordInput.getText() != null) {
                            String meetingNumber = numberInput.getText().toString();
                            String password = passwordInput.getText().toString();
                            if (meetingNumber.trim().length() > 0 && password.trim().length() > 0) {
                                joinMeeting(DisabledActivity.this, meetingNumber, password);
                            }
                        }
                    }
                }).show();
    }

    // create a  dialog to login zoom
    private void createLoginDialog() {
        new
                AlertDialog.Builder(this).setView(R.layout.login_dialog)
                .setPositiveButton("LOGIN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        AlertDialog dialog = (AlertDialog) dialogInterface;
                        TextInputEditText emailInput = dialog.findViewById(R.id.email_input);
                        TextInputEditText passwordInput = dialog.findViewById(R.id.pw_input);
                        if (emailInput != null && emailInput.getText() != null && passwordInput != null && passwordInput.getText() != null) {
                            String email = emailInput.getText().toString();
                            String password = passwordInput.getText().toString();
                            if(email.trim().length() > 0 && password.trim().length() > 0) {
                                login(email, password);
                            }
                        }
                    }
                }).show();
    }

    // initViews method to handle onClick events for the Join Meeting and Login & Start Meeting buttons
    private void initViews() {

        /*
        findViewById(R.id.join_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                createJoinMeetingDialog();
            }
        });

        */

        findViewById(R.id.Videocall).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(ZoomSDK.getInstance().isLoggedIn()) {
                    startMeeting(DisabledActivity.this);
                } else {
                    createLoginDialog();
                }
            }
        });
    }
}

