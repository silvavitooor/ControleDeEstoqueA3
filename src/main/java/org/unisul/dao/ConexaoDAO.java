package org.unisul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/estoque_bd";
    private static final String USUARIO = "root";
    private static final String SENHA = "Root";

    public static Connection conectar() {
        
        try{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
