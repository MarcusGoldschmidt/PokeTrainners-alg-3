/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import repository.interfaces.IniciarConexao;

/**
 *
 * @author marcus
 */
public class PostgresConnection implements IniciarConexao{
    
    private final String urlDeConexao = "jdbc:postgresql://localhost:5433/pokemon";
    private final String usuario = "postgres";
    private final String senha = "55";

    @Override
    public Connection IniciarConexao() {
        try {	
            Class.forName("org.postgresql.Driver");	
            Connection conexao = DriverManager.getConnection(urlDeConexao, usuario, senha);
            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}