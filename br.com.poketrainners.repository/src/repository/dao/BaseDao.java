/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import infraestruture.helpers.GenerateSql;
import infraestruture.query.Queryable;
import repository.interfaces.IBaseDao;
import repository.interfaces.IQueryable;

/**
 *
 * @author marcus
 * @param <T>
 */
public class BaseDao<T> implements IBaseDao<T> {

    private final Class<T> Type;

    private final GenerateSql _generateSql;

    public BaseDao(Class<T> type) {
        this.Type = type;
        this._generateSql = new GenerateSql(this.Type);
    }

    @Override
    public IQueryable<T> Index() {
        return new Queryable<>(this.Type, this._generateSql.Index());
    }

    @Override
    public IQueryable<T> Show(int id) {
        return new Queryable<>(this.Type, this._generateSql.Show(id));
    }

    @Override
    public boolean Store(T data) {
        return new Queryable<>(this.Type, data, this._generateSql.Store(data)).Set();
    }

    @Override
    public boolean Update(int id, T data) {
        return new Queryable<>(this.Type, data, this._generateSql.Update(id, data)).Set();
    }

    @Override
    public boolean Delete(int id) {
        return new Queryable<>(this.Type, this._generateSql.Delete(id)).Set();
    }

}
