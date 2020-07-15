package Session;

import Models.users;

import javax.persistence.*;
import java.util.List;

public class UsersTranzaction implements DataBaseActions<users> {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public UsersTranzaction(){
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void add(users users) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(users);
        entityTransaction.commit();
    }

    @Override
    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        users user = find(id);
        entityManager.remove(user);

        entityTransaction.commit();
    }

    @Override
    public users find(Long id) {
        return entityManager.find(users.class, id);
    }

    @Override
    public List<users> findAll() {
        Query query = entityManager.createQuery("select a from users a", users.class);
        return query.getResultList();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
/*
package Session;

import Models.users;

import javax.persistence.*;
import java.util.List;

public class UsersTranzanction implements DataBaseActions<users> {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public UsersTranzanction(){
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    public void add(users users) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(users);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        users user = find(id);
        entityManager.remove(user);

        entityTransaction.commit();
    }

    public users find(Long id) {
        return entityManager.find(users.class, id);
    }

    public List<users> findAll() {
        Query query = entityManager.createQuery("select a from users a", users.class);
        return query.getResultList();
    }

    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
 */