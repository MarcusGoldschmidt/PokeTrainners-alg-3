/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class PostgresConnection {
    
    private final String urlDeConexao = "jdbc:mysql://localhost/pizzaria";
    private final String usuario = "root";
    private final String senha = "";

    public Connection IniciarConexao() {
        try {
            Connection conexao = DriverManager.getConnection(urlDeConexao, usuario, senha);
            return conexao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
