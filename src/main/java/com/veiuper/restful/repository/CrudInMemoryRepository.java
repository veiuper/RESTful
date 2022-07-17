package com.veiuper.restful.repository;

import java.util.List;
import java.util.Optional;

public interface CrudInMemoryRepository<T> {
    void save(T t);
    boolean save(T t, long id);
    List<T> findAll();
    Optional<T> findById(long id);
    boolean deleteById(long id);
}
