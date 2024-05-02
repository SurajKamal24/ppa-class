package relfections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataManager {
    public String name;
    public int id;
    public static void manage(Object dataProcessor) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = dataProcessor.getClass();
        //Method m = c.getMethod("process");
        Method m = c.getDeclaredMethod("process", new Class[]{int.class, String.class});
        m.setAccessible(true);
        m.invoke(dataProcessor, new Object[]{1, "hello"});
        //DataManager.class
        /*DataManager dataManager = new DataManager();
        System.out.println(dataManager.getClass().getName());
        Class c = dataManager.getClass();
        Field[] f = c.getDeclaredFields();
        for (Field field : f) {
            System.out.println(field.getName());
        }
        Method[] m = c.getDeclaredMethods();
        for (Method method : m) {
            System.out.println(method.getName());
        }*/
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        manage(new ApacheProcessor());
    }
    public void foo() {}
    public void bar() {}
}
