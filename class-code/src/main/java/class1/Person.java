package class1;


public class Person {

    //public variables
    /*public int age;
    public String name;*/

    //private variables
    /*private int age;
    private String name;*/

    //default constructor
    /*public Person() {

    }*/

    //parameterized constructor
    /*public Person(int a, String n) {
        if (a < 0) {
            throw new RuntimeException("Age cannot be negative");
        }
        this.age = a;
        this.name = n;
    }*/

    //getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    //setters - to update a private variable
    /*public void setAge(int a) {
        if (a < 0) {
            throw new RuntimeException("Age cannot be negative");
        }
        this.age = a;
    }*/

    //final & static variables
    private final int age;
    private final String name;
    //private BioData bioData;
    private final BioData bioData;

    //non-static variable
    //public int cnt = 0;
    //static variable
    public static int cnt = 0;

    //Can't have setters for final variables so initialized during object creation through a constructor
    public Person(int age, String name, BioData bioData) {
        this.cnt++;
        this.age = age;
        this.name = name;
        this.bioData = bioData;
    }

    public BioData getBioData() {
        return bioData;
    }

    public int getCnt() {
        return cnt;
    }

    //static method invocation
    public static void hello() {
        System.out.println("Hello world");
        //System.out.println("Hello world" + age); //not possible
        //getName(); //not possible
    }

    //method invocation
    public void sayHi() {
        System.out.println("hi");
    }

}
