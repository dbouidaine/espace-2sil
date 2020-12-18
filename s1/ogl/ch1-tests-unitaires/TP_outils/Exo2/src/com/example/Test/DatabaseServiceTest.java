package com.example.Test;

import com.example.model.City;
import com.example.service.DatabaseConnection;
import com.example.service.DatabaseService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;

public class DatabaseServiceTest {
    static DatabaseConnection connection =
            new DatabaseConnection("sa", "", "org.h2.Driver", "jdbc:h2:mem:test");
    static Connection connect;
    static City city = new City(1, "Alger", 1, "A new city");

    @BeforeClass
    public static void DatabaseConnection() {
        connect = connection.connect();
        connection.createDb(connect);
    }

    @Test
    public void addCity() {
        int i = DatabaseService.addCity(DatabaseServiceTest.connect, city);
        assertEquals(1, i);
    }

    @Test
    public void getCity() {
        City db_city = DatabaseService.getCity(connect, 1);
        assertTrue(city.equals(db_city));
    }

    @AfterClass
    public static void DatabaseDisconnection() {
        connection.disconnect(connect);
    }
}