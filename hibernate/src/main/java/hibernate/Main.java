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

        Item item = new Item();
        item.setName("ABC101");
        List<Image> imgs = item.getImages();
        Image img1 = new Image();
        img1.setItem(item);img1.setUrl("abc/def");
        imgs.add(img1);
        Image img2 = new Image();
        img2.setItem(item);img2.setUrl("lkl/def");
        imgs.add(img2);
        em.persist(item);

        em.getTransaction().commit();
        em.close();
    }

}


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