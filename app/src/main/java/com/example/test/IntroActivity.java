package com.example.test;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_intro);
            setContentView(R.layout.activity_intro); //xml , java 소스 연결
            Handler handler = new Handler();
            handler.postDelayed(new Runnable(){
                @Override
                public void run() {
                    Intent intent = new Intent (getApplicationContext(), SignUpActivity.class);
                    startActivity(intent); //다음화면으로 넘어감
                    finish();
                }
            },1000); //3초 뒤에 Runner객체 실행하도록 함
         }

        @Override
        protected void onPause () {
            super.onPause();
            finish();
        }
    }
