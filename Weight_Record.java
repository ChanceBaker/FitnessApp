package com.fitapp.sdp.fitnessapp;

public class Weight_Record {

    private double weight;
    private String date;

    public Weight_Record(double weight, String date)
    {
        this.weight = weight;
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Date: %s\nWeight: %1.2f kgs\n\n", this.date, this.weight);
    }
}
