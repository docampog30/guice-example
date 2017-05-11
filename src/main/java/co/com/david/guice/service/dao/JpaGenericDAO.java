package co.com.david.guice.service.dao;

import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.inject.persist.Transactional;

/**
 * Created by aurel.avramescu on 17/06/2014.
 */
public abstract class JpaGenericDAO<E> implements GenericDAO<E> {

    @Inject
    protected EntityManager entityManager;

    private final Class<E> clazz;

    public JpaGenericDAO(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Transactional
    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public E update(E entity) {
        return entity;
    }

    @Transactional
    public E findById(UUID id) {
        return entityManager.find(clazz, id);
    }

    @Transactional
    public void delete(E entity) {
        entityManager.remove(entity);
    }
}
