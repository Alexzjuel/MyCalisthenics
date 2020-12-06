package com.e.mycalisthenics.WeeklyWorkoutSchedule;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.e.mycalisthenics.MainScreen.ExerciseActivity;
import com.e.mycalisthenics.ExerciseLibrary.PlayBtnActivity;
import com.e.mycalisthenics.MainScreen.MainActivity;
import com.e.mycalisthenics.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

//Activity for displaying the days in the ListView

public class DaysActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "DaysActivity";

    private ListView dayLv;
    private ArrayList<Days> workoutList;
    private ArrayList<String> titleList;
    private Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);

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
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
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

        Log.d(TAG, "onCreate: started");

        dayLv = findViewById(R.id.dayLv);

        workoutList = DataHelper.loadDays(this);
        titleList = new ArrayList<>();
        for ( int i = 0; i < workoutList.size(); i++) {
            String str = workoutList.get(i).getTitle();
            titleList.add(str);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, titleList);

        dayLv.setAdapter((ListAdapter) adapter);

        dayLv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, daysDetailActivity.class);
        String title = workoutList.get(position).getTitle();
        String calisthenics = workoutList.get(position).getCalisthenics();

        intent.putExtra("EXTRA_TITLE", title);
        intent.putExtra("EXTRA_CALISTHENICS", calisthenics);

        startActivity(intent);
    }
/*
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if (getIntent()has.E)
    }

 */
}
