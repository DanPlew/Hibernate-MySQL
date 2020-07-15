package Session;

import Models.Writer;

import javax.persistence.*;
import java.util.List;

public class WritersTranzaction implements DataBaseActions<Writer> {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public WritersTranzaction(){
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void add(Writer writer) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(writer);
        entityTransaction.commit();
    }

    @Override
    public void delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Writer writer = find(id);
        entityManager.remove(writer);

        entityTransaction.commit();
    }

    @Override
    public Writer find(Long id) {
        return entityManager.find(Writer.class, id);
    }

    @Override
    public List<Writer> findAll() {
        Query query = entityManager.createQuery("select a from Writer a", Writer.class);
        return query.getResultList();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
