/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class Connection {
    
    private final String urlDeConexao = "jdbc:mysql://localhost/pizzaria";
    private final String usuario = "root";
    private final String senha = "";

    public Connection IniciarConexao() {
        try {
            Connection conexao = (Connection) DriverManager.getConnection(urlDeConexao, usuario, senha);
            System.out.println("Conectado");
            return conexao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
