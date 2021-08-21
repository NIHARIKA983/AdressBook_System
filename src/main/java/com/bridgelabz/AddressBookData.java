package com.bridgelabz;

import java.util.Objects;

public class AddressBookData {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    // private long phone;
    private String email;

    public AddressBookData(String firstName, String lastName, String address, String city, String state, int zip,  String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        // this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBookData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +

                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookData that = (AddressBookData) o;
        return zip == that.zip &&   Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(email, that.email);
    }
}