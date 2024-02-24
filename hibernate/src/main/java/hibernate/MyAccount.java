package hibernate;

import jakarta.persistence.*;

@Entity // instructs hibernate to map it to a table
@Table(name = "my_accounts")
public class MyAccount {

    @Column(name = "identifier")
    private Long id;
    private String name;
    private int age;

    @Id
    @GeneratedValue
    public Long getId() {
        System.out.println("getId invoked");
        return id;
    }

    public void setId(Long id) {
        System.out.println("setId invoked");
        this.id = id;
    }

    public String getName() {
        System.out.println("getName invoked");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName invoked");
        this.name = name;
    }

    public int getAge() {
        System.out.println("getAge invoked");
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge invoked");
        this.age = age;
    }

}
