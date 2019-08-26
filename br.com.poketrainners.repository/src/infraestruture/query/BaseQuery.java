/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture.query;

import infraestruture.helpers.PostgresConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class BaseQuery{
    
    private final   Connection          _connection;
    protected       PreparedStatement   _ptst;
    protected       String              _sql;
    protected       String              _condicion = "";

    public BaseQuery(String sql) {
        this._sql = sql;
        this._connection = new PostgresConnection().IniciarConexao();
    }
    
    protected ResultSet GetResult(){
        this.AdicionarCondicao();        
        String aux = this.LimparSql();
        try {
            ResultSet valor = this._ptst.executeQuery(aux);
            this._ptst.close();
            return  valor;
        } catch (SQLException e) {
            return null;
        }
    }
    
    protected boolean SetResult(){
        this.AdicionarCondicao();
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
        String aux = this._sql.substring(0);
        this._sql = "";
        return aux;
    }
    
    private void AdicionarCondicao(){
        if (this._condicion.length() > 0) {
            this._condicion = " WHERE " + this._condicion;
            this._sql = this._sql + this._condicion;
        }
    }
    
}