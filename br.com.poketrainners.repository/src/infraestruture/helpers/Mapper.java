/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestruture.helpers;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marcus
 */
public class Mapper {

    /**
     * @param methods
     * @return Map containing the attributes' names and it's values
     */
    public static ArrayList<String> getAttributesMap(Method[] methods) {

        ArrayList<String> attributes = new ArrayList<>();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                String attributeName;
                Class<?> data = method.getReturnType();
                if (data == void.class) {
                    continue;
                } else if (data == short.class || data == int.class
                        || data == boolean.class || data == float.class
                        || data == double.class || data == Date.class
                        || data == String.class) {
                    attributeName = getAttributeName(method.getName());
                } else {
                    // Chave estrangeira
                    attributeName = getAttributeName(method.getName() + "Id");
                }

                attributes.add(attributeName);
            }
        }
        
        attributes.remove(attributes.size() - 1);

        return attributes;
    }

    private static String getAttributeName(String name) {
        return name.substring(3);
    }
}
