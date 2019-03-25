/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Messages;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandrohd
 */
@Stateless
public class MessagesFacade extends AbstractFacade<Messages> {

    @PersistenceContext(unitName = "CarHireEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessagesFacade() {
        super(Messages.class);
    }

    public void insertMessages(String username, String message, String fecha) {
        String query = "INSERT INTO Messages (nameUser,textMessage,dateMessage) VALUES (?,?,?)";
        em.createNativeQuery(query).setParameter(1, username).setParameter(2, message).setParameter(3, fecha).executeUpdate();
    }
    
    public List<Messages> getMessageUser(String userName){
        return em.createQuery("SELECT m FROM Messages m WHERE m.nameUser LIKE CONCAT('%',:userName,'%')").setParameter("userName", userName).getResultList();
    }

}
