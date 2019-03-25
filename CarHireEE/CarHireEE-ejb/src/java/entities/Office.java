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
@Table(name = "Office")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o")
    , @NamedQuery(name = "Office.findByIdOffice", query = "SELECT o FROM Office o WHERE o.idOffice = :idOffice")
    , @NamedQuery(name = "Office.findByNameOffice", query = "SELECT o FROM Office o WHERE o.nameOffice = :nameOffice")
    , @NamedQuery(name = "Office.findByStreetOffice", query = "SELECT o FROM Office o WHERE o.streetOffice = :streetOffice")
    , @NamedQuery(name = "Office.findByNumberOffice", query = "SELECT o FROM Office o WHERE o.numberOffice = :numberOffice")
    , @NamedQuery(name = "Office.findByCityOffice", query = "SELECT o FROM Office o WHERE o.cityOffice = :cityOffice")
    , @NamedQuery(name = "Office.findByStateOffice", query = "SELECT o FROM Office o WHERE o.stateOffice = :stateOffice")
    , @NamedQuery(name = "Office.findByTf1Office", query = "SELECT o FROM Office o WHERE o.tf1Office = :tf1Office")
    , @NamedQuery(name = "Office.findByTf2Office", query = "SELECT o FROM Office o WHERE o.tf2Office = :tf2Office")})
public class Office implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOffice")
    private Integer idOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameOffice")
    private String nameOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "streetOffice")
    private String streetOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numberOffice")
    private String numberOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cityOffice")
    private String cityOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "stateOffice")
    private String stateOffice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tf1Office")
    private int tf1Office;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tf2Office")
    private int tf2Office;

    public Office() {
    }

    public Office(Integer idOffice) {
        this.idOffice = idOffice;
    }

    public Office(Integer idOffice, String nameOffice, String streetOffice, String numberOffice, String cityOffice, String stateOffice, int tf1Office, int tf2Office) {
        this.idOffice = idOffice;
        this.nameOffice = nameOffice;
        this.streetOffice = streetOffice;
        this.numberOffice = numberOffice;
        this.cityOffice = cityOffice;
        this.stateOffice = stateOffice;
        this.tf1Office = tf1Office;
        this.tf2Office = tf2Office;
    }

    public Integer getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Integer idOffice) {
        this.idOffice = idOffice;
    }

    public String getNameOffice() {
        return nameOffice;
    }

    public void setNameOffice(String nameOffice) {
        this.nameOffice = nameOffice;
    }

    public String getStreetOffice() {
        return streetOffice;
    }

    public void setStreetOffice(String streetOffice) {
        this.streetOffice = streetOffice;
    }

    public String getNumberOffice() {
        return numberOffice;
    }

    public void setNumberOffice(String numberOffice) {
        this.numberOffice = numberOffice;
    }

    public String getCityOffice() {
        return cityOffice;
    }

    public void setCityOffice(String cityOffice) {
        this.cityOffice = cityOffice;
    }

    public String getStateOffice() {
        return stateOffice;
    }

    public void setStateOffice(String stateOffice) {
        this.stateOffice = stateOffice;
    }

    public int getTf1Office() {
        return tf1Office;
    }

    public void setTf1Office(int tf1Office) {
        this.tf1Office = tf1Office;
    }

    public int getTf2Office() {
        return tf2Office;
    }

    public void setTf2Office(int tf2Office) {
        this.tf2Office = tf2Office;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffice != null ? idOffice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.idOffice == null && other.idOffice != null) || (this.idOffice != null && !this.idOffice.equals(other.idOffice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Office[ idOffice=" + idOffice + " ]";
    }
    
}
