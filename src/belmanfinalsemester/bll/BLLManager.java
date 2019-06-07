/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanfinalsemester.bll;

import belmanfinalsemester.be.Department;
import belmanfinalsemester.be.Order;
import belmanfinalsemester.dal.IDALFacade;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Test
 */
public class BLLManager implements IBLLFacade{
    
   // MockDALManager mcDalManager = new MockDALManager();
    private IDALFacade dalFacade;
    
    public BLLManager(IDALFacade dalFacade){
        this.dalFacade = dalFacade;
    }
    
    @Override
    public List<Order> getOrders (Department departmentName){
        LocalDate currentDate = LocalDate.now();
        List<Order> orders =  dalFacade.getOrders(departmentName,currentDate);
        for(Order o : orders){
            double progress = calculateProgress(o);
            o.setProgress(progress);
        }
        return orders;
    } 
    
    private double calculateProgress(Order order){
        if(LocalDate.now().isAfter(order.getEndDate())){
            return 1;
        }
        else if(LocalDate.now().isBefore(order.getStartDate())){
            return 0;
        }
        else{
            double currentDays = ChronoUnit.DAYS.between(order.getStartDate(), LocalDate.now());
            double totalDays = ChronoUnit.DAYS.between(order.getStartDate(), order.getEndDate());
            return currentDays/totalDays;
        }
    }
    
    @Override
    public List<Order> searchOrders(List<Order> allOrders, String key){
        List<Order> filteredList = new ArrayList();
        for(Order order: allOrders){
            if(order.getOrderNumber().substring(0, key.length()).equals(key)){
                filteredList.add(order);
            }
        }
        return filteredList;
    }
    
    @Override
    public List<Department> getDepartments() throws SQLException{
        return dalFacade.getDepartments();
    }
    
    @Override
     public void submitTask(Department dep, Order order) throws SQLServerException, SQLException {
         dalFacade.submitTask(dep, order);
     }
}
