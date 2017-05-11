package co.com.david.guice.modules;

import co.com.david.guice.model.Role;
import co.com.david.guice.model.User;
import co.com.david.guice.service.dao.GenericDAO;
import co.com.david.guice.service.dao.JpaRoleDAO;
import co.com.david.guice.service.dao.JpaUserDAO;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class PersistenceModule extends AbstractModule {

    private final String persistenceUnit;

    public PersistenceModule(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    @Override
    protected void configure() {
        install(new JpaPersistModule(persistenceUnit));
        bind(JpaInitializer.class).asEagerSingleton();
        bind(new TypeLiteral<GenericDAO<User>>() {
        }).to(new TypeLiteral<JpaUserDAO>() {
        });
        bind(new TypeLiteral<GenericDAO<Role>>() {
        }).to(new TypeLiteral<JpaRoleDAO>() {
        });
    }
}
