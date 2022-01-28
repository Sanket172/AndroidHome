package com.example.androidhome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhome.Model.Category;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.concurrent.Executor;

public class ProfileFragment extends Fragment {




    GoogleSignInClient mGoogleSignInClient;
    DashboardActivity dashboardActivity;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_profile, container, false);
        return v;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.PAccount).setOnClickListener(view12 -> {

            Intent i=new Intent(getContext(), Account.class);
            startActivity(i);

        });

        view.findViewById(R.id.POrderHistory).setOnClickListener(view13 -> {

            Intent intent = new Intent(getContext(), OrderHistory.class);
            startActivity(intent);
        });



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);

        Button signout = view.findViewById(R.id.logout_fragment);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("AAAAAAAAAAAAAAA", "JHello   " + dashboardActivity.lc);

                signOut();
            }
        });

        GoogleSignInAccount acc = GoogleSignIn.getLastSignedInAccount(getContext());
        if(acc!=null)
        {
            String personName = acc.getDisplayName();
            Uri personPhoto = acc.getPhotoUrl();
            String personEmail = acc.getEmail();

        }

    }
    private void signOut()
    {
        mGoogleSignInClient.signOut().addOnCompleteListener((Executor) this, (OnCompleteListener<Void>) task -> {

            Toast.makeText(getContext(), "SignOut FROM this", Toast.LENGTH_SHORT).show();

            SharedPreferences sharedPreferences = dashboardActivity.getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("loginchecker", "0");
            editor.apply();
            editor.commit();

            Intent intent = new Intent(getContext(), LoginCheckerActivity.class);
            dashboardActivity.finish();


            startActivity(intent);

        });
    }


}