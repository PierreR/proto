package dao;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.UnitOfWork;
import com.wideplay.warp.persist.jpa.JpaUnit;
import entity.Employee;
import org.junit.Before;
import org.junit.Test;
import dao.EmployeeDAO;
import srv.EmployeeSRV;
import java.util.*;

import static junit.framework.Assert.*;



/**
 * Date: Nov 18, 2009
 */
public class EmployeeDAOTest {

    private Injector injector;
    private EmployeeSRV srv;

    @Before
    public void pre() {
        injector = Guice.createInjector(PersistenceService.usingJpa()
                .across(UnitOfWork.TRANSACTION)
                .addAccessor(EmployeeDAO.class)
                .buildModule(),
                new AbstractModule() {
                    protected void configure() {
                        bindConstant().annotatedWith(JpaUnit.class).to("test");
                    }
                });

        injector.getInstance(PersistenceService.class)
                .start();

        srv = injector.getInstance(EmployeeSRV.class);

    }


    @Test
    public void getEmployees() {
        Collection<entity.Employee> employees = srv.listAll();
        assertFalse(employees.isEmpty());
    }
    @Test
    public void getByCompany() {
        Collection<Employee> employees = srv.findByCompanyName("Google");
        assertFalse(employees.isEmpty());            
        assertEquals("Sam", employees.iterator().next().getFirstName());
    }
}
