package com.smc.demo;

import java.sql.*;

    public class TestConnection {
        public static void main(String[] args) {
            String url = "jdbc:mysql://mezhinjp2.beget.tech:3306/mezhinjp2_mfr";
            String user = "mezhinjp2_mfr";
            String password = "k1%Kr41rrPCu";

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connection successful!");
            } catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

