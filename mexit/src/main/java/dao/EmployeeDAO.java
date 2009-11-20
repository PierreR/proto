package dao;


import com.google.inject.Inject;
import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.Collection;
import java.util.List;

/**
 * Date: Nov 18, 2009
 */
public class EmployeeDAO {
    @Inject
    private EntityManager em;

    
    public Collection<Employee> getEmployees() {

        Query q = em.createQuery("SELECT e FROM Employee e");

        Collection<Employee> resultList = q.getResultList();

        System.out.println(resultList);

        return resultList;


    }

    public Collection<Employee> getByCompany(String companyName)  {
        Query q = em.createQuery("select e from Employee e join e.company c where c.name='Google'");

        return q.getResultList();

    }
}
