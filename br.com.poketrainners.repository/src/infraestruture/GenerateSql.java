/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import repository.interfaces.GenericSqlGenerator;


/**
 *
 * @author marcus
 * @param <T>
 */
public class GenerateSql<T> extends GenericSqlGenerator<T>{

    private T Type;
    
    private final String TableName;
    
    private final Map<String, Object> Atributes;
    
    private String AtributesName  = "";
    
    private String AtributesReplace  = "";
    
    private String AtributesUpdate  = "";

    
    public GenerateSql() throws NoSuchFieldException {
        Field field = this.getClass().getField("type");
        
        TableName = field.getGenericType().getTypeName();
        Atributes = Mapper.getAttributesMap(field.getType());
        
        Atributes.forEach((k,v) -> {
            AtributesName += v + ",";
        });
        AtributesName = AtributesName.substring(0, AtributesName.length() - 2);
        
        Atributes.forEach((k,v) -> {
            AtributesReplace += "?,";
        });
        AtributesReplace = AtributesReplace.substring(0, AtributesReplace.length() - 2);
        
        Atributes.forEach((k,v) -> {
            AtributesUpdate += v + "=?,";
        });
        AtributesUpdate = AtributesUpdate.substring(0, AtributesUpdate.length() - 2);
    }

    @Override
    public String Index() {
        return " SELECT * FROM " + TableName;
    }

    @Override
    public String Show(int id) {
        return " SELECT * FROM " + TableName    +
               " WHERE " + TableName + "Id "    +
               " = " + id;
    }

    @Override
    public String Store(T data) {
        
        return " INSERT INTO " + TableName      + 
               " (" + AtributesName + ") "      +
               " VALUES (" + AtributesReplace   + 
               " )";
    }

    @Override
    public String Update(int id,T data) {
        return " UPDATE " + TableName + " SET"  +
               AtributesUpdate + " WHERE "      +
               TableName + "Id =" + id;
    }

    @Override
    public String Delete(int id) {
        return " DELETE FROM " + TableName      +
               " WHERE " + TableName + "Id "    +
               " = " + id;
    }
    
    public Class getGenericType() {
        return Type.getClass();
    }
    
}
