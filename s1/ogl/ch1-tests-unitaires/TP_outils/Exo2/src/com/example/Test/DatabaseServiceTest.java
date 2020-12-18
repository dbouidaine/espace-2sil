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
    /*instanciation de la classe DatabaseConnection  */
    /*on a déclaré 'connect' et 'connection' comme étant des variables static pour pouvoir les
      utiliser dans la class DatabaseConnection et DatabaseDisconnection*/
    static DatabaseConnection connection =
            new DatabaseConnection("sa", "", "org.h2.Driver", "jdbc:h2:mem:test");
    static Connection connect;
    @BeforeClass
    /*la méthode DatabaseConnection qui permet la connexion à la BDD doit étre executer avant tout
     les tests c'est pour ça on a utilisé cette méthode dans @BeforeClass  */
    public static void DatabaseConnection() {
        connect = connection.connect();
        connection.createDb(connect);
    }

    @Test
    public void addCity() {
        /*création d'une ville*/
        City city = new City(1, "Alger", 1, "A new city");
        /*insertion de la ville crée*/
        int i = DatabaseService.addCity(DatabaseServiceTest.connect, city);
        /*si la méthode fonctionne bien elle doit retourner le nombre de lignes insérés(une seul ligne)*/
        assertEquals(1,i);
    }

    @Test
    public void getCity() {
        /*création d'une ville*/
        City city = new City(2, "Constantine", 1, "A new city");
        /*insertion de la ville crée*/
        int i = DatabaseService.addCity(DatabaseServiceTest.connect, city);
        /*la recupération de la ville insérée précedement*/
        City db_city = DatabaseService.getCity(connect, 2);
        /*si la méthode fonctionne bien elle doit rétourner la méme ville insérée précedement*/
        assertTrue(city.equals(db_city));
    }

    @AfterClass
    /*la méthode DatabaseDisconnection qui permet la déconnexion de la BDD doit étre executer aprés la
     fin de tout les tests c'est pour ça on a utilisé cette méthode dans @AfterClass  */
    public static void DatabaseDisconnection() {
        connection.disconnect(connect);
    }
}