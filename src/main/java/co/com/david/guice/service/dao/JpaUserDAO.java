package co.com.david.guice.service.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import co.com.david.guice.model.User;

import com.google.inject.persist.Transactional;


/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class JpaUserDAO extends JpaGenericDAO<User> {

    public JpaUserDAO() {
        super(User.class);
    }

    @Transactional
    public List<User> findByCriteria(User query) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
