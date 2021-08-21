package com.bridgelabz;

import java.sql.SQLException;
import java.time.LocalDate;
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

    public List<AddressBookData> readAddressBookData(IOService ioService) throws SQLException {
        if (ioService.equals(IOService.DB_IO))
            return this.addressBookList = addressBookDBService.getAddressBookDataUsingDB();
        return null;
    }

    public void updateContact(String address, String name) {
        int result = addressBookDBService.updateContactDetails(name, address);
    }

    public boolean checkAddressBookInSyncWithDB(String name) {
        List<AddressBookData> addressBookDataList = addressBookDBService.getEmployeePayrollData(name);
        return addressBookDataList.get(0).equals(getEmployeePayrollData(name));
    }

    private AddressBookData getEmployeePayrollData(String name) {
        return this.addressBookList.stream().filter(PersonDataItem -> PersonDataItem.firstName.equals(name)).findFirst().orElse(null);
    }

    public List<AddressBookData> readPersonDataForDateRange(LocalDate startDate, LocalDate endDate) {
        return addressBookDBService.getPersonDataForDateRange(startDate, endDate);
    }
}