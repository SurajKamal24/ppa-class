package hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class YourAcc {

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
}
