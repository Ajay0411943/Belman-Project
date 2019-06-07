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
import java.util.List;

/**
 *
 * @author Test
 */
public interface IDALFacade {
    
    List<Department> getDepartments()throws SQLException;
    
    List<Order> getOrders(Department departmentName, LocalDate currentDate);
    
    void submitTask(Department dep, Order order)throws SQLServerException, SQLException;
    
}
