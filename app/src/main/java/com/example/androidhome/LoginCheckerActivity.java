package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class LoginCheckerActivity extends AppCompatActivity {

   // private static int SPLASH_SCREEN_TIME_OUT=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_checker);


//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        //setContentView(R.layout.activity_splash);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//
//                SharedPreferences sharedPreferences = getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("loginchecker", "0");
//                editor.apply();
//
//                Intent i=new Intent(LoginCheckerActivity.this,
//                        SignInActivity.class);
//                startActivity(i);
//                finish();
//            }
//        }, SPLASH_SCREEN_TIME_OUT);

    }
}