package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.LogoutButton) {
                FirebaseAuth.getInstance().signOut();
                startMainActivity(SignUpActivity.class);
            }
        }
    };

    private void startMainActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

}
