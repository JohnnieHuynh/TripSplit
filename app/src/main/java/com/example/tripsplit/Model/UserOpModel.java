package com.example.tripsplit.Model;

public class UserOpModel {
    private String sender;
    private String operationMSG;
    private String recipent;

    public UserOpModel(String sender, String operationMSG, String recipent) {
        this.sender = sender;
        this.operationMSG = operationMSG;
        this.recipent = recipent;
    }

    //Setters
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

