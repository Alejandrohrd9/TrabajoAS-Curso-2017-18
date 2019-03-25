/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandrohd
 */
@Entity
@Table(name = "Car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
    , @NamedQuery(name = "Car.findByIdC", query = "SELECT c FROM Car c WHERE c.idC = :idC")
    , @NamedQuery(name = "Car.findByMarcaC", query = "SELECT c FROM Car c WHERE c.marcaC = :marcaC")
    , @NamedQuery(name = "Car.findByModelC", query = "SELECT c FROM Car c WHERE c.modelC = :modelC")
    , @NamedQuery(name = "Car.findByTypeC", query = "SELECT c FROM Car c WHERE c.typeC = :typeC")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idC")
    private Integer idC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marcaC")
    private String marcaC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelC")
    private String modelC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "typeC")
    private String typeC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarModel")
    private Collection<CarDetails> carDetailsCollection;

    public Car() {
    }

    public Car(Integer idC) {
        this.idC = idC;
    }

    public Car(Integer idC, String marcaC, String modelC, String typeC) {
        this.idC = idC;
        this.marcaC = marcaC;
        this.modelC = modelC;
        this.typeC = typeC;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public String getMarcaC() {
        return marcaC;
    }

    public void setMarcaC(String marcaC) {
        this.marcaC = marcaC;
    }

    public String getModelC() {
        return modelC;
    }

    public void setModelC(String modelC) {
        this.modelC = modelC;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    @XmlTransient
    public Collection<CarDetails> getCarDetailsCollection() {
        return carDetailsCollection;
    }

    public void setCarDetailsCollection(Collection<CarDetails> carDetailsCollection) {
        this.carDetailsCollection = carDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Car[ idC=" + idC + " ]";
    }
    
}
