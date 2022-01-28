package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class SureLogout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure_logout);


        Button btYes=findViewById(R.id.btYes);
        Button btNo=findViewById(R.id.btNo);
        btYes.setOnClickListener(view -> {
            SharedPreferences sharedPreferences=getSharedPreferences("com.example.inkedpages", Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().commit();

            Intent i=new Intent(SureLogout.this,MainActivity.class);
            startActivity(i);

        });

        btNo.setOnClickListener(view -> {
            Intent i=new Intent(SureLogout.this,DashboardActivity.class);
            startActivity(i);
        });

    }
}