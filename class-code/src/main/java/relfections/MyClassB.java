package relfections;

import java.lang.reflect.Method;

public class MyClassB extends MyClassA {
    public void foo() {}
    private void bar() {}

    public static void main(String[] args) {
        Object o = new MyClassB();
        Class c = o.getClass();
        /*System.out.println(c.getSuperclass().getName()); //MyClassB
        System.out.println(c.getSuperclass().getSuperclass().getName()); //Object
        System.out.println(c.getSuperclass().getSuperclass().getSuperclass().getName()); //Null pointer exception
        //Method[] m = c.getDeclaredMethods();
        Method[] m = c.getMethods();
        for (Method method : m) {
            System.out.println(method.getName());
        }*/
        while (c != null) {
            Method[] m = c.getDeclaredMethods();
            for (Method method : m) {
                System.out.println(method.getName());
            }
            c = c.getSuperclass();
        }
    }
}
