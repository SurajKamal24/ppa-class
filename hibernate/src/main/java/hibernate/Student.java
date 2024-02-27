package hibernate;

import jakarta.persistence.*;
import jdk.jfr.MemoryAddress;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "student_name")
    private String studentName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

}
