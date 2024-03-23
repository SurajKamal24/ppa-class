package practise.user;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import practise.access.Access;

@Entity
@Table(name = "mail_forwarding_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Access> accessList = new HashSet<>();

    public User() {

    }

    public User(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(Set<Access> accessList) {
        this.accessList = accessList;
    }

}
