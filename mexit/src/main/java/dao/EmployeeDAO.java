package dao;

import com.google.inject.name.Named;
import com.wideplay.warp.persist.dao.Finder;
import entity.Employee;

import java.util.Collection;

/**
 * Here will be listed all queries on one specific entity
 * 
 * Date: Nov 23, 2009
 */
public interface EmployeeDAO {

    @Finder(query="from Employee")
    public Collection<Employee> listAll();

    @Finder(query="select e from Employee e join e.company c where c.name=:companyName")
    public Collection<Employee> findByCompanyName(@Named("companyName") String name);
}

