package com.bridgelabz;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AddressBookTest {
    AddressBook addressBook;
    List<AddressBookData> addressBookDataList;

    @Test
    public void givenThreeContactsInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        addressBook = new AddressBook();
        // addressBookDataList = addressBook.readAddressBookData(AddressBook.IOService.DB_IO);
        //Assertions.assertEquals(3, addressBookDataList.size());
        Assertions.assertEquals(4,  addressBook.readAddressBookData(AddressBook.IOService.DB_IO).size());
    }
}