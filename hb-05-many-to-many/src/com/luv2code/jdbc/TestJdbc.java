package com.luv2code.jdbc;

import com.luv2code.hibernate.demo.DemoDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DemoDatabase.connect()) {
            System.out.println("Connection successful");
        }
    }
}
