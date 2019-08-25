/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import infraestruture.helpers.PostgresConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class BaseDao{
    
    private final   Connection          _connection;
    protected       PreparedStatement   _ptst;
    protected       String              sql;

    public BaseDao() {
        this._connection = new PostgresConnection().IniciarConexao();
    }
    
    public ResultSet Find(){
        String aux = this.LimparSql();
        try {
            ResultSet valor = this._ptst.executeQuery(aux);
            this._ptst.close();
            return  valor;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean Execute(){
        try {
            boolean valor = this._ptst.execute();
            this._ptst.clearBatch();
            this._ptst.clearParameters();
            this.LimparSql();
            this._ptst.close();
            return valor;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        this._connection.commit();
        this._connection.close();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String LimparSql(){
        String aux = this.sql.substring(0);
        this.sql = "";
        return aux;
    }
    
}