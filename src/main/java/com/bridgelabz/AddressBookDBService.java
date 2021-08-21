package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

    private static AddressBookDBService addressBookDBService;
    private static PreparedStatement addressBookDataStatement;
    private static PreparedStatement prepareStatement;

    public static AddressBookDBService getInstance() {
        if (addressBookDBService == null)
            addressBookDBService = new AddressBookDBService();
        return addressBookDBService;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book?useSSL=false";
        String userName = "root";
        String password = "root123";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!" + connection);
        return connection;
    }

    public List<AddressBookData> getAddressBookDataUsingDB() {
        String sql = "SELECT * FROM address_book";
        List<AddressBookData> addressBookList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            addressBookList = this.getEmployeePayrollData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    public int updateContactDetails(String name, String address) {
        String sql = String.format("update address_book set address = '%s' where firstName = '%s';", address, name);
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<AddressBookData> getEmployeePayrollData(String name) {
        List<AddressBookData> employeePayrollList = null;
        String sql = "SELECT * from address_book  WHERE firstName = ?";
        if (this.addressBookDataStatement == null)
            addressBookDataStatement = this.prepareStatementForAddressBook(sql);
        try {
            addressBookDataStatement.setString(1, name);
            ResultSet resultSet = addressBookDataStatement.executeQuery();
            employeePayrollList = this.getEmployeePayrollData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }

    private PreparedStatement prepareStatementForAddressBook(String sql) {
        try {
            Connection connection = this.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            return prepareStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<AddressBookData> getEmployeePayrollData(ResultSet resultSet) {
        List<AddressBookData> addressBookList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                int phone = Math.toIntExact(resultSet.getLong("phoneNumber"));
                String email = resultSet.getString("email");
                addressBookList.add(new AddressBookData(id, firstName, lastName, address, city, state, zip, phone, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }
}