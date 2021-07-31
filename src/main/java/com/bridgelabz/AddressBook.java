package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Person>contacts;

    //Static variables
    static String firstName,lastName,address,city,state,zipCode,phoneNumber,email;

    public AddressBook() {
        contacts=new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "AddressBook [contacts=" + contacts + "]\n";
    }

    public void addPerson() {
        @SuppressWarnings("resource")
        Scanner userInput=new Scanner(System.in);
        System.out.println("\nEnter First name :- ");
        firstName=userInput.nextLine();
        validateFirstName();
        System.out.println("Enter Last name :- ");
        lastName=userInput.nextLine();
        validateLastName();
        System.out.println("Enter Address :- ");
        address=userInput.nextLine();
        validateAddress();
        System.out.println("Enter City :- ");
        city=userInput.nextLine();
        validateCity();
        System.out.println("Enter State :- ");
        state=userInput.nextLine();
        validateState();
        System.out.println("Enter Zip code :- ");
        zipCode=userInput.nextLine();
        validateZipCode();
        System.out.println("Enter Contact number :- ");
        phoneNumber=userInput.nextLine();
        validatePhoneNumber();
        System.out.println("Enter Email Id:-");
        email=userInput.nextLine();
        validateEmail();
        Person person=new Person(firstName,lastName,address,city,state,zipCode,phoneNumber,email);
        if(checkForDuplicateEntry(person)) {
            System.out.println("This Contact Is Already Added.");
        }
        else {
            contacts.add(person);
            System.out.println("Added:- "+person);
        }
    }

    public static void validateFirstName() {
        Scanner userInput=new Scanner(System.in);
        while(!firstName.matches("[A-Za-z]{3}[A-Za-z]*")) {
            System.out.println("Minimum 3 characters required !\nEnter First name :- ");
            firstName=userInput.nextLine();
        }
    }
    public static void validateLastName(){
        Scanner userInput=new Scanner(System.in);
        while(!lastName.matches("[A-Za-z]{3}[A-Za-z]*")) {
            System.out.println("Minimum 3 characters required !\nEnter Last name :- ");
            lastName=userInput.nextLine();
        }
    }
    public static void validateAddress() {
        Scanner userInput=new Scanner(System.in);
        while(!address.matches("^[a-zA-Z\\d\\s\\-\\_]*$")) {
            System.out.println("INVALID! \nEnter Address :- ");
            address=userInput.nextLine();
        }
    }

    public static void validateCity() {
        Scanner userInput=new Scanner(System.in);
        while(!city.matches("^[a-zA-Z]*$")) {
            System.out.println("INVALID!\nEnter City :- ");
            city=userInput.nextLine();
        }
    }

    public static void validatePhoneNumber() {
        Scanner userInput=new Scanner(System.in);
        while(!phoneNumber.matches("^[6-9]{1}\\d{9}")) {
            System.out.println("INVALID !\nEnter Contact number :- ");
            phoneNumber=userInput.nextLine();
        }
    }
    public static void validateState() {
        Scanner userInput=new Scanner(System.in);
        while(!state.matches("^[a-zA-Z\\s]*$")) {
            System.out.println("INVALID!\nEnter State :- ");
            state=userInput.nextLine();
        }
    }
    public static void validateZipCode() {
        Scanner userInput=new Scanner(System.in);
        while(!zipCode.matches("\\d{6}")) {
            System.out.println("INVALID!!\nEnter Zip code :- ");
            zipCode=userInput.nextLine();
        }
    }
    public static void validateEmail() {
        Scanner userInput=new Scanner(System.in);
        String EMAIL_REGEX ="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        while(!email.matches(EMAIL_REGEX)) {
            System.out.println("INVALID EMAIL ID !\n Enter Valid Email Id:-");
            email=userInput.nextLine();
        }
    }

    public boolean checkForDuplicateEntry(Person person) {
        int flag=1;
        if(contacts.size()==0)
            return false;
        for(int i=0;i<contacts.size();i++) {
            Person personInList=(contacts.get(i));
            if(person.equals(personInList)) {
                flag=0;
                break;
            }
        }
        if(flag==0)
            return true;
        else
            return false;

    }

    public void editPerson() {
        Scanner userInput=new Scanner(System.in);
        System.out.println("Enter name of the person to edit :");
        String name=userInput.nextLine();
        int flag=0;
        for(int i=0;i<contacts.size();i++) {
            Person person=contacts.get(i);
            if(name.equals(person.firstName)) {
                System.out.println("Enter address :- ");
                address=userInput.nextLine();
                validateAddress();
                person.setAddress(address);
                System.out.println("Enter city :- ");
                city=userInput.nextLine();
                validateCity();
                person.setCity(city);
                System.out.println("Enter state :- ");
                state=userInput.nextLine();
                validateState();
                person.setState(state);
                System.out.println("Enter zip code :- ");
                zipCode=userInput.nextLine();
                validateZipCode();
                person.setZipCode(zipCode);
                System.out.println("Enter contact number :- ");
                phoneNumber=userInput.nextLine();
                validatePhoneNumber();
                person.setPhoneNumber(phoneNumber);
                System.out.println("Enter Email Id:-");
                email=userInput.nextLine();
                validateEmail();
                person.setEmail(email);
                flag=1;
                System.out.println("Edited:- "+person);
            }
        }
        if(flag==0) {
            System.out.println("This name does not exists!");
        }
    }

    public void deletePerson() {
        Scanner userInput=new Scanner(System.in);
        System.out.println("Enter name of person to be deleted?");
        String name=userInput.nextLine();
        int flag=0;
        for(int i=0;i<contacts.size();i++) {
            Person person=contacts.get(i);
            if(name.equals(person.firstName)) {
                System.out.println("Deleted:- "+person);
                contacts.remove(i);
                flag=1;
            }
        }
        if(flag==0) {
            System.out.println("This name does not exists!");
        }
    }

    public void display() {
        System.out.println("\n*****************All Contacts************************");
        if(contacts.size()==0) {
            System.out.println("NO CONTACTS ADDED !");
            return;
        }
        for(int i=0;i<contacts.size();i++) {
            System.out.println(contacts.get(i));
        }
    }
}