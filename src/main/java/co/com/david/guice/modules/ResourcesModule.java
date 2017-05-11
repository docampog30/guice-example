package co.com.david.guice.modules;

import co.com.david.guice.resources.UserResource;

import com.google.inject.AbstractModule;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
public class ResourcesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserResource.class);
    }
}
