package serializationdeserialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//deserialize(String text, Class c)
//bean : Object managed by framework. No difference between object we create and object managed by framework
//DI : dependency injection
//DBAccessor -> Logger
// autowiring
public class Tester {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //load classes at runtime
        Class<?> c = Class.forName("serializationdeserialization.ReportCard");
        Constructor constructor = c.getConstructor();
        Object o = constructor.newInstance();
        for (Field f : c.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.getType().isPrimitive()) {
                f.set(o, 90);
            }
        }
        ReportCard reportCard = (ReportCard) o;
        System.out.println(reportCard.getId());
        /*ReportCard reportCard = new ReportCard(
                1,
                new ScienceMarks(90, 80, 85, 80.0),
                new ArtsMarks(85, 90, 87.5),
                86.25);
        System.out.println(new Serializer().serialize(reportCard));*/
    }
}
