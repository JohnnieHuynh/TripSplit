package com.example.tripsplit.Model;

public class UserOpModel {
    private int userOpID;
    private String sender;
    private String operationMSG;
    private String recipent;

    public UserOpModel(String sender, String operationMSG, String recipent) {
        setUserOpID(this.userOpID);
        this.sender = sender;
        this.operationMSG = operationMSG;
        this.recipent = recipent;
    }

    //Setters
    public void setUserOpID(int userOpID) {
        this.userOpID = userOpID;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setOperationMSG(String operationMSG) {
        this.operationMSG = operationMSG;
    }

    public void setRecipent(String recipent) {
        this.recipent = recipent;
    }

    //Getters
    public int getUserOpID() {
        return userOpID;
    }

    public String getSender() {
        return sender;
    }

    public String getOperationMSG() {
        return operationMSG;
    }

    public String getRecipent() {
        return recipent;
    }
}

