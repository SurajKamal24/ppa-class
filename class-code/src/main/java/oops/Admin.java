package oops;

//Inheritance example
public class Admin extends Member {

    int powerLevel;

    public Admin(int p, int id, String name) {
        super(id, name);
        this.powerLevel = p;
    }

    public void block() {}

    public void unBlock() {}
}
