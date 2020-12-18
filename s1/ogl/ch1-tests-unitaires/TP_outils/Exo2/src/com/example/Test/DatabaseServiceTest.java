package com.example.Test;

import com.example.model.City;
import com.example.service.DatabaseConnection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DatabaseServiceTest {
    static DatabaseConnection databaseConnection=new DatabaseConnection("sa","","org.h2.Driver","jdbc:h2:mem:test");
    static Connection connection;
    @BeforeClass
    public static void DBConnection(){
        databaseConnection.createDb(connection);
        databaseConnection.connect();
    }
    @Test
    public void addCity() {
        City city=new City(1,"Hebro",100000,"Hebro est une ville palestinienne");

    }

    @Test
    public void getCity() {
    }
    @AfterClass
    public static void BDDisconnection(){
        databaseConnection.disconnect(connection);
    }
}