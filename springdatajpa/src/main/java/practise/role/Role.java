package practise.role;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mail_forwarding_role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Access> accessList = new HashSet<>();

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }

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

    public Set<Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(Set<Access> accessList) {
        this.accessList = accessList;
    }

}
