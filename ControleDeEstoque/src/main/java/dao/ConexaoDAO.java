
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/estoque_db";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234567";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

        static Connection getConexao() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }}
