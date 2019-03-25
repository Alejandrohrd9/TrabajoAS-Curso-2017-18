/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.CashPayment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandrohd
 */
@Stateless
public class CashPaymentFacade extends AbstractFacade<CashPayment> {

    @PersistenceContext(unitName = "CarHireEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CashPaymentFacade() {
        super(CashPayment.class);
    }
    
}
