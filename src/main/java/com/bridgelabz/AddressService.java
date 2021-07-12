package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressService implements IAddress {

    ArrayList<Contact> book =new ArrayList<>();
    Scanner s = new Scanner(System.in);

    @Override
    public void Add() {

        Contact Info = new Contact();
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

    @Override
    public void Edit() {

        String temp=null;
        System.out.println("Enter the Phone number of the record u want to Edit");
        temp=s.next();
        if(book.isEmpty())
        {
            System.out.println("No records to edit");
            return;
        }

        for(int i=0;i<book.size();i++)
        {
            if(book.get(i).getPhone().equals(temp))
            {
                Contact Info=new Contact();
                System.out.println(temp);
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
                System.out.println("Enter your Email");
                Info.setEmail(s.next());
                book.remove(i);
                book.add(i, Info);
                System.out.println(book);
                break;
            }

        }
    }
    @Override
    public void Delete() {

        String temp=null;
        System.out.println("Enter the First name of the record you want to delete");
        temp=s.next();
        if(book.isEmpty())
        {
            System.out.println("No records to delete");
            return;
        }
        for(int i=0;i<book.size();i++)
        {
            if(book.get(i).getFname().equals(temp))
            {
                book.remove(i);
                break;
            }
        }
    }
}
