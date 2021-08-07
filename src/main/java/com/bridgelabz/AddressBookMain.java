package com.bridgelabz;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.*;

public class AddressBookMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        Map<String, AddressBook> addressBookMap = new HashMap<>();

        while (true) {
            System.out.println("\n************* Welcome to Address Book System **************");
            System.out.println("1. New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Delete Address Book");
            System.out.println("4. Search Contacts");
            System.out.println("5. View Contacts");
            System.out.println("6. Count Contacts ");
            System.out.println("7. Write data into text File");
            System.out.println("8. Read data from text File");
            System.out.println("9. Write data into CSV File");
            System.out.println("10. Read data from CSV File");
            System.out.println("11. Write data into JSON File");
            System.out.println("12. Read data from JSON File");
            System.out.println("13. Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    //adding bookName as a key and value is allocating memory for addressBook obj
                    addressBookMap.put(bookName, new AddressBook());
                    //call addressBook option method with passing key of hashmap
                    addressBook.addressBookOptions(addressBookMap.get(bookName));
                    break;
                case 2:
                    System.out.println("List of available Address Book : ");
                    //retrieved keys from hashmap to show addressBookList
                    Set keys = addressBookMap.keySet();
                    Iterator i = keys.iterator();
                    while (i.hasNext()){
                        System.out.println(i.next());
                    }
                    System.out.println("Enter Address Book name you want to Open : ");
                    String name = sc.nextLine();
                    System.out.println("Current Address Book is : " + name);
                    //call method with passing address book name
                    addressBook.addressBookOptions(addressBookMap.get(name));
                    break;
                case 3:
                    System.out.println("List of available Address Book : ");
                    //retrieved keys from hashmap to show addressBookList
                    Set keys1 = addressBookMap.keySet();
                    for (Object o : keys1) {
                        System.out.println(o);
                    }
                    System.out.println("Enter Address Book name to be delete: ");
                    name = sc.nextLine();
                    addressBookMap.remove(name);
                    break;
                case 4:
                    addressBook.searchByOptions();
                    break;
                case 5:
                    addressBook.viewByOption(addressBookMap);
                    break;
                case 6:
                    addressBook.countByOption();
                    break;
                case 7:
                    AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
                    addressBookFileIO.writeData(addressBookMap);
                    break;
                case 8:
                    AddressBookFileIO addressBookFileIO2 = new AddressBookFileIO();
                    System.out.println(addressBookFileIO2.readData());
                    break;
                case 9:
                    try {
                        AddressBookCSV.writeDataToCSV();
                    } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    try {
                        AddressBookCSV.readDataFromCSV();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    try {
                        AddressBookJSON.writeDataToJSon();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 12:
                    try {
                        AddressBookJSON.readDataFromJson();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 13:
                    sc.close();
                    return;
                default:
                    System.out.println("Enter a Valid Choice...!");
                    break;
            }
        }
    }
}