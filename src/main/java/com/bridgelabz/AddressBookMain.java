package com.bridgelabz;

import java.util.*;
import java.util.Map.Entry;

public class AddressBookMain {
    static HashMap<String,AddressBook>addressbooks=new HashMap<String,AddressBook>();
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program !!!");

        Scanner userInput=new Scanner(System.in);
        AddressBook addressbook=new AddressBook();
        int choice;
        String addressbookName = "Default";
        addressbooks.put("Default",addressbook);
        do {
            System.out.println("\n\n*******************OPTIONS********************\n");
            System.out.println("1]Add Contact\n2]Edit Contact\n3]Delete Contact\n4]Go To Address Book\n5]Display Current AddressBook\n"
                    + "6]Display All AddressBooks\n7]Exit");
            choice=userInput.nextInt();
            userInput.nextLine();
            switch(choice) {
                case 1:addressbook.addPerson();
                    addressbook.display();
                    break;
                case 2:addressbook.editPerson();
                    addressbook.display();
                    break;
                case 3:addressbook.deletePerson();
                    addressbook.display();
                    break;
                case 4:System.out.println("Enter name of Address Book:");
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
                case 5:addressbook.display();
                    break;
                case 6:System.out.println("*******All Address Book Details*******\n");
                    display();
                    break;
                case 7:	System.exit(0);
            }
        }while(choice!=7);
    }
    public static boolean isKeyExists(String name) {
        return addressbooks.containsKey(name);
    }


    public static void display() {
        Iterator<Entry<String, AddressBook>> trav=addressbooks.entrySet().iterator();
        while(trav.hasNext()) {
            Map.Entry record=(Map.Entry)trav.next();
            AddressBook adBook=(AddressBook)record.getValue();
            System.out.println("\""+record.getKey()+"\""+" "+adBook);
        }
    }
}
