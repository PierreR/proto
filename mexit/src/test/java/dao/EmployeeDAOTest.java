package dao;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.matcher.Matchers;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.UnitOfWork;
import com.wideplay.warp.persist.jpa.JpaUnit;
import entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.*;

import static junit.framework.Assert.*;



/**
 * Date: Nov 18, 2009
 */
public class EmployeeDAOTest {

    private Injector injector;
    private EmployeeDAO dao;
    private EntityManager em;

    @Before
    public void pre() {
        injector = Guice.createInjector(PersistenceService.usingJpa()
                .across(UnitOfWork.TRANSACTION)
                .forAll(Matchers.any())
                .buildModule(),
                new AbstractModule() {
                    protected void configure() {
                        bindConstant().annotatedWith(JpaUnit.class).to("test");
                    }
                });
        injector.getInstance(PersistenceService.class)
                .start();

        dao = injector.getInstance(EmployeeDAO.class);
        em = injector.getInstance(EntityManager.class);

    }

    @After
    public final void post() {
        em.close();
    }


    @Test
    public void getEmployees() {
        Collection<Employee> employees = dao.getEmployees();
        assertFalse(employees.isEmpty());
    }
    @Test
    public void getByCompany() {
        Collection<Employee> employees = dao.getByCompany("Google");
        assertFalse(employees.isEmpty());
        Employee employee = employees.iterator().next();
        assertEquals("Sam", employee.getFirstName());
    }
}
