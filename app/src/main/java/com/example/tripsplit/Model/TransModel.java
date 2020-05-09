package com.example.tripsplit.Model;

public class TransModel {
    private String date;
    private String amount;
    private String description;
    private String personLink;
    private String eventCode;

    public TransModel(String date, String amount, String description, String personLink, String eventCode) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.personLink = personLink;
        this.eventCode = eventCode;
    }

    //Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersonLink() {
        return personLink;
    }

    public void setPersonLink(String personLink) {
        this.personLink = personLink;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}
