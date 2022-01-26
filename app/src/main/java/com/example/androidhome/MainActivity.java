package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.signin).setOnClickListener(view -> {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.signup).setOnClickListener(view ->{
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
        });

        findViewById(R.id.skip).setOnClickListener(view ->{
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        });


    }


}