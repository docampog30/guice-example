package co.com.david.guice.service.dao;

import java.util.List;
import java.util.UUID;

public interface GenericDAO<E> {

    E create(E entity);

    E update(E entity);

    E findById(UUID id);

    void delete(E entity);

    List<E> findByCriteria(E query);
}
