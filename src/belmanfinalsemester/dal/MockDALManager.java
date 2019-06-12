/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanfinalsemester.dal;

import belmanfinalsemester.be.Department;
import belmanfinalsemester.be.Order;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MockDALManager
 */
public class MockDALManager implements IDALFacade{
    private List<Order> orderInfo;   

    @Override
    public List<Order> getOrders(Department departmentName, LocalDate currentDate) {
        Order o1 = new Order();
        o1.setOrderNumber("500-100-200-01");
        o1.setStartDate(LocalDate.now().minusDays(5));
        o1.setEndDate(LocalDate.now().plusDays(3));
        o1.setDaysLeft(3); 
        o1.setCustomerName("Christiano Ronaldo");
        
        
        Order o2 = new Order();
        o2.setOrderNumber("500-100-200-02");
        o2.setStartDate(LocalDate.now().minusDays(7));
        o2.setEndDate(LocalDate.now().plusDays(2));
        o2.setDaysLeft(2);
        o2.setCustomerName("David Beckham");

         ArrayList<Order> list1 = new ArrayList();
         list1.add(o1);
         list1.add(o2);
         return list1;
    }

    @Override
    public List<Department> getDepartments() throws SQLException {
        Department d1 = new Department();
        d1.setDeptID(1);
        d1.setDeptName("Halvfab");
        
        Department d2 = new Department();
        d2.setDeptID(2);
        d2.setDeptName("Montage 1");
        
        ArrayList<Department> list2 = new ArrayList();
        list2.add(d1);
        list2.add(d2);
        return list2;
    }

    @Override
    public void submitTask(Department dep, Order order) throws SQLServerException, SQLException {
         
    }
}
