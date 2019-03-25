/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CarDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarDetails.findAll", query = "SELECT c FROM CarDetails c")
    , @NamedQuery(name = "CarDetails.findByIdCar", query = "SELECT c FROM CarDetails c WHERE c.idCar = :idCar")
    , @NamedQuery(name = "CarDetails.findByLicenseCar", query = "SELECT c FROM CarDetails c WHERE c.licenseCar = :licenseCar")
    , @NamedQuery(name = "CarDetails.findByDoorsCar", query = "SELECT c FROM CarDetails c WHERE c.doorsCar = :doorsCar")
    , @NamedQuery(name = "CarDetails.findByPriceCar", query = "SELECT c FROM CarDetails c WHERE c.priceCar = :priceCar")})
public class CarDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCar")
    private Integer idCar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "licenseCar")
    private String licenseCar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doorsCar")
    private int doorsCar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceCar")
    private BigDecimal priceCar;
    @JoinColumn(name = "idCarModel", referencedColumnName = "idC")
    @ManyToOne(optional = false)
    private Car idCarModel;

    public CarDetails() {
    }

    public CarDetails(Integer idCar) {
        this.idCar = idCar;
    }

    public CarDetails(Integer idCar, String licenseCar, int doorsCar, BigDecimal priceCar) {
        this.idCar = idCar;
        this.licenseCar = licenseCar;
        this.doorsCar = doorsCar;
        this.priceCar = priceCar;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getLicenseCar() {
        return licenseCar;
    }

    public void setLicenseCar(String licenseCar) {
        this.licenseCar = licenseCar;
    }

    public int getDoorsCar() {
        return doorsCar;
    }

    public void setDoorsCar(int doorsCar) {
        this.doorsCar = doorsCar;
    }

    public BigDecimal getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(BigDecimal priceCar) {
        this.priceCar = priceCar;
    }

    public Car getIdCarModel() {
        return idCarModel;
    }

    public void setIdCarModel(Car idCarModel) {
        this.idCarModel = idCarModel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCar != null ? idCar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarDetails)) {
            return false;
        }
        CarDetails other = (CarDetails) object;
        if ((this.idCar == null && other.idCar != null) || (this.idCar != null && !this.idCar.equals(other.idCar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CarDetails[ idCar=" + idCar + " ]";
    }
    
}
