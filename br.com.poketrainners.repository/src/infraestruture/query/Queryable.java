/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture.query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repository.interfaces.IQueryable;

/**
 *
 * @author marcus
 * @param <T>
 */
public class Queryable<T> extends BaseQuery implements IQueryable{

    private final Class _type;
    private final T Object;

    public Queryable(Class<?> type, String sql) {
        super(sql);
        this._type = type;
        this.Object = null;
    }
    
    public Queryable(Class<?> type, T object, String sql) {
        super(sql);
        this._type = type;
        this.Object = object;
    }
    
    public Queryable<T> AddAndCondicion(String condicion){
        this._condicion += " AND (" + condicion + ") ";
        return this;
    }
    
    public Queryable<T> AddOrCondicion(String condicion){
        this._condicion += " OR (" + condicion + ") ";
        return this;
    }

    public List<T> Get(){
        return this.CriarListaDoTipoT(super.GetResult());
    }
    
    public boolean Set(){
        AjustaPtstParaObjeto(this.Object);
        return super.SetResult();
    }

    private void AjustaPtstParaObjeto(T data) {
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

    private List<T> CriarListaDoTipoT(ResultSet rs) {
        List<T> result = new ArrayList<>();
        Method[] Methods = this._type.getMethods();
        try {
            while (rs.next()) {
                Object o = this._type.newInstance();
                // TODO: Refatorar
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
                result.add((T) o);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException | SQLException e) {
        }
        return result;
    }

}
