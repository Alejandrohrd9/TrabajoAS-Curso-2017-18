/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Rent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandrohd
 */
@Stateless
public class RentFacade extends AbstractFacade<Rent> {

    @PersistenceContext(unitName = "CarHireEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentFacade() {
        super(Rent.class);
    }
    
    public Rent getValuesFromDNI(String dni){
        return (Rent) em.createNamedQuery("Rent.findByDniClient").setParameter("dniClient", dni).getSingleResult();
    }
    
}
