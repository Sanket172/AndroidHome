package com.example.androidhome.ani.loginRetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidhome.DashboardActivity;
import com.example.androidhome.R;
import com.example.androidhome.ani.signupRetro.SignUpActivity;
import com.example.androidhome.SplashActivity;
import com.example.androidhome.ani.builder.BuilderSignup;
import com.example.androidhome.ani.signupRetro.Respentity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import com.example.androidhome.ani.RetrofitInterfaces.LoginInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignInActivity extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;

    private EditText email,pwd;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email=findViewById(R.id.username);
        pwd=findViewById(R.id.password);
        signin=findViewById(R.id.login);

        signin.setOnClickListener(view -> {
            if(email.getText().toString().isEmpty() && pwd.getText().toString().isEmpty()){
                Toast.makeText(SignInActivity.this,"Please enter valid details",Toast.LENGTH_SHORT).show();
                return;
            }
            loginAPI(email.getText().toString(),pwd.getText().toString());

        });

        findViewById(R.id.logout).setOnClickListener(view -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                // API for Call Recommendation Data

                signIn();
            }


        });

    }

    public void loginAPI(String email,String pwd){

        SharedPreferences sharedPreferences=getSharedPreferences("com.example.inkedpages", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("email",email);


        Retrofit retrofit= BuilderSignup.getInstance();

        LoginEntity loginEntity = new LoginEntity(email,pwd);

        LoginInterface loginInterface = retrofit.create(LoginInterface.class);

        Call<Respentity> loginEntityCall= loginInterface.postLog(loginEntity);

        loginEntityCall.enqueue(new Callback<Respentity>() {
            @Override
            public void onResponse(Call<Respentity> call, Response<Respentity> response) {
                if(response.body()==null){
                    Toast.makeText(SignInActivity.this,"Wrong username or password",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<Respentity> call, Throwable t) {
                Toast.makeText(SignInActivity.this,"Wrong username or password",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void signIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {

            SharedPreferences sharedPreferences = getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);

            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);


            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("loginchecker", "3");
                editor.apply();
                editor.commit();

                Log.d("ABCDEFGH", "User Email :- "+personEmail);
                Toast.makeText(this, "User ID :- "+personEmail, Toast.LENGTH_SHORT ).show();
                startActivity(new Intent(SignInActivity.this, SplashActivity.class));

            }




            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("SignIn Failed", "signInResult:failed code=" + e.getStatusCode());
        }
    }


}