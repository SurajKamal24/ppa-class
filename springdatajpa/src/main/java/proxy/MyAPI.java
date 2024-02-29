package proxy;

public class MyAPI implements API {

    @Override
    public String serve(String request) {
        System.out.println("serving...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello World!!!";
    }

}
