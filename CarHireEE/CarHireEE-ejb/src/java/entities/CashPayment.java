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
@Table(name = "CashPayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CashPayment.findAll", query = "SELECT c FROM CashPayment c")
    , @NamedQuery(name = "CashPayment.findByIdCashPayment", query = "SELECT c FROM CashPayment c WHERE c.idCashPayment = :idCashPayment")
    , @NamedQuery(name = "CashPayment.findByTotalCost", query = "SELECT c FROM CashPayment c WHERE c.totalCost = :totalCost")
    , @NamedQuery(name = "CashPayment.findByPaidOut", query = "SELECT c FROM CashPayment c WHERE c.paidOut = :paidOut")
    , @NamedQuery(name = "CashPayment.findByReturned", query = "SELECT c FROM CashPayment c WHERE c.returned = :returned")})
public class CashPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCashPayment")
    private Integer idCashPayment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "totalCost")
    private String totalCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "paidOut")
    private String paidOut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "returned")
    private String returned;
    @JoinColumn(name = "idRentCar", referencedColumnName = "idRent")
    @ManyToOne(optional = false)
    private Rent idRentCar;

    public CashPayment() {
    }

    public CashPayment(Integer idCashPayment) {
        this.idCashPayment = idCashPayment;
    }

    public CashPayment(Integer idCashPayment, String totalCost, String paidOut, String returned) {
        this.idCashPayment = idCashPayment;
        this.totalCost = totalCost;
        this.paidOut = paidOut;
        this.returned = returned;
    }

    public Integer getIdCashPayment() {
        return idCashPayment;
    }

    public void setIdCashPayment(Integer idCashPayment) {
        this.idCashPayment = idCashPayment;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaidOut() {
        return paidOut;
    }

    public void setPaidOut(String paidOut) {
        this.paidOut = paidOut;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public Rent getIdRentCar() {
        return idRentCar;
    }

    public void setIdRentCar(Rent idRentCar) {
        this.idRentCar = idRentCar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCashPayment != null ? idCashPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashPayment)) {
            return false;
        }
        CashPayment other = (CashPayment) object;
        if ((this.idCashPayment == null && other.idCashPayment != null) || (this.idCashPayment != null && !this.idCashPayment.equals(other.idCashPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CashPayment[ idCashPayment=" + idCashPayment + " ]";
    }
    
}
