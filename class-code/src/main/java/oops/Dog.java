package oops;

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("bark...");
    }

    public void wagTail() {
        System.out.println("wagging....");
    }
}
