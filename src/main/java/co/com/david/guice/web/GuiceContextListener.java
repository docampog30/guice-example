package co.com.david.guice.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import lombok.extern.slf4j.Slf4j;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import co.com.david.guice.modules.PersistenceModule;
import co.com.david.guice.modules.ResourcesModule;

import com.google.inject.Module;


/**
 * Created by aurel.avramescu on 09/06/2014.
 */
@Slf4j
public class GuiceContextListener extends GuiceResteasyBootstrapServletContextListener {

    private final String persistenceUnit;

    public GuiceContextListener(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }


    /**
     * Override this method to instantiate your {@link com.google.inject.Module}s yourself.
     *
     * @param context
     * @return
     */
    protected List<? extends Module> getModules(final ServletContext context)
    {
        final List<Module> result = new ArrayList<Module>();
        result.add(new PersistenceModule(persistenceUnit));
        result.add(new ResourcesModule());
        return result;
    }
}

