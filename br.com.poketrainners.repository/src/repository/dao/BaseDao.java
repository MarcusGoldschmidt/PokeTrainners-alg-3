/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import infraestruture.helpers.GenerateSql;
import infraestruture.helpers.PostgresConnection;
import java.sql.Connection;
import java.util.ArrayList;
import repository.interfaces.IBaseDao;

/**
 *
 * @author marcus
 * @param <T>
 */
public abstract class BaseDao<T> implements IBaseDao<T> {

    private final Class<T> Type;

    private final GenerateSql<T> _generateSql;
    
    protected Connection connect = (new PostgresConnection().IniciarConexao()); 

    public BaseDao(Class<T> type) {
        this.Type = type;
        this._generateSql = new GenerateSql<>(this.Type);
    }
    
    public abstract ArrayList<T> Index();

    public abstract T Show(int id);

    public abstract boolean Store(T data);

    public abstract boolean Update(T data);

    public abstract boolean Delete(int id);
    
    @Override
    protected void finalize() throws Throwable {
        connect.commit();
        connect.close();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
