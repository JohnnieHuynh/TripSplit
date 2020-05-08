package com.example.tripsplit.Model;

public class PersonModel {
    private int personID;
    private String firstname;
    private String lastname;

    public PersonModel(String firstname, String lastname) {
        setPersonID(this.personID);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    //Setters
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //Getters
    public int getPersonID() {
        return personID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
