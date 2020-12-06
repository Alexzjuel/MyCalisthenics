package com.e.mycalisthenics.WeeklyWorkoutSchedule;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataHelper {

    // The loadDays function pulls all the data from the json file
    public static ArrayList<Days> loadDays(Context context) {
        ArrayList<Days> days = new ArrayList<>();
        String json = "";

        try {
            InputStream is = context.getAssets().open("WeeklyCalisthenicsSchedule.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("WeeklyCalisthenicsSchedule");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Days day = new Days();
                day.setTitle(jsonObject.getString("title"));
                day.setCalisthenics(jsonObject.getString("calisthenics"));

                days.add(day);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return days;


    }
}
