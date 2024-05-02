package serializationdeserialization;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Serializer {
    public static String serialize(Object object) throws IllegalAccessException {
        String serializedString = "";
        Class c = object.getClass();
        serializedString = "{";
        List<Field> fields = getAllFieds(c);
        for (Field field : fields) {
            field.setAccessible(true);
            serializedString += field.getName() + ":";
            Object val = field.get(object);
            if (val.getClass().equals(Integer.class) || val.getClass().equals(Double.class)) {
                serializedString += val;
            } else {
                serializedString += serialize(val);
            }
            serializedString += ",";
        }
        serializedString = serializedString.substring(0, serializedString.length() - 1);
        serializedString += "}";
        return serializedString;
    }

    private static List<Field> getAllFieds(Class c) {
        List<Field> fields = new ArrayList<>();
        while (c != null) {
            Field[] f = c.getDeclaredFields();
            for (Field field : f) {
                fields.add(field);
            }
            c = c.getSuperclass();
        }
        return fields;
    }
}
