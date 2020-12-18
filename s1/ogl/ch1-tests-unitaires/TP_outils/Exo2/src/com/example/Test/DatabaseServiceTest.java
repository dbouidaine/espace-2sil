package com.example.Test;

import com.example.model.City;
import com.example.service.DatabaseConnection;
import com.example.service.DatabaseService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;

public class DatabaseServiceTest{
    static DatabaseConnection connection =
            new DatabaseConnection("sa","","org.h2.Driver","jdbc:h2:mem:test");
    static Connection connect;

    @BeforeClass
    public static void DatabaseConnection(){
        connect = connection.connect();
        connection.createDb(connect);
    }

    @Test
    public void setGetCity(){
        City new_city = new City(1,"Alger",1,"A new city");
        DatabaseService.addCity(DatabaseServiceTest.connect,new_city);
        City db_city = DatabaseService.getCity(connect,1);
        assertTrue(new_city.equals(db_city));
    }

    @AfterClass
    public static void DatabaseDisconnection(){
        connection.disconnect(connect);
    }
}