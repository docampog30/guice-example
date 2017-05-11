package co.com.david.guice.service;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.david.guice.model.User;
import co.com.david.guice.service.dao.GenericDAO;

import com.google.inject.persist.Transactional;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Singleton
public class UserService {

    private final GenericDAO<User> userDAO;

    @Inject
    public UserService(GenericDAO<User> userRepository) {
        this.userDAO = userRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userDAO.create(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userDAO.update(user);
    }

    @Transactional
    public User findById(UUID id) {
        return userDAO.findById(id);
    }

    @Transactional
    public List<User> findUsers() {
        return userDAO.findByCriteria(null);
    }

}
