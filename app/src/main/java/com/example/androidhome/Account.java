package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhome.ani.RetrofitInterfaces.SignupInterface;
import com.example.androidhome.ani.accuntRetro.AccountData;
import com.example.androidhome.ani.builder.BuilderSignup;
import com.example.androidhome.ani.signupRetro.Respentity;
import com.example.androidhome.ani.signupRetro.SignUpActivity;
import com.example.androidhome.ani.signupRetro.SignupEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Account extends AppCompatActivity {


    TextView tv_name;
    TextView tv_email;
    TextView tv_address;

    String name;
    String email1;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        SharedPreferences sharedPreferences=getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);
        String email =sharedPreferences.getString("email","Default");

        googleDataAPI(email);

        tv_name = findViewById(R.id.Name);
        tv_email = findViewById(R.id.Phone);
        tv_address = findViewById(R.id.Address);


    }

    void googleDataAPI(String email)
    {
        Retrofit retrofit = BuilderSignup.getInstance();
        SignupInterface signupInterface = retrofit.create(SignupInterface.class);

        Call<AccountData> signupEntityCall = signupInterface.postLogGetAcc(email);
        signupEntityCall.enqueue(new Callback<AccountData>() {
            @Override
            public void onResponse(Call<AccountData> call, Response<AccountData> response) {
                if(response.body()!=null){
                    Toast.makeText(Account.this, response.body().getName(), Toast.LENGTH_SHORT).show();
                    name = response.body().getName();
                    email1 = response.body().getEmail();
                    address =response.body().getAddress();
                    tv_name.setText(name);
                    tv_email.setText(email1);
                    tv_address.setText(address);
                }
            }

            @Override
            public void onFailure(Call<AccountData> call, Throwable t) {
                Toast.makeText(Account.this, "Account Fetch Failed", Toast.LENGTH_SHORT).show();
//                Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void dummy(){

    }
}