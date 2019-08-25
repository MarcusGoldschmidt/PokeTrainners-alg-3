/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import infraestruture.helpers.GenerateSql;
import java.sql.PreparedStatement;

/**
 *
 * @author marcus
 * @param <T>
 */
public class GenericDao<T> extends BaseDao{
    
    private Class       _type;
    private GenerateSql _generateSql;

    public GenericDao(Class<?> type) {
        this._type = type;
        this._generateSql = new GenerateSql(this._type);
    }
    
    public T Index() {
        this.sql = this._generateSql.Index();
    }

    
    public T Show(int id) {
        this.sql = this._generateSql.Show(id);
    }

    
    public T Store(T data) {
        this.sql = this._generateSql.Store(data);
    }

    
    public T Update(int id, T data) {
        this.sql = this._generateSql.Update(id, data);
    }
    
    public T Delete(int id) {
         this.sql = this._generateSql.Delete(id, data);
    }
    
    protected PreparedStatement AjustarParametros(){
    
    }
    
}
