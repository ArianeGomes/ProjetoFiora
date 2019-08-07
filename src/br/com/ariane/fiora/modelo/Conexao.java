package br.com.ariane.fiora.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ariane
 */
public class Conexao {
    public Connection criarConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Fiora", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
