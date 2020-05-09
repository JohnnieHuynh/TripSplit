package com.example.tripsplit.Model;

public class TransactionModel {
    private String Name;
    private String amount;
    private String date;
    private String description ;

    public TransactionModel(String name, String amount, String date, String description) {
        Name = name;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // setters and getters

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
