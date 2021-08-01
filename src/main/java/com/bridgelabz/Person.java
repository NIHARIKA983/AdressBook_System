package com.bridgelabz;

public class Person {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zipCode;
    String phoneNumber;
    String email;

    public Person(String firstName, String lastName, String address, String city, String state, String zipCode,
                  String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "[FirstName=" + firstName + ", LastName=" + lastName + ", Address=" + address + ", City=" + city
                + ", State=" + state + ", ZipCode=" + zipCode + ", PhoneNumber=" + phoneNumber + ", Email=" + email
                + "]";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        if(this==object) return true;
        if(object==null) return false;
        if (this.getClass() != object.getClass()) return false;
        Person that = (Person) object;
        if (!(this.firstName.equalsIgnoreCase(that.firstName))) return false;
        if (!(this.lastName.equalsIgnoreCase(that.lastName))) return false;
        if (!(this.address.equalsIgnoreCase(that.address)))   return false;
        if (!(this.city.equalsIgnoreCase(that.city)))   return false;
        if (!(this.state.equalsIgnoreCase(that.state)))   return false;
        if (!(this.zipCode.equalsIgnoreCase(that.zipCode)))  return false;
        if (!(this.phoneNumber.equalsIgnoreCase(that.phoneNumber))) return false;
        if (!(this.email.equalsIgnoreCase(that.email)))  return false;
        return true;
    }
}
