package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressService implements IAddress {

    ArrayList<AddressGetterSetter> book =new ArrayList<>();
    Scanner s = new Scanner(System.in);

    @Override
    public void Add() {

        AddressGetterSetter Info = new AddressGetterSetter();
        System.out.println("Enter First name:");
        Info.setFname(s.next());
        System.out.println("Enter last name:");
        Info.setLname(s.next());
        System.out.println("Enter your address:");
        Info.setAddress(s.next());
        System.out.println("Enter your city:");
        Info.setCity(s.next());
        System.out.println("Enter your state:");
        Info.setState(s.next());
        System.out.println("Enter your ZIP code:");
        Info.setZip(s.next());
        System.out.println("Enter your phone number");
        Info.setPhone(s.next());
        System.out.println("Enter your Email:");
        Info.setEmail(s.next());
        book.add(Info);
        System.out.println(book);
    }
}
