package hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "papers")
public class Paper {

    @Id
    @GeneratedValue
    private Long id;
    @Column(updatable = false, nullable = false)
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

// posts
// id, content, (lastModified)TimeStamp
// generated values