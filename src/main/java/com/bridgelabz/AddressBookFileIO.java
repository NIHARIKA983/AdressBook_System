package com.bridgelabz;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBookFileIO {
    public void writeData(Map<String, AddressBook> addressBook) {
        File file = new File("Contacts.txt");
        BufferedWriter bf = null;;
        try {
            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
            //iterate map entries
            for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
                //put key and value separated by a colon
                bf.write(entry.getKey() + ":" + entry.getValue());

                //new line
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //  public List<Contacts> readData() {
    public static Map<String,  String> readData() {
        Map<String, String> mapFileContents = new HashMap<>();
        BufferedReader br = null;
        try {
            //create file object
            File file = new File("Contacts.txt");

            //create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;
            //read file line by line
            while ((line = br.readLine()) != null) {

                //split the line by :
                String[] parts = line.split(":");

                //first part is name, second is age
                String bookName = parts[0].trim();
                String fname = parts[1].trim();
                mapFileContents.put(bookName, fname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return mapFileContents;
    }
}