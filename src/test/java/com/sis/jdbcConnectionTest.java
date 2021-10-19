package com.sis;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcConnectionTest {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://:3306/";
    private static final String USER = "";
    private static final String PW = "";

    @Test
    public void testConnection() throws Exception {
        Class.forName(DRIVER);

        try(Connection conn = DriverManager.getConnection(URL, USER, PW)){
            System.out.println(conn);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
