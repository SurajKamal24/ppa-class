package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "numbers")
public class Number {
    @Id
    @GeneratedValue
    private long id;
    private  int val;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
}
