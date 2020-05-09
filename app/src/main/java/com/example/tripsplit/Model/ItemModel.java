package com.example.tripsplit.Model;

/**
 * A model for each item in the adapter.
 * "Trip List Activity" will hold a list of these items
 * and each item will hold these fields.
 */

public class ItemModel {

    //Fields in the item
    private String tripName;
    private String tripDescription;
    private String userTotal;
    private String tripCode;

    //Constructor
    public ItemModel (String tripName, String tripDescription, String userTotal, String tripCode) {
        this.tripName = tripName;
        this.tripDescription = tripDescription;
        this.userTotal = userTotal;
        this.tripCode = tripCode;
    }

    //Setters

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public void setUserTotal(String userTotal) {this.userTotal = userTotal;}

    public void setTripCode(String tripCode) {
        this.tripCode = tripCode;
    }

    //Getters

    public String getTripName() {
        return tripName;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public String getUserTotal() {return userTotal;}

    public String getTripCode() {
        return tripCode;
    }
}
