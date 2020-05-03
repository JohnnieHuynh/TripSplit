package com.example.tripsplit.Model.ItemModel;

/**
 * A model for each item in the adapter.
 * "Trip List Activity" will hold a list of these items
 * and each item will hold these fields.
 */

public class ItemModel {

    //Fields in the item
    private int tripID;
    private String tripName;
    private String tripDescription; //Optional
    private String userTotal;
    private String user;

    //Constructor
    public ItemModel (int tripID, String tripName, String tripDescription, String userTotal, String user) {
        this.tripID = tripID;
        this.tripName = tripName;
        this.tripDescription = tripDescription;
        this.userTotal = userTotal;
        this.user = user;
    }

    //Setters
    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public void setUserTotal(String userTotal) {this.userTotal = userTotal;}

    public void setUser(String user) {
        this.user = user;
    }

    //Getters
    public int getTripID() {
        return tripID;
    }

    public String getTripName() {
        return tripName;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public String getUserTotal() {return userTotal;}

    public String getUser() {
        return user;
    }
}
