package relfections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        //Code → Compile → .class files. JVM → .class files → Run with JVM → load the classes -> Meta classes
        //Main.class
        /*Main m = new Main();
        System.out.println(m.getClass().getName());
        Class c = m.getClass();
        for (Method method : c.getMethods()) {
            System.out.println(method.getName());
        }*/
        //new DataManager().manage(new ApacheProcessor()); //illegal
        new DataManager().manage(new ApacheProcessor());
    }
    public static void foo() {

    }
}
