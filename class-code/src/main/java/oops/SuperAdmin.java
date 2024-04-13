package oops;

//Inheritance example
public class SuperAdmin extends Admin {

    boolean vetoPower;

    public SuperAdmin(boolean v, int p, int id, String name) {
        super(p, id, name);
        this.vetoPower = v;
    }

}
