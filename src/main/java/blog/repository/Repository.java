package blog.repository;

import java.util.List;

public interface Repository<E> {
    List<E> findAll();

    E findById(int id);

    void save(E model);

    void remove(int id);
}
