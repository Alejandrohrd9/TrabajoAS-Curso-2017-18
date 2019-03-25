/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Car;
import entities.CarDetails;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author alejandrohd
 */
@Stateless
public class CarDetailsFacade extends AbstractFacade<CarDetails> {

    @PersistenceContext(unitName = "CarHireEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarDetailsFacade() {
        super(CarDetails.class);
    }

    public List<CarDetails> getCarFromId(int id) {
        return em.createQuery("SELECT c FROM CarDetails c WHERE c.idCarModel = :id").setParameter("id", id).getResultList();
    }

    public void deleteCar(int id) {
        CriteriaBuilder cB = em.getCriteriaBuilder();
        CriteriaDelete<CarDetails> cQ = cB.createCriteriaDelete(CarDetails.class);
        Root<CarDetails> carDetails = cQ.from(CarDetails.class);
        cQ.where(cB.equal(carDetails.get("idCar"), id));
        em.createQuery(cQ).executeUpdate();
    }
    
    public void updateCar(String licenseCar, int doors, BigDecimal price, int carDId){
        CriteriaBuilder cB = em.getCriteriaBuilder();
        CriteriaUpdate<CarDetails> cQ = cB.createCriteriaUpdate(CarDetails.class);
        Root<CarDetails> carDetails = cQ.from(CarDetails.class);
        cQ.set("licenseCar", licenseCar);
        cQ.set("doorsCar", doors);
        cQ.set("priceCar", price);
        cQ.where(cB.equal(carDetails.get("idCar"), carDId));
        
        em.createQuery(cQ).executeUpdate();
    }
}
