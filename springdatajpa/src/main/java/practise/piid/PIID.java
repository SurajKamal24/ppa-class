package practise.piid;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mail_forwarding_piid")
public class PIID {

    @Id
    @GeneratedValue
    @Column(name = "piid_id")
    private Long id;
    @Column(name = "value", unique = true)
    private String value;

    @OneToMany(mappedBy = "piid", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Access> accessList = new HashSet<>();

    public PIID() {

    }

    public PIID(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(Set<Access> accessList) {
        this.accessList = accessList;
    }

}
