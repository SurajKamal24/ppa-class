package exceptionhandling;

//topics - exception handling, try-catch block, throw, throws

import javax.naming.directory.InvalidAttributesException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        //printUserNames();
        //foo();
        //standardise(null);
        //publish(10, 10, 10);
        //read();
        //System.out.println(cube(8));
        read();
    }

    //try catch example
    public static void printUserNames() throws IOException {
        FileReader fileReader = null;
        try { //regular logic
            fileReader = new FileReader("D:\\personal\\local-repo\\ppa-class\\class-code\\src\\main\\resources\\test_file.txt");
            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) { // exception handling logic
            throw new RuntimeException(e);
        }
        fileReader.close();
    }

    //duck the exception example
    public static void foo() throws FileNotFoundException {
        bar();
    }

    //handle the exception example
    /*public void foo() throws FileNotFoundException {
        try {
            bar();
        } catch (FileNotFoundException e) {
            System.out.println("error occurred");
            throw e; //throwing the exception to the caller
        }
    }*/

    // checked exception
    /*public static void bar() throws FileNotFoundException {
        throw new FileNotFoundException();
    }*/

    //unchecked exception
    public static void bar() {
        throw new RuntimeException();
    }

    //unchecked to checked exception
    public static void standardise(String userName) throws InvalidAttributesException {
        if (userName == null) {
            throw new InvalidAttributesException("Username cannot be null");
        }
        userName = userName.toLowerCase();
    }

    //user defined exception example
    public static void publish(int revenue, int expenses, int savings) throws IllegalFinancialMetricException, FileNotFoundException, ThirdPartyException {
        //throwing just the exception
        /*if (revenue - expenses != savings) {
            throw new IllegalFinancialMetricException(
                    "found revenue: " + revenue +
                            ", expenses: " + expenses +
                            ", savings: " + savings +
                            "and they don't add up"
            );
        }*/
        //throwing exception with root cause
        try {
            thirdParty(2);
        }/*catch (Exception e) {
            //throw new IllegalFinancialMetricException(e);
            throw new IllegalFinancialMetricException("3rd party exception occurred", e);
        }*/ /*catch (ThirdPartyException e) {
            System.out.println("here");
            throw new IllegalFinancialMetricException("3rd party exception occurred", e);
        } catch (FileNotFoundException f) {
            System.out.println("handling gracefully");
        } catch (Exception e) {
            System.out.println("parent of all exceptions");
        }*/ catch (FileNotFoundException | EOFException f ) {
            System.out.println("file not found exception occurred");
        } catch (IOException e) {
            System.out.println("IO exception occurred");
        }
    }

    /*public static void thirdParty() throws ThirdPartyException {
        throw new ThirdPartyException();
    }*/

    //multiple catch blocks example
    public static void thirdParty(int i) throws IOException, ThirdPartyException {
        if (i == 1) {
            //throw new ThirdPartyException();
            throw new IOException();
        } else if (i > 10) {
            throw new EOFException();
        }
        throw new FileNotFoundException();
    }

    // finally block problem - overrides the original result
    public static int cube(int x) {
        try {
            return  x*x*x;
        } finally {
            return -1;
        }
    }

    // finally block example
    /*public static void read() throws Exception {
        FileReader fileReader = new FileReader("D:\\personal\\local-repo\\ppa-class\\class-code\\src\\main\\resources\\test_file.txt");
        MyResource myResource = new MyResource();
        Exception var = null;
        try {
            // reading
            throw new FileNotFoundException();
        } catch (Exception e) {
            // handle exception
            var = e;
            throw var;
        } finally {
            System.out.println("Inside finally block");
            try {
                myResource.close();
            } catch (Exception e1) {
                if (var == null) {
                    var = e1;
                    throw var;
                }
            }
        }
    }*/

    //try-with-resources
    public static void read() throws Exception {
        try(MyResource myResource = new MyResource()) {
            //some code
            throw new FileNotFoundException();
        }
    }
}
