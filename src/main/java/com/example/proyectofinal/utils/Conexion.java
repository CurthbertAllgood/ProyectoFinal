package com.example.proyectofinal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class Conexion {
    private static String DRIVER;
    private static String URL;
    private static String USUARIO;
    private static String CONTRASENIA;

    static {
        try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                throw new ExceptionInInitializerError("Sorry, unable to find config.properties");
            }
            Properties prop = new Properties();
            prop.load(input);
            DRIVER = prop.getProperty("db.driver");
            URL = prop.getProperty("db.url");
            USUARIO = prop.getProperty("db.user");
            CONTRASENIA = prop.getProperty("db.password");

            Class.forName(DRIVER);
        } catch (IOException | ClassNotFoundException ex) {
            throw new ExceptionInInitializerError("Error initializing database connection: " + ex.getMessage());
        }
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
    }
}
