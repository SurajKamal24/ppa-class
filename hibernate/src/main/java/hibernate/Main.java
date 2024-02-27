package hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // use JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Item item = em.find(Item.class, 1L);
        long s = System.currentTimeMillis();
        item.getImages().get(0);
        long e = System.currentTimeMillis();
        System.out.println("Time taken: " + (e - s) + "ms");

        em.getTransaction().commit();
        em.close();
    }

}

// Spring Data JPA
// Hibernate
// JDBC
// course
// student
//Natural primary key: Users (user_id)
// primary key : composite
// Messages :
// msg_id(surrogate_key), sent_by, sent_to, msg
// Inventory : Items : Images
// item_id, image_url
// State
// Hibernate : Persistence context(o1, o2, o3)
// object (NEW, MANAGED, DETACHED, REMOVED)
// SQL queries : -
// select * from user where ....
// update, delete
// DDL : data defintion lang
// create table youracc(id int, name varchar)
// APPSV1, APPSV2, APPSV3
//  DBSV(Sequence Table)
// Table : FoodItem
// id, name, rating, priceInRupees
// users(home_address, office_address)
// id, name, age, gender, addresslines, city, state, zip, addresslines_off, city_off, state_off, zip_off
// class User
// Address addr;
// class Address