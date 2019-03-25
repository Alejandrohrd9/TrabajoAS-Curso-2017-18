/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.OnlineRent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandrohd
 */
@Stateless
public class OnlineRentFacade extends AbstractFacade<OnlineRent> {

    @PersistenceContext(unitName = "CarHireEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OnlineRentFacade() {
        super(OnlineRent.class);
    }
    
}
