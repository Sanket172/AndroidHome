package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ProfileFragment profileFragment = new ProfileFragment();
        HomeFragment homeFragment = new HomeFragment();
        CartFragment cartFragment = new CartFragment();
        setCurrentFragment(homeFragment);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_view);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            SharedPreferences sharedpreferences = getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);
            String j = sharedpreferences.getString("loginchecker", "0");

            int id = item.getItemId();
            boolean userLoggedIn=true;
            switch (id) {
                case R.id.home:
                    setCurrentFragment(homeFragment);
                    break;
//
                case R.id.cart:
                    if(j.equals("3"))
                    {
                        setCurrentFragment(cartFragment);
                    }
                    else {
                        Intent i = new Intent(DashboardActivity.this, SignupOrLogin.class);
                        startActivity(i);
                    }
                    break;

                default:
                    if(j.equals("3"))
                    {
                        setCurrentFragment(profileFragment);
                    }
                    else {
                        Intent i = new Intent(DashboardActivity.this, SignupOrLogin.class);
                        startActivity(i);
                    }
                    break;
            }
            return true;
        });

//        findViewById(R.id.more_category).setOnClickListener(view -> {
//            Intent intent = new Intent(this, ProductListByCategoryActivity.class);
//            startActivity(intent);
//        });
    }

    private void setCurrentFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }

}