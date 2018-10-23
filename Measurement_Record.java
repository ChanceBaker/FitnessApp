package com.fitapp.sdp.fitnessapp;

public class Measurement_Record {

    private double neckWid, lBicep, rBicep, chestWid,lForearm,rForearm,waistWid,lThigh,rThigh,lCalf,rCalf;
    private String date;

    public Measurement_Record(double neckWid, double lBicep, double rBicep, double chestWid, double lForearm, double rForearm, double waistWid, double lThigh, double rThigh, double lCalf, double rCalf, String date) {
        this.neckWid = neckWid;
        this.lBicep = lBicep;
        this.rBicep = rBicep;
        this.chestWid = chestWid;
        this.lForearm = lForearm;
        this.rForearm = rForearm;
        this.waistWid = waistWid;
        this.lThigh = lThigh;
        this.rThigh = rThigh;
        this.lCalf = lCalf;
        this.rCalf = rCalf;
        this.date = date;

    }

    public double getNeckWid() {
        return neckWid;
    }

    public void setNeckWid(double neckWid) {
        this.neckWid = neckWid;
    }

    public double getlBicep() {
        return lBicep;
    }

    public void setlBicep(double lBicep) {
        this.lBicep = lBicep;
    }

    public double getrBicep() {
        return rBicep;
    }

    public void setrBicep(double rBicep) {
        this.rBicep = rBicep;
    }

    public double getChestWid() {
        return chestWid;
    }

    public void setChestWid(double chestWid) {
        this.chestWid = chestWid;
    }

    public double getlForearm() {
        return lForearm;
    }

    public void setlForearm(double lForearm) {
        this.lForearm = lForearm;
    }

    public double getrForearm() {
        return rForearm;
    }

    public void setrForearm(double rForearm) {
        this.rForearm = rForearm;
    }

    public double getWaistWid() {
        return waistWid;
    }

    public void setWaistWid(double waistWid) {
        this.waistWid = waistWid;
    }

    public double getlThigh() {
        return lThigh;
    }

    public void setlThigh(double lThigh) {
        this.lThigh = lThigh;
    }

    public double getrThigh() {
        return rThigh;
    }

    public void setrThigh(double rThigh) {
        this.rThigh = rThigh;
    }

    public double getlCalf() {
        return lCalf;
    }

    public void setlCalf(double lCalf) {
        this.lCalf = lCalf;
    }

    public double getrCalf() {
        return rCalf;
    }

    public void setrCalf(double rCalf) {
        this.rCalf = rCalf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "Date: %s\nNeck: %1.2fcm\nLeft Bicep: %1.2fcm\nRight Bicep: %1.2fcm\nChest: %1.2fcm\nLeft Forearm: %1.2fcm\n" +
                "Right Forearm: %1.2fcm\nWaist: %1.2fcm\nLeft Thigh: %1.2fcm\nRight Thigh: %1.2fcm\nLeft Calf: %1.2fcm\nRight Calf: %1.2fcm\n\n",
                date, neckWid, lBicep, rBicep, chestWid, lForearm, rForearm, waistWid, lThigh, rThigh, lCalf, rCalf);
    }
}
