/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandrohd
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "Users.findByNameUser", query = "SELECT u FROM Users u WHERE u.nameUser = :nameUser")
    , @NamedQuery(name = "Users.findBySurnameUser", query = "SELECT u FROM Users u WHERE u.surnameUser = :surnameUser")
    , @NamedQuery(name = "Users.findByUsernameUser", query = "SELECT u FROM Users u WHERE u.usernameUser = :usernameUser")
    , @NamedQuery(name = "Users.findByPasswordUser", query = "SELECT u FROM Users u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "Users.findByTypeUser", query = "SELECT u FROM Users u WHERE u.typeUser = :typeUser")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameUser")
    private String nameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surnameUser")
    private String surnameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usernameUser")
    private String usernameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "passwordUser")
    private String passwordUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "typeUser")
    private String typeUser;

    public Users() {
    }

    public Users(Integer idUser) {
        this.idUser = idUser;
    }

    public Users(Integer idUser, String nameUser, String surnameUser, String usernameUser, String passwordUser, String typeUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.surnameUser = surnameUser;
        this.usernameUser = usernameUser;
        this.passwordUser = passwordUser;
        this.typeUser = typeUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getSurnameUser() {
        return surnameUser;
    }

    public void setSurnameUser(String surnameUser) {
        this.surnameUser = surnameUser;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ idUser=" + idUser + " ]";
    }
    
}
