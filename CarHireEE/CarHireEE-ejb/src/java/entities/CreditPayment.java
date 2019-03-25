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
@Table(name = "CreditPayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditPayment.findAll", query = "SELECT c FROM CreditPayment c")
    , @NamedQuery(name = "CreditPayment.findByIdCreditPayment", query = "SELECT c FROM CreditPayment c WHERE c.idCreditPayment = :idCreditPayment")
    , @NamedQuery(name = "CreditPayment.findByNumberCredit", query = "SELECT c FROM CreditPayment c WHERE c.numberCredit = :numberCredit")
    , @NamedQuery(name = "CreditPayment.findByDateCredit", query = "SELECT c FROM CreditPayment c WHERE c.dateCredit = :dateCredit")
    , @NamedQuery(name = "CreditPayment.findByTotalCredit", query = "SELECT c FROM CreditPayment c WHERE c.totalCredit = :totalCredit")})
public class CreditPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCreditPayment")
    private Integer idCreditPayment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numberCredit")
    private String numberCredit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dateCredit")
    private String dateCredit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "totalCredit")
    private String totalCredit;
    @JoinColumn(name = "idCarRent", referencedColumnName = "idRent")
    @ManyToOne(optional = false)
    private Rent idCarRent;

    public CreditPayment() {
    }

    public CreditPayment(Integer idCreditPayment) {
        this.idCreditPayment = idCreditPayment;
    }

    public CreditPayment(Integer idCreditPayment, String numberCredit, String dateCredit, String totalCredit) {
        this.idCreditPayment = idCreditPayment;
        this.numberCredit = numberCredit;
        this.dateCredit = dateCredit;
        this.totalCredit = totalCredit;
    }

    public Integer getIdCreditPayment() {
        return idCreditPayment;
    }

    public void setIdCreditPayment(Integer idCreditPayment) {
        this.idCreditPayment = idCreditPayment;
    }

    public String getNumberCredit() {
        return numberCredit;
    }

    public void setNumberCredit(String numberCredit) {
        this.numberCredit = numberCredit;
    }

    public String getDateCredit() {
        return dateCredit;
    }

    public void setDateCredit(String dateCredit) {
        this.dateCredit = dateCredit;
    }

    public String getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(String totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Rent getIdCarRent() {
        return idCarRent;
    }

    public void setIdCarRent(Rent idCarRent) {
        this.idCarRent = idCarRent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCreditPayment != null ? idCreditPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditPayment)) {
            return false;
        }
        CreditPayment other = (CreditPayment) object;
        if ((this.idCreditPayment == null && other.idCreditPayment != null) || (this.idCreditPayment != null && !this.idCreditPayment.equals(other.idCreditPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CreditPayment[ idCreditPayment=" + idCreditPayment + " ]";
    }
    
}
