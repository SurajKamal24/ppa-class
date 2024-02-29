package proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Object o = Proxy.newProxyInstance(API.class.getClassLoader(),
                new Class[]{API.class},
                new LoggingHandler(new MyAPI()));
        Object o1 = Proxy.newProxyInstance(API.class.getClassLoader(),
                new Class[]{API.class},
                new LatencyHandler(o));
        API a = (API) o1;
        a.serve("hello world");
    }
    // - req -> proxy --invoke()--> InvocationHandler --req--> target

}
// chain of proxies
// proxy
// class $Proxy0 {
//   InvocationHandler h;
//   String serve(String request) {
//      h.invoke(this, serve, request)
//   }
// }