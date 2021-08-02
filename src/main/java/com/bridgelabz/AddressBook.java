package com.bridgelabz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    ArrayList<Person>contacts;

    //Static variables
    static String firstName,lastName,address,city,state,zipCode,phoneNumber,email;
    //non-static variables
    HashMap<Person,String> personsInCity = new HashMap<Person,String>();
    HashMap<Person,String> personsInState = new HashMap<Person,String>();

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

    //method to add persons in an addressBook
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
            personsInCity.put(person,city);
            personsInState.put(person, state);
            System.out.println("Added:- "+person);
        }
    }

    //method to validate and enter proper first name
    public static void validateFirstName() {
        Scanner userInput=new Scanner(System.in);
        while(!firstName.matches("[A-Za-z]{3}[A-Za-z]*")) {
            System.out.println("Minimum 3 characters required !\nEnter First name :- ");
            firstName=userInput.nextLine();
        }
    }

    //method to validate and enter proper last name
    public static void validateLastName(){
        Scanner userInput=new Scanner(System.in);
        while(!lastName.matches("[A-Za-z]{3}[A-Za-z]*")) {
            System.out.println("Minimum 3 characters required !\nEnter Last name :- ");
            lastName=userInput.nextLine();
        }
    }

    //method to validate and enter proper address
    public static void validateAddress() {
        Scanner userInput=new Scanner(System.in);
        while(!address.matches("^[a-zA-Z\\d\\s\\-\\_]*$")) {
            System.out.println("INVALID! \nEnter Address :- ");
            address=userInput.nextLine();
        }
    }

    //method to validate and enter proper city name
    public static void validateCity() {
        Scanner userInput=new Scanner(System.in);
        while(!city.matches("^[a-zA-Z]*$")) {
            System.out.println("INVALID!\nEnter City :- ");
            city=userInput.nextLine();
        }
    }

    //method to validate and enter proper phone number
    public static void validatePhoneNumber() {
        Scanner userInput=new Scanner(System.in);
        while(!phoneNumber.matches("^[6-9]{1}\\d{9}")) {
            System.out.println("INVALID !\nEnter Contact number :- ");
            phoneNumber=userInput.nextLine();
        }
    }

    //method to validate and enter proper state name
    public static void validateState() {
        Scanner userInput=new Scanner(System.in);
        while(!state.matches("^[a-zA-Z\\s]*$")) {
            System.out.println("INVALID!\nEnter State :- ");
            state=userInput.nextLine();
        }
    }

    //method to validate and enter proper zip code
    public static void validateZipCode() {
        Scanner userInput=new Scanner(System.in);
        while(!zipCode.matches("\\d{6}")) {
            System.out.println("INVALID!!\nEnter Zip code :- ");
            zipCode=userInput.nextLine();
        }
    }

    //method to validate and enter proper email
    public static void validateEmail() {
        Scanner userInput=new Scanner(System.in);
        String EMAIL_REGEX ="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        while(!email.matches(EMAIL_REGEX)) {
            System.out.println("INVALID EMAIL ID !\n Enter Valid Email Id:-");
            email=userInput.nextLine();
        }
    }

    //method to check for duplicate entry of a person in addressBook
    public boolean checkForDuplicateEntry(Person person) {
        if(contacts.isEmpty())
            return false;
        Person duplicatePerson = contacts.stream()
                .filter(personInList->personInList.equals(person))
                .findFirst()
                .orElse(null);
        if(duplicatePerson!=null)
            return true;
        else
            return false;
    }

    //method to edit person details
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

    //method to delete a person from addressBook
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
    //method to display persons in current addressBook
    public void display() {
        System.out.println("\n*****************All Contacts************************\n");
        if(contacts.isEmpty()) {
            System.out.println("NO CONTACTS ADDED !");
            return;
        }
        contacts.stream().forEach(System.out::println);
    }

    //method to get persons in given city
    public List<Person> getPersonsByCity(String cityName) {
        List<Person> list = personsInCity.entrySet()
                .stream()
                .filter(city->city.getValue().equalsIgnoreCase(cityName))
                .map(personInCity->personInCity.getKey())
                .collect(Collectors.toList());
        return list;
    }

    //method to get persons in given state
    public List<Person> getPersonsByState(String stateName) {
        List<Person>list = personsInState.entrySet()
                .stream()
                .filter(state->state.getValue().equalsIgnoreCase(stateName))
                .map(personInState->personInState.getKey())
                .collect(Collectors.toList());
        return list;
    }

    //method to display persons details in given list
    public void displayNumberOfPersonsFound(List<Person>personsList,String name) {
        if(personsList.isEmpty()) {
            System.out.println("\""+name+"\" does not exists !");
        }
        else {
            System.out.println("\nPersons Found in "+name+" are :\n");
            personsList.forEach(System.out::println);
        }
    }

    //method to count persons by city in an addressBook
    public void countPersonsByCity(String cityName) {
        List<Person>personsInCity=getPersonsByCity(cityName);
        if(personsInCity.isEmpty())
            System.out.println("City "+cityName+" Does Not Exists !");
        else
            System.out.println("Total No. Of Persons Found In "+cityName.toUpperCase()+" Are :"+personsInCity.stream().count());
    }

    //method to count persons by state in an addressBook
    public void countPersonsByState(String stateName) {
        List<Person>personsInState=getPersonsByState(stateName);
        if(personsInState.isEmpty())
            System.out.println("State "+stateName+" Does Not Exists !");
        else
            System.out.println("Total No. Of Persons Found In "+stateName.toUpperCase()+" Are :"+personsInState.stream().count());
    }

    //method to sort person by first name and last name
    public void sortPersonsByName() {
        List<Person> sortedList = contacts.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName))
                .collect(Collectors.toList());
        System.out.println("\n--------- SORTED LIST OF PERSONS BY NAME ------------\n");
        sortedList.forEach(System.out::println);
    }
    //method to sort person by city
    public void sortPersonsByCity() {
        List<Person> sortedList = contacts.stream()
                .sorted(Comparator.comparing(Person::getCity))
                .collect(Collectors.toList());
        System.out.println("\n--------- SORTED LIST OF PERSONS BY CITY ------------\n");
        sortedList.forEach(System.out::println);

    }
    //method to sort person by state
    public void sortPersonsByState() {
        List<Person> sortedList = contacts.stream()
                .sorted(Comparator.comparing(Person::getState))
                .collect(Collectors.toList());
        System.out.println("\n--------- SORTED LIST OF PERSONS BY STATE ------------\n");
        sortedList.forEach(System.out::println);

    }
    //method to sort person by ZipCode
    public void sortPersonsByZipCode() {
        List<Person> sortedList = contacts.stream()
                .sorted(Comparator.comparingInt(Person::getZipCode))
                .collect(Collectors.toList());
        System.out.println("\n--------- SORTED LIST OF PERSONS BY ZIP CODE ------------\n");
        sortedList.forEach(System.out::println);
    }
}