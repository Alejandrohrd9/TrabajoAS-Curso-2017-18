/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author alejandrohd
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "CarHireEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    public List<Users> findWithUserPassword(String userName, String password) {
        return em.createQuery("SELECT u FROM Users u WHERE u.usernameUser LIKE :username AND u.passwordUser LIKE :password").setParameter("username", userName).setParameter("password", password).getResultList();
    }

    public List<Users> findAllUsers() {
        em.flush();
        return em.createQuery("SELECT u FROM Users u").getResultList();
    }

    public String getTypeUser(String userName, String password) {
        return em.createQuery("SELECT u.typeUser FROM Users u WHERE u.usernameUser = :username AND u.passwordUser = :password").setParameter("username", userName).setParameter("password", password).getSingleResult().toString();
    }

    public void deleteUser(String username) {
        em.createQuery("DELETE FROM Users u WHERE u.usernameUser LIKE :username").setParameter("username", username).executeUpdate();
    }

    public List<Users> findWithUser(String userName) {
        return em.createQuery("SELECT u FROM Users u WHERE u.usernameUser LIKE :username").setParameter("username", userName).getResultList();
    }

    public List<Users> findWithId(int id) {
        return em.createQuery("SELECT u FROM Users u WHERE u.idUser =:id").setParameter("id", id).getResultList();
    }

    public void updateUser(String name, String surname, String username, String password, String type, int id) {
        em.createQuery("UPDATE Users u SET u.nameUser = :name, u.surnameUser = :surname, u.usernameUser = :username, u.passwordUser = :password, u.typeUser = :type  WHERE u.idUser LIKE :id")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("username", username)
                .setParameter("password", password)
                .setParameter("type", type)
                .executeUpdate();
    }

    public List<Users> getAllUserOrder() {
        CriteriaBuilder cB = em.getCriteriaBuilder();
        CriteriaQuery<Users> cQ = cB.createQuery(Users.class);
        Root<Users> user = cQ.from(Users.class);
        cQ.select(user);
        cQ.orderBy(cB.asc(user.get("nameUser")));
        return em.createQuery(cQ).getResultList();
    }

    public List<Users> getAllUserOrderDesc() {
        return em.createQuery("SELECT u FROM Users u ORDER BY u.nameUser DESC").getResultList();
    }

    public List<Users> getAllUserType(String type) {
        CriteriaBuilder cB = em.getCriteriaBuilder();
        CriteriaQuery<Users> cQ = cB.createQuery(Users.class);
        Root<Users> user = cQ.from(Users.class);
        cQ.select(user);
        cQ.where(cB.like(user.get("typeUser"), "%" + type + "%"));

        return em.createQuery(cQ).getResultList();
    }

    public void insertUser(String name, String surname, String username, String password, String type) {
        String insertQuery = "INSERT INTO Users (nameUser,surnameUser,usernameUser,passwordUser,typeUser) VALUES (?,?,?,?,?)";
        em.createNativeQuery(insertQuery).setParameter(1, name).setParameter(2, surname).setParameter(3, username).setParameter(4, password).setParameter(5, type).executeUpdate();
    }

}
