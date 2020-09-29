package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Division extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private Object FirebaseUser;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.division);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.disabled).setOnClickListener(onClickListener);
        findViewById(R.id.nondisabled).setOnClickListener(onClickListener);
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser = mAuth.getCurrentUser();
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    View.OnClickListener onClickListener = new View.OnClickListener () {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.disabled:
                    Log.e("장애인", "장애인");
                    startMainActivity(SignUp1Activity.class);
                    break;
                case R.id.nondisabled:
                    Log.e("비장애인", "비장애인");
                    startMainActivity(SignUp1Activity.class);
                    break;
            }
        }

        private void startMainActivity(Class c) {
            Intent intent = new Intent(Division. this,SignUp1Activity. class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Division.this.startActivity(intent);
        }
    };

}

