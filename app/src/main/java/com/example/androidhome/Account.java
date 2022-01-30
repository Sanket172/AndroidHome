package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Account extends AppCompatActivity {


    TextView tv_name;
    TextView tv_email;
    TextView tv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        SharedPreferences sharedPreferences=getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);

        String email =sharedPreferences.getString("email","Default");
        String name =sharedPreferences.getString("username","Default");
        String address =sharedPreferences.getString("address","Default");

        tv_name=findViewById(R.id.Name);
        tv_email=findViewById(R.id.Phone);
        tv_address=findViewById(R.id.Address);

        dummy();
        tv_name.setText(name);
        tv_email.setText(email);
        tv_address.setText(address);
    }

    public void dummy(){

    }
}