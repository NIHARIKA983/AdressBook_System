package com.bridgelabz;

import java.util.List;

public class AddressBook {

    public enum IOService {
        DB_IO
    }

    private List<AddressBookData> addressBookList;
    public final AddressBookDBService addressBookDBService;

    public AddressBook() {
        addressBookDBService = AddressBookDBService.getInstance();
    }

    public AddressBook(List<AddressBookData> addressBookList) {
        this();
        this.addressBookList = addressBookList;
    }

    public List<AddressBookData> readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO))
            return this.addressBookList = addressBookDBService.getAddressBookDataUsingDB();
        return null;
    }
}