package Session;

import Models.books;

import javax.persistence.*;
import java.util.List;

public class BooksTranzaction implements DataBaseActions<books> {

    private  EntityManagerFactory emFactory;
    private  EntityManager entityManager;

    public BooksTranzaction(){
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    public void add(books book) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        books book = find(id);
        entityManager.remove(book);

        entityTransaction.commit();
    }

    public books find(Long id) {
        return entityManager.find(books.class, id);
    }

    public List<books> findAll() {
        Query query = entityManager.createQuery("select a from books a", books.class);
        return query.getResultList();
    }

    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
