package com.fitapp.sdp.fitnessapp;

public class Workout_Complete {

    private String date;
    private String workoutDetails;

    public Workout_Complete(String date, String workoutDetails)
    {
        this.date = date;
        this.workoutDetails = workoutDetails;
    }

    public String getWorkoutDetails() {
        return workoutDetails;
    }

    public void setWorkoutDetails(String workoutDetails) {
        this.workoutDetails = workoutDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Date: %s\n%s",date,workoutDetails);
    }
}
