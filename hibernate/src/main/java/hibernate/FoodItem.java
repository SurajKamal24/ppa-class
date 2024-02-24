package hibernate;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "foodItem")
public class FoodItem {

    @Id
    @GeneratedValue
    private Long id;
    private float rating;
    private String name;
    @Column(name = "priceInDollars")
    @ColumnTransformer(
            read = "priceInDollars * 60",
            write = "? / 60"
    )
    private int priceInRupees;
    @Formula("(select avg(f.rating) from foodItem f)")
    private float avgRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceInRupees() {
        return priceInRupees;
    }

    public void setPriceInRupees(int priceInRupees) {
        this.priceInRupees = priceInRupees;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

}
