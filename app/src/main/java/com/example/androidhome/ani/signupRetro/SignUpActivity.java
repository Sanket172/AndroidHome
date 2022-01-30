package com.example.androidhome.ani.signupRetro;

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
import com.example.androidhome.SplashActivity;
import com.example.androidhome.ani.RetrofitInterfaces.SignupInterface;
import com.example.androidhome.ani.builder.BuilderSignup;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {


    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;

    private EditText name, email, password, cpassword, address;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        name = findViewById(R.id.reg_name);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        cpassword = findViewById(R.id.reg_rpassword);
        address = findViewById(R.id.reg_address);

        signup = findViewById(R.id.reg_button);

        signup.setOnClickListener(view -> {

            if (email.getText().toString().isEmpty() && password.getText().toString().isEmpty() && name.getText().toString().isEmpty() &&
                    cpassword.getText().toString().isEmpty() && address.getText().toString().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!password.getText().toString().equals(cpassword.getText().toString())){
                Toast.makeText(SignUpActivity.this, "Enter same password", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d("do",email.getText().toString());
            signupAPI(name.getText().toString(), email.getText().toString(), password.getText().toString(), address.getText().toString());

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

    public void signupAPI(String name, String email, String password, String address) {


        SharedPreferences sharedPreferences=getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("email",email);
        editor.putString("username",name);
        editor.putString("address",address);

        editor.apply();

        Retrofit retrofit = BuilderSignup.getInstance();
        SignupEntity signupEntity = new SignupEntity(name, email, password, address);
        SignupInterface signupInterface = retrofit.create(SignupInterface.class);

        Call<Respentity> signupEntityCall = signupInterface.postLog(signupEntity);
        signupEntityCall.enqueue(new Callback<Respentity>() {
            @Override
            public void onResponse(Call<Respentity> call, Response<Respentity> response) {
                if(response.body()==null){
                    Toast.makeText(SignUpActivity.this, "User mail is already registered", Toast.LENGTH_SHORT).show();
                }


                Toast.makeText(SignUpActivity.this, "Signin Successful", Toast.LENGTH_SHORT).show();
//                Toast.makeText(SignUp.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, DashboardActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Respentity> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "User mail is already registered", Toast.LENGTH_SHORT).show();
//                Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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

            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

                SharedPreferences sharedPreferences1=getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor=sharedPreferences1.edit();
                editor.putString("email", personEmail);
                editor.apply();
                //-------------------------------------------------------------------------------------

                Retrofit retrofit = BuilderSignup.getInstance();
                SignupEntity signupEntity = new SignupEntity(personName, personEmail, "", "Home Address");

                SignupInterface signupInterface = retrofit.create(SignupInterface.class);

                Call<Respentity> signupEntityCall = signupInterface.postLogGoogle(signupEntity);
                signupEntityCall.enqueue(new Callback<Respentity>() {
                    @Override
                    public void onResponse(Call<Respentity> call, Response<Respentity> response) {
                        if(response.body()==null){
                            Toast.makeText(SignUpActivity.this, "User mail is already registered", Toast.LENGTH_SHORT).show();
                        }

                        Toast.makeText(SignUpActivity.this, "Signin Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, SplashActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Respentity> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this, "User mail is already registered", Toast.LENGTH_SHORT).show();
//                Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                //------------------------------------------------------------------------------------------------------

                Log.d("ABCDEFGH", "User Email :- "+personEmail);
                Toast.makeText(this, "User ID :- "+personEmail, Toast.LENGTH_SHORT ).show();
                startActivity(new Intent(SignUpActivity.this, SplashActivity.class));

            }


            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("SignIn Failed", "signInResult:failed code=" + e.getStatusCode());
        }
    }
}
