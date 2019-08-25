/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marcus
 */
public class Mapper {

    /**
     * @param obj
     * @return Map containing the attributes' names and it's values
     */
    public static Map<String, Object> getAttributesMap(Object obj) {

        Map<String, Object> attributesMap = new HashMap<>();

        Class<?> objClass = obj.getClass();
        Method[] methods = objClass.getMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                String attributeName;
                if (method.getReturnType() == void.class && method.getReturnType() != Collection.class) {
                    // Chave estrangeira
                    attributeName = method.getReturnType().getName() + "Id";
                } else {
                    attributeName = getAttributeName(method.getName());
                }
                try {
                    Object value = method.invoke(obj);
                    attributesMap.put(attributeName, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return attributesMap;
    }

    private static String getAttributeName(String name) {
        return name.substring(3);
    }
}
