/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanfinalsemester.bll;

import belmanfinalsemester.dal.DALFacadeFactory;
import belmanfinalsemester.dal.IDALFacade;

/**
 *
 * @author Test
 */
public class BLLFacadeFactory {
    
    private IDALFacade dalFacade ;
    
    public enum FacadeType {
        PRODUCTION;
    }
    
    private static BLLFacadeFactory instance;
    
    private BLLFacadeFactory(){
        dalFacade = DALFacadeFactory.getInstance().createFacade(DALFacadeFactory.FacadeType.DATABASE);
    }
    
    public static synchronized BLLFacadeFactory getInstance(){
        if (instance == null){
            instance = new BLLFacadeFactory();
        }
        return instance;
    }
    
    public IBLLFacade createFacade (FacadeType type){
        switch(type){
            case PRODUCTION:
                return new BLLManager(dalFacade);
          
            default:
                return new BLLManager(dalFacade);
       }
        
    }
}
