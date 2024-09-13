/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VGRCAORT
 */
public class Conexion{

    private static Connection con;

    private Conexion(){

    }

    public static Connection getConexion(String DRIVER, String URL, String usuario, String contrasenia) {
        con=null;
        if (con == null) {
            try {
                Class.forName(DRIVER); // Chequeo de Driver (sujeto a excepciones)
                con = DriverManager.getConnection(URL, usuario, contrasenia); // Obtener la conexión
                System.out.println("Conexión exitosa: " + con.getClass().getName());
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException("No se encuentra driver " + DRIVER, ex);
            } catch (SQLException ex) {
                throw new RuntimeException("No se pudo establecer conexión con la BD", ex);
            }
        }
        return con;
    }



}