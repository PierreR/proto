package dao;


import com.google.inject.Inject;
import com.google.inject.Provider;
import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.Collection;

/**
 * Date: Nov 18, 2009
 */
public class _Employee {
    @Inject
    private Provider<EntityManager> em;

    
    public Collection<Employee> getEmployees() {

        Query q = em.get().createQuery("SELECT e FROM Employee e");

        Collection<Employee> resultList = q.getResultList();

        System.out.println(resultList);

        return resultList;


    }

    public Collection<Employee> getByCompany(String companyName)  {
        Query q = em.get().createQuery("select e from Employee e join e.company c where c.name='Google'");

        return q.getResultList();

    }
}
