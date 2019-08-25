/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture;

import repository.interfaces.GenericSqlGenerator;


/**
 *
 * @author marcus
 * @param <T>
 */
public class GenerateSql<T> implements GenericSqlGenerator<T>{

    @Override
    public String Index() {
        return "";
    }

    @Override
    public String Show(int id) {
        return "";
    }

    @Override
    public String Store(T data) {
        return "";
    }

    @Override
    public String Update(T data) {
        return "";
    }

    @Override
    public String Delete(int id) {
        return "";
    }
    
}
