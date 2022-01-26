package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidhome.ani.loginRetro.SignInActivity;
import com.example.androidhome.ani.signupRetro.SignUpActivity;

public class SignupOrLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_or_login);

        findViewById(R.id.signin).setOnClickListener(view -> {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.signup).setOnClickListener(view ->{
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });

    }
}