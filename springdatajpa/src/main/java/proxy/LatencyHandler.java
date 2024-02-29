package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LatencyHandler implements InvocationHandler {

    private final Object target;

    public LatencyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("started at " + start + " ms");
        Object o = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("ended at " + end + " ms" + "time: " + (end - start));
        return o;
    }

}
