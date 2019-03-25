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
@Table(name = "Distributor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distributor.findAll", query = "SELECT d FROM Distributor d")
    , @NamedQuery(name = "Distributor.findByIdDistributor", query = "SELECT d FROM Distributor d WHERE d.idDistributor = :idDistributor")
    , @NamedQuery(name = "Distributor.findByNameD", query = "SELECT d FROM Distributor d WHERE d.nameD = :nameD")
    , @NamedQuery(name = "Distributor.findByAddressD", query = "SELECT d FROM Distributor d WHERE d.addressD = :addressD")
    , @NamedQuery(name = "Distributor.findByCityD", query = "SELECT d FROM Distributor d WHERE d.cityD = :cityD")
    , @NamedQuery(name = "Distributor.findByPhoneD", query = "SELECT d FROM Distributor d WHERE d.phoneD = :phoneD")
    , @NamedQuery(name = "Distributor.findByUrlD", query = "SELECT d FROM Distributor d WHERE d.urlD = :urlD")})
public class Distributor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDistributor")
    private Integer idDistributor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameD")
    private String nameD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "addressD")
    private String addressD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cityD")
    private String cityD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phoneD")
    private String phoneD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "urlD")
    private String urlD;

    public Distributor() {
    }

    public Distributor(Integer idDistributor) {
        this.idDistributor = idDistributor;
    }

    public Distributor(Integer idDistributor, String nameD, String addressD, String cityD, String phoneD, String urlD) {
        this.idDistributor = idDistributor;
        this.nameD = nameD;
        this.addressD = addressD;
        this.cityD = cityD;
        this.phoneD = phoneD;
        this.urlD = urlD;
    }

    public Integer getIdDistributor() {
        return idDistributor;
    }

    public void setIdDistributor(Integer idDistributor) {
        this.idDistributor = idDistributor;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public String getAddressD() {
        return addressD;
    }

    public void setAddressD(String addressD) {
        this.addressD = addressD;
    }

    public String getCityD() {
        return cityD;
    }

    public void setCityD(String cityD) {
        this.cityD = cityD;
    }

    public String getPhoneD() {
        return phoneD;
    }

    public void setPhoneD(String phoneD) {
        this.phoneD = phoneD;
    }

    public String getUrlD() {
        return urlD;
    }

    public void setUrlD(String urlD) {
        this.urlD = urlD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistributor != null ? idDistributor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distributor)) {
            return false;
        }
        Distributor other = (Distributor) object;
        if ((this.idDistributor == null && other.idDistributor != null) || (this.idDistributor != null && !this.idDistributor.equals(other.idDistributor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Distributor[ idDistributor=" + idDistributor + " ]";
    }
    
}
