package com.e.mycalisthenics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private Button monday;
    private Button tuesday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monday = (Button) findViewById(R.id.monday);
        monday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

        tuesday = (Button) findViewById(R.id.tuesday);
        tuesday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

    }

    public void openDetailActivity() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

//Logout button for the user to use, redirects them to the login screen
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }


}
