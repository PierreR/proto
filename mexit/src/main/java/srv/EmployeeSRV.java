package srv;


import com.google.inject.Inject;
import dao.EmployeeDAO;
import entity.Employee;


import java.util.Collection;

/**
 * The service layer : should roughly match user stories
 * Date: Nov 18, 2009
 */
public class EmployeeSRV {

    @Inject
    EmployeeDAO dao;

    public Collection<Employee> listAll() {
        return dao.listAll();
    }

    public Collection<Employee> findByCompanyName(String name) {
        return dao.findByCompanyName(name);
    }
}
