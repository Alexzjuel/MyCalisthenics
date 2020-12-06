package com.e.mycalisthenics.ExerciseLibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.e.mycalisthenics.MainScreen.ExerciseActivity;
import com.e.mycalisthenics.MainScreen.MainActivity;
import com.e.mycalisthenics.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class PlayBtnActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playbtn);


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
                        return true;
                }
                return false;
            }
        });



        Button btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        Button btnVideoPlayList = (Button) findViewById(R.id.btnVideoPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnVideoPlayList.setOnClickListener(this);
        /*
        View.OnClickListener myListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        };
        btnPlayVideo.setOnClickListener(myListener);
        btnVideoPlayList.setOnClickListener(myListener);

        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

         */

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, ExerciseLibraryActivity.GOOGLE_API_KEY, ExerciseLibraryActivity.YOUTUBE_VIDEO_ID);
                break;

            case R.id.btnVideoPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, ExerciseLibraryActivity.GOOGLE_API_KEY, ExerciseLibraryActivity.YOUTUBE_PLAYLIST);
                break; default:
        }

        if(intent != null) {
            startActivity(intent);
        }
    }
}
