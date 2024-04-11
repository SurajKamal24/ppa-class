package class1;

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("meow...");
    }

    public void doCatWalk() {
        System.out.println("cat walking....");
    }
}
