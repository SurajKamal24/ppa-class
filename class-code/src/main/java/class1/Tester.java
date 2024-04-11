package class1;

import java.util.List;

public class Tester {
    public static void main(String[] args) {

        //create a reference pointer and point it to an object
        /*Person p = new Person(10, "Ron");
        System.out.println(p.getAge());
        System.out.println(p.getName());*/

        //make the same pointer to point it to a different object
        /*p = new Person(24, "Rahul");
        System.out.println(p.getAge());
        System.out.println(p.getName());*/

        //Updating the variable via setter
        /*Person p = new Person(10, "Ron");
        p.setAge(20); // valid
        System.out.println(p.getAge());
        p.setAge(-9); // invalid*/

        //final variable can never be initialized again
        /*final int x = 2;
        x = 3; //Not allowed*/

        /*final Person p = new Person(10, "Ron", new BioData("BCA"));
        System.out.println(p.getAge() + " " + p.getName() + " " + p.getBioData().degree);
        //p1.setAge(20); //Not allowed because the variables in the class is final
        //p = new Person(10, "Ron", new BioData("BCA")); //Not allowed because p is final*/

        //non-static variable - cnt
        /*Person p1 = new Person(10, "Ron", new BioData("BCA"));
        Person p2 = new Person(10, "Ron", new BioData("BCA"));
        System.out.println(p2.getCnt());*/

        //static example - cnt
        /*Person p1 = new Person(10, "Ron", new BioData("BCA"));
        Person p2 = new Person(10, "Ron", new BioData("BCA"));
        System.out.println(p1.getCnt());*/

        //static method example
        //Person.hello();

        //polymorphism example
        /*Dog d = new Dog();
        Cat c = new Cat();*/
        //Animal a = new Animal(); //illegal - cannot be instantiated
        /*Animal a = new Dog();
        a.makeSound();
        a = new Cat();
        a.makeSound();*/
        //Cat c1 = a; //illegal - parent object cannot be accommodated inside child because a parent can point to any children so we cannot that reside inside a child but the reverse is possible

        /*Animal a = null;
        a = new Dog();
        a = new Cat(); //illegal - runtime exception - class cast exception
        Dog d = (Dog) a; //type casting*/

        /*Dog d = new Dog();
        d.makeSound();
        d.wagTail();

        Cat c = new Cat();
        c.makeSound();
        c.doCatWalk();*/
        //Animal a = new Dog();
        //a.wagTail();//illegal compilation happens first before running the program. Need to typecasting and then call the methdd

        //Admin a = new Admin();
        //Member a = new Admin();
        SuperAdmin s = new SuperAdmin();
        Admin a = new SuperAdmin();
        Member m = new SuperAdmin(); //SuperAdmin -> Admin -> Member -> Object => Inheritance hierarchy
    }

    //it takes polymorphic type. Allows to write generic code
    public static void makeSomeNoise(List<Animal> animals) {
        /*for (Animal animal : animals) {
            animal.makeSound();
        }*/
        //not a generic code - poor low level design
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog d = (Dog) animal;
                d.wagTail();
            } else if (animal instanceof Cat) {
                Cat c = (Cat) animal;
                c.doCatWalk();
            }
        }
    }
}
