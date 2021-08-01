package com.bridgelabz;

import java.util.*;
import java.util.Map.Entry;

public class AddressBookMain {
    static HashMap<String,AddressBook>addressbooks=new HashMap<String,AddressBook>();
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program !!!");
        @SuppressWarnings("resource")
        Scanner userInput=new Scanner(System.in);
        AddressBook addressbook=new AddressBook();
        int choice;
        String addressbookName = "Default";
        addressbooks.put("Default",addressbook);
        do {
            System.out.println("\n\n*******************OPTIONS********************\n");
            System.out.println("1]Add Contact\n2]Edit Contact\n3]Delete Contact\n4]Go To Address Book\n5]Display Current AddressBook\n"
                    + "6]Display All AddressBooks\n7]View Person by City or State in Current Address Book\n"
                    + "8]Search Person By City Or State In All Address Books\n9]Exit");
            choice=userInput.nextInt();
            userInput.nextLine();
            switch(choice) {
                case 1: addressbook.addPerson();
                    addressbook.display();
                    break;
                case 2: addressbook.editPerson();
                    addressbook.display();
                    break;
                case 3: addressbook.deletePerson();
                    addressbook.display();
                    break;
                case 4: System.out.println("Enter name of Address Book:");
                    addressbookName=userInput.nextLine();
                    if(isKeyExists(addressbookName)) {
                        System.out.println("This addressbook already exists!");
                        System.out.println("Entering '"+addressbookName+"' addressbook........");
                        addressbook=addressbooks.get(addressbookName);
                    }
                    else {
                        System.out.println("Creating New AddressBook........");
                        AddressBook tempAddressBook=new AddressBook();
                        addressbooks.put(addressbookName, tempAddressBook);
                        addressbook=tempAddressBook;
                        System.out.println("Welcome to '"+addressbookName+"' addressbook");
                    }
                    break;
                case 5: addressbook.display();
                    break;
                case 6: System.out.println("*******All Address Book Details*******\n");
                    display();
                    break;
                case 7: System.out.println("Enter (C) to View by City\nEnter (S) to View by State\n");
                    String input=userInput.nextLine();
                    if(input.equalsIgnoreCase("C"))
                        addressbook.viewPersonByCity();
                    else if(input.equalsIgnoreCase("S"))
                        addressbook.viewPersonByState();
                    else
                        System.out.println("Invalid Input!");
                    break;
                case 8: System.out.println("Enter (C) to search by City\nEnter (S) to search by State\n");
                    String searchInput=userInput.nextLine();
                    if(searchInput.equalsIgnoreCase("C"))
                        searchPersonByCity();
                    else if(searchInput.equalsIgnoreCase("S"))
                        searchPersonByState();
                    else
                        System.out.println("Invalid Input!");
                    break;
                case 9:	System.exit(0);
            }
        }while(choice!=9);
    }

    public static boolean isKeyExists(String name) {
        return addressbooks.containsKey(name);
    }

    @SuppressWarnings("rawtypes")
    public static void display() {
        Iterator<Entry<String, AddressBook>> trav=addressbooks.entrySet().iterator();
        while(trav.hasNext()) {
            Map.Entry record=(Map.Entry)trav.next();
            AddressBook adBook=(AddressBook)record.getValue();
            System.out.println("\""+record.getKey()+"\""+" "+adBook);
        }
    }

    public static void searchPersonByCity() {
        Scanner userInput=new Scanner(System.in);
        System.out.print("Enter city name :");
        int flag=0;
        String cityName=userInput.nextLine();
        for(Map.Entry record : addressbooks.entrySet()){
            AddressBook addressbook=(AddressBook) record.getValue();
            for(Person person : addressbook.contacts) {
                if(person.city.equalsIgnoreCase(cityName)) {
                    flag=1;
                    System.out.println(person);
                }
            }
        }
        if(flag==0)
            System.out.println("This City does not exists!");
    }

    public static void searchPersonByState() {
        Scanner userInput=new Scanner(System.in);
        System.out.print("Enter State name :");
        String stateName=userInput.nextLine();
        int flag=0;
        for(Map.Entry record : addressbooks.entrySet()){
            AddressBook addressbook=(AddressBook) record.getValue();
            for(Person person : addressbook.contacts) {
                if(person.state.equalsIgnoreCase(stateName)) {
                    flag=1;
                    System.out.println(person);
                }
            }
        }
        if(flag==0)
            System.out.println("This State does not exists!");
    }
}
