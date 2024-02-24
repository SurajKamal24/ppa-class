package hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Address address;
    @AttributeOverrides({
            @AttributeOverride(name = "addressLines",
                    column = @Column(name = "addresslines_off")),
            @AttributeOverride(name = "city",
                    column = @Column(name = "city_off")),
            @AttributeOverride(name = "state",
                    column = @Column(name = "state_off"))
        }
    )
    private Address officeAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}


// joins
// Items
// item_id, item_name
// Images
// img_id, item_id, img_url