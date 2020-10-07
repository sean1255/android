package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import us.zoom.sdk.MeetingError;
import us.zoom.sdk.MeetingService;
import us.zoom.sdk.MeetingServiceListener;
import us.zoom.sdk.MeetingStatus;
import us.zoom.sdk.ZoomSDK;
import us.zoom.sdk.ZoomAuthenticationError;
import us.zoom.sdk.ZoomSDKAuthenticationListener;
import android.os.Bundle;

public class VideoChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_chat);
    }

    private void initSdk() {

    }
}