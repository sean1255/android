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
import android.os.Bundle;

import static java.util.Calendar.getInstance;

public class VideoChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_chat);
    }

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