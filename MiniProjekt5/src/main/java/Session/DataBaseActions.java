package Session;

import java.util.List;

public interface DataBaseActions<T>{
    void add(T t);
    void delete(Long id);
    T find(Long id);
    List<T> findAll();
    void cleanUp();
}
