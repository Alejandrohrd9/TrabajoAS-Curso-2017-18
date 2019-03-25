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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Rent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rent.findAll", query = "SELECT r FROM Rent r")
    , @NamedQuery(name = "Rent.findByIdRent", query = "SELECT r FROM Rent r WHERE r.idRent = :idRent")
    , @NamedQuery(name = "Rent.findByComercial", query = "SELECT r FROM Rent r WHERE r.comercial = :comercial")
    , @NamedQuery(name = "Rent.findByNameClient", query = "SELECT r FROM Rent r WHERE r.nameClient = :nameClient")
    , @NamedQuery(name = "Rent.findByAddressClient", query = "SELECT r FROM Rent r WHERE r.addressClient = :addressClient")
    , @NamedQuery(name = "Rent.findByDniClient", query = "SELECT r FROM Rent r WHERE r.dniClient = :dniClient")
    , @NamedQuery(name = "Rent.findByBornClient", query = "SELECT r FROM Rent r WHERE r.bornClient = :bornClient")
    , @NamedQuery(name = "Rent.findByLicenseClient", query = "SELECT r FROM Rent r WHERE r.licenseClient = :licenseClient")
    , @NamedQuery(name = "Rent.findByCarClient", query = "SELECT r FROM Rent r WHERE r.carClient = :carClient")
    , @NamedQuery(name = "Rent.findByDays", query = "SELECT r FROM Rent r WHERE r.days = :days")
    , @NamedQuery(name = "Rent.findByWayToPay", query = "SELECT r FROM Rent r WHERE r.wayToPay = :wayToPay")})
public class Rent implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRentCar")
    private Collection<CashPayment> cashPaymentCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRent")
    private Integer idRent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comercial")
    private String comercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nameClient")
    private String nameClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "addressClient")
    private String addressClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dniClient")
    private String dniClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bornClient")
    private String bornClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "licenseClient")
    private String licenseClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "carClient")
    private String carClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "days")
    private String days;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "wayToPay")
    private String wayToPay;

    public Rent() {
    }

    public Rent(Integer idRent) {
        this.idRent = idRent;
    }

    public Rent(Integer idRent, String comercial, String nameClient, String addressClient, String dniClient, String bornClient, String licenseClient, String carClient, String days, String wayToPay) {
        this.idRent = idRent;
        this.comercial = comercial;
        this.nameClient = nameClient;
        this.addressClient = addressClient;
        this.dniClient = dniClient;
        this.bornClient = bornClient;
        this.licenseClient = licenseClient;
        this.carClient = carClient;
        this.days = days;
        this.wayToPay = wayToPay;
    }

    public Integer getIdRent() {
        return idRent;
    }

    public void setIdRent(Integer idRent) {
        this.idRent = idRent;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public String getBornClient() {
        return bornClient;
    }

    public void setBornClient(String bornClient) {
        this.bornClient = bornClient;
    }

    public String getLicenseClient() {
        return licenseClient;
    }

    public void setLicenseClient(String licenseClient) {
        this.licenseClient = licenseClient;
    }

    public String getCarClient() {
        return carClient;
    }

    public void setCarClient(String carClient) {
        this.carClient = carClient;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getWayToPay() {
        return wayToPay;
    }

    public void setWayToPay(String wayToPay) {
        this.wayToPay = wayToPay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRent != null ? idRent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rent)) {
            return false;
        }
        Rent other = (Rent) object;
        if ((this.idRent == null && other.idRent != null) || (this.idRent != null && !this.idRent.equals(other.idRent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Rent[ idRent=" + idRent + " ]";
    }

    @XmlTransient
    public Collection<CashPayment> getCashPaymentCollection() {
        return cashPaymentCollection;
    }

    public void setCashPaymentCollection(Collection<CashPayment> cashPaymentCollection) {
        this.cashPaymentCollection = cashPaymentCollection;
    }
    
}
