package web;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.UnitOfWork;
import com.wideplay.warp.persist.jpa.JpaUnit;
import flex.messaging.MessageBrokerServlet;

import java.util.*;

/**
 * Date: Nov 20, 2009
 */
public class ServletListener extends GuiceServletContextListener {
    static final String INJECTOR_NAME = Injector.class.getName();
    @Override
    protected Injector getInjector() {
        Injector injector = Guice.createInjector(PersistenceService.usingJpa()
                .across(UnitOfWork.REQUEST)
                .forAll(Matchers.inSubpackage("dao"))
                .buildModule(),
                new ServletModule() {
                    @Override
                    protected void configureServlets() {
                        super.configureServlets();
                        this.bind(MessageBrokerServlet.class).in(Scopes.SINGLETON);
                        this.serve("/messagebroker/*").with(MessageBrokerServlet.class);
                    }
                },
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        bindConstant().annotatedWith(JpaUnit.class).to("mexitdb");
                    }
                });

        injector.getInstance(PersistenceService.class).start();

        return injector;


    }
}