/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanfinalsemester.bll;

import belmanfinalsemester.be.Department;
import belmanfinalsemester.be.Order;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Test
 */
public interface IBLLFacade {
        List<Order> getOrders (Department departmentName);
        
        List<Order> searchOrders(List<Order> allOrders, String key);
        
        List<Department> getDepartments() throws SQLException;
        
        void submitTask(Department dep, Order order) throws SQLServerException, SQLException;
}
