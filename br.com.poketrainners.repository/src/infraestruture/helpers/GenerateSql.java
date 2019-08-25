/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture.helpers;

import java.util.ArrayList;
import repository.interfaces.GenericSqlGenerator;

/**
 *
 * @author marcus
 * @param <T>
 */
public class GenerateSql<T> extends GenericSqlGenerator<T> {

    private Class<T> Type;

    protected final String TableName;

    public final ArrayList<String> Atributes;

    protected String AtributesName = "";

    protected String AtributesReplace = "";

    protected String AtributesUpdate = "";

    public GenerateSql(Class<T> type) {
        this.Type = type;

        TableName = this.Type.getSimpleName();

        Atributes = Mapper.getAttributesMap(this.Type.getMethods());
        
        // Removendo PK
        for (int i = 0; i < Atributes.size(); i++) {
            if (( Atributes.get(i)).equals(TableName + "Id")) {
                Atributes.remove(i);
                break;
            }
        }

        Atributes.forEach((v) -> {
            AtributesName += v + ",";
        });
        AtributesName = AtributesName.substring(0, AtributesName.length() - 1);

        Atributes.forEach((v) -> {
            AtributesReplace += "?,";
        });
        AtributesReplace = AtributesReplace.substring(0, AtributesReplace.length() - 1);

        Atributes.forEach((v) -> {
            AtributesUpdate += v + "=?,";
        });
        AtributesUpdate = AtributesUpdate.substring(0, AtributesUpdate.length() - 1);
    }

    @Override
    public String Index() {
        return " SELECT * FROM " + TableName;
    }

    @Override
    public String Show(int id) {
        return " SELECT * FROM " + TableName
                + " WHERE " + TableName + "Id "
                + " = " + id;
    }

    @Override
    public String Store(T data) {
        return " INSERT INTO " + TableName
                + " (" + AtributesName + ") "
                + " VALUES (" + AtributesReplace
                + " )";
    }

    @Override
    public String Update(int id, T data) {
        return " UPDATE " + TableName + " SET"
                + AtributesUpdate + " WHERE "
                + TableName + "Id =" + id;
    }

    @Override
    public String Delete(int id) {
        return " DELETE FROM " + TableName
                + " WHERE " + TableName + "Id "
                + " = " + id;
    }

    protected Class<T> getType() {
        return Type;
    }

}
