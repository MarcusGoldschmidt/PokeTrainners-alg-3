/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import infraestruture.helpers.GenerateSql;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcus
 * @param <T>
 */
public class GenericDao<T> extends BaseDao {

    private final Class _type;
    private final GenerateSql _generateSql;

    public GenericDao(Class<?> type) {
        super();
        this._type = type;
        this._generateSql = new GenerateSql(this._type);
    }

    public T Index() {
        this.sql = this._generateSql.Index();
        return null;
    }

    public T Show(int id) {
        this.sql = this._generateSql.Show(id);
        return null;
    }

    public T Store(T data) {
        this.sql = this._generateSql.Store(data);
        return null;
    }

    public T Update(int id, T data) {
        this.sql = this._generateSql.Update(id, data);
        return null;
    }

    public T Delete(int id) {
        this.sql = this._generateSql.Delete(id);
        return null;
    }

    protected void AjustarParametrosGet(T data) {
        try {
            Method[] Methods = this._type.getMethods();
            for (int i = 0; i < Methods.length; i++) {
                if (Methods[i].getName().startsWith("get")) {
                    if (Methods[i].getReturnType() == double.class) {
                        this._ptst.setDouble(i, (double) Methods[i].invoke(data));
                    } else if (Methods[i].getReturnType() == int.class) {
                        this._ptst.setInt(i, (int) Methods[i].invoke(data));
                    } else {
                        this._ptst.setString(i, (String) Methods[i].invoke(data));
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException | SQLException e) {
        }
    }

    protected List<T> AjustarParametrosSet(ResultSet rs) {
        List<T> result = new ArrayList<>();
        Method[] Methods = this._type.getMethods();
        try {
            while (rs.next()) {
                Object o = this._type.newInstance();
                for (Method Method : Methods) {
                    if (Method.getName().startsWith("set")) {
                        if (Method.getReturnType() == double.class) {
                            Method.invoke(o, rs.getDouble(Method.getName().substring(3)));
                        } else if (Method.getReturnType() == int.class) {
                            Method.invoke(o, rs.getInt(Method.getName().substring(3)));
                        } else {
                            Method.invoke(o, rs.getString(Method.getName().substring(3)));
                        }
                    }
                }
                result.add((T)o);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException | SQLException e) {
        }
        return result;
    }

}
