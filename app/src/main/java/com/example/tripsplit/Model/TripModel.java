package com.example.tripsplit.Model;

public class TripModel {

    private String tripName;
    private String tripDesc;
    private String tripNum;

    public TripModel (String tripName, String tripDesc, String tripNum) {

        this.tripName = tripName;
        this.tripDesc = tripDesc;
        this.tripNum = tripNum;
    }

    //Setters

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setTripDesc(String tripDesc) {
        this.tripDesc = tripDesc;
    }

    public void setTripNum(String tripNum) {
        this.tripNum = tripNum;
    }

    //Getters

    public String getTripName() {
        return tripName;
    }

    public String getTripDesc() {
        return tripDesc;
    }

    public String getTripNum() {
        return tripNum;
    }
}
