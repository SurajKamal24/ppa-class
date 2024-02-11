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
        MyAccount myAccount = new MyAccount();
        myAccount.setName("Ron");
        myAccount.setAge(23); // New
        em.persist(myAccount); // New ===> Manager
        em.detach(myAccount);
        myAccount.setAge(24);
        em.merge(myAccount);
        em.getTransaction().commit();
        em.close();
    }

}

// object (NEW, MANAGED, DETACHED, REMOVED)
// SQL queries : -
// select * from user where ....
// update, delete
// DDL : data defintion lang
// create table youracc(id int, name varchar)
// APPSV1, APPSV2, APPSV3
//  DBSV(Sequence Table)