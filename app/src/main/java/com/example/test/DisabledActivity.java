package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DisabledActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disabled);

        findViewById(R.id.Videocall).setOnClickListener(onClickListener);
        findViewById(R.id.connection).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Videocall:
                    Log.e("화상통화","화상통화");
                    break;
                case R.id.connection:
                    Log.e("호출","호출");
                    startMainActivity();
            }
        }

        private void startMainActivity() {
            Intent intent = new Intent(DisabledActivity. this, NaverMapActivity.class);
            startActivity(intent);
        }

    };

}

