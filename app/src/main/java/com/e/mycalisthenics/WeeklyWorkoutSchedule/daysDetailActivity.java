package com.e.mycalisthenics.WeeklyWorkoutSchedule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.e.mycalisthenics.R;

public class daysDetailActivity extends AppCompatActivity {

    private TextView title;
    private  TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_detail);



        title = findViewById(R.id.days_title_tv);
        description = findViewById(R.id.days_description_tv);

        Bundle extra = getIntent() .getExtras();
        if(extra != null) {
            String tit = extra.getString("EXTRA_TITLE");
            String calisthenics = extra.getString("EXTRA_CALISTHENICS");
            title.setText(tit);
            description.setText(calisthenics);

        }




    }

}