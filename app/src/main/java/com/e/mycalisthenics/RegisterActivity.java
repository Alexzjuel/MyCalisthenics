package com.e.mycalisthenics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText rFullName, rEmail, rPassword;
    FirebaseAuth fAuth;
    TextView rLoginBtn;
    Button rRegisterBtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rFullName = findViewById(R.id.fullName);
        rEmail = findViewById(R.id.email);
        rPassword = findViewById(R.id.password);

        fAuth = FirebaseAuth.getInstance();
        rLoginBtn = findViewById(R.id.createText);
        rRegisterBtn = findViewById(R.id.registerBtn);
        progressBar = findViewById(R.id.progressBar);


        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();

        }

        rRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = rEmail.getText().toString().trim();
                String password = rPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    rEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    rPassword.setError("Password is required");
                    return;
                }

                if(password.length() < 5) {
                    rPassword.setError("Password must be at least 5 characters long");
                    return;
                }

                //sets the progress bar to visible as the user goes through the process
                progressBar.setVisibility(View.VISIBLE);

                //Registers the user in fireBase

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(RegisterActivity.this, "An Error as occurred " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });



            }
        });

        rLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });



    }
}