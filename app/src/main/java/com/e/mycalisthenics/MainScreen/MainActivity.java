package com.e.mycalisthenics.MainScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.e.mycalisthenics.ExerciseLibrary.PlayBtnActivity;
import com.e.mycalisthenics.ROOMCreateNotes.NoteActivity;
import com.e.mycalisthenics.WeeklyWorkoutSchedule.DaysActivity;
import com.e.mycalisthenics.LoginScreen.LoginActivity;
import com.e.mycalisthenics.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {


    private Button weekSchedule;
    private Button createOwn;
    private Button exerciseLibrary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Nav bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.exerciseLibraryBtn:
                        startActivity(new Intent(getApplicationContext()
                        , ExerciseActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.inspired:
                        startActivity(new Intent(getApplicationContext()
                                , PlayBtnActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


        weekSchedule = (Button) findViewById(R.id.weekSch);
        weekSchedule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

        createOwn = (Button) findViewById(R.id.createNote);
        createOwn.setOnClickListener(new View.OnClickListener() {

            //Create my own workout schedule
            @Override
            public void onClick(View v) {
                openCreateOwnActivity();
            }
        });

        exerciseLibrary = (Button) findViewById(R.id.exerciseLibraryBtn);
        exerciseLibrary.setOnClickListener(new View.OnClickListener() {

            //watch a video on youtube
            @Override
            public void onClick(View v) {
                openExerciseLibraryActivity();
            }
        });

    }

    public void openDetailActivity() {
        Intent intent = new Intent(this, DaysActivity.class);
        startActivity(intent);
    }

    public void openCreateOwnActivity() {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    public void openExerciseLibraryActivity() {
        Intent intent = new Intent(this, PlayBtnActivity.class);
        startActivity(intent);
    }

//Logout button for the user to use, redirects them to the login screen
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }


}
