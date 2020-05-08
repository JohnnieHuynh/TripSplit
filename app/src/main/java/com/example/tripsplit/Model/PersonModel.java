package com.example.tripsplit.Model;

public class PersonModel {
    private String firstname;
    private String lastname;

    public PersonModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    //Setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
