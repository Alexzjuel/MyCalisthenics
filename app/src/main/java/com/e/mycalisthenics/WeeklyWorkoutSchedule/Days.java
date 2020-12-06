package com.e.mycalisthenics.WeeklyWorkoutSchedule;

public class Days {

    private String title;
    private String calisthenics;

    public Days(String title, String calisthenics) {
        this.title = title;
        this.calisthenics = calisthenics;
    }

    public Days() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCalisthenics() {
        return calisthenics;
    }

    public void setCalisthenics(String calisthenics) {
        this.calisthenics = calisthenics;
    }
}
