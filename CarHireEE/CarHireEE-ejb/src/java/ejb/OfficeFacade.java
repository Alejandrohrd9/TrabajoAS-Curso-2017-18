/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Office;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandrohd
 */
@Stateless
public class OfficeFacade extends AbstractFacade<Office> {

    @PersistenceContext(unitName = "CarHireEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfficeFacade() {
        super(Office.class);
    }
    
    public List<Office> getOfficePagination(int id1, int id2){
        return em.createQuery("SELECT o FROM Office o WHERE o.idOffice BETWEEN :id1 AND :id2").setParameter("id1", id1).setParameter("id2", id2).getResultList();
    }
    
    public int getCountOfficePagination(){
        return em.createQuery("SELECT o FROM Office o").getResultList().size();
    }
    
}
