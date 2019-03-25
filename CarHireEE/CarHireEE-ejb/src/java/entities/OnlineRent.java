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
@Table(name = "OnlineRent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OnlineRent.findAll", query = "SELECT o FROM OnlineRent o")
    , @NamedQuery(name = "OnlineRent.findByIdOnlineRent", query = "SELECT o FROM OnlineRent o WHERE o.idOnlineRent = :idOnlineRent")
    , @NamedQuery(name = "OnlineRent.findByNameClient", query = "SELECT o FROM OnlineRent o WHERE o.nameClient = :nameClient")
    , @NamedQuery(name = "OnlineRent.findBySurnameClient", query = "SELECT o FROM OnlineRent o WHERE o.surnameClient = :surnameClient")
    , @NamedQuery(name = "OnlineRent.findByDniClient", query = "SELECT o FROM OnlineRent o WHERE o.dniClient = :dniClient")
    , @NamedQuery(name = "OnlineRent.findByAddressClient", query = "SELECT o FROM OnlineRent o WHERE o.addressClient = :addressClient")
    , @NamedQuery(name = "OnlineRent.findByCityClient", query = "SELECT o FROM OnlineRent o WHERE o.cityClient = :cityClient")
    , @NamedQuery(name = "OnlineRent.findByPhoneNumber", query = "SELECT o FROM OnlineRent o WHERE o.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "OnlineRent.findByDateStart", query = "SELECT o FROM OnlineRent o WHERE o.dateStart = :dateStart")
    , @NamedQuery(name = "OnlineRent.findByDateFinish", query = "SELECT o FROM OnlineRent o WHERE o.dateFinish = :dateFinish")
    , @NamedQuery(name = "OnlineRent.findByReservationCity", query = "SELECT o FROM OnlineRent o WHERE o.reservationCity = :reservationCity")
    , @NamedQuery(name = "OnlineRent.findByCarReservation", query = "SELECT o FROM OnlineRent o WHERE o.carReservation = :carReservation")
    , @NamedQuery(name = "OnlineRent.findByDaysReservation", query = "SELECT o FROM OnlineRent o WHERE o.daysReservation = :daysReservation")
    , @NamedQuery(name = "OnlineRent.findByPriceReservation", query = "SELECT o FROM OnlineRent o WHERE o.priceReservation = :priceReservation")})
public class OnlineRent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOnlineRent")
    private Integer idOnlineRent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameClient")
    private String nameClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surnameClient")
    private String surnameClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dniClient")
    private String dniClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "addressClient")
    private String addressClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cityClient")
    private String cityClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dateStart")
    private String dateStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dateFinish")
    private String dateFinish;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reservationCity")
    private String reservationCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "carReservation")
    private String carReservation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "daysReservation")
    private int daysReservation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "priceReservation")
    private String priceReservation;

    public OnlineRent() {
    }

    public OnlineRent(Integer idOnlineRent) {
        this.idOnlineRent = idOnlineRent;
    }

    public OnlineRent(Integer idOnlineRent, String nameClient, String surnameClient, String dniClient, String addressClient, String cityClient, String phoneNumber, String dateStart, String dateFinish, String reservationCity, String carReservation, int daysReservation, String priceReservation) {
        this.idOnlineRent = idOnlineRent;
        this.nameClient = nameClient;
        this.surnameClient = surnameClient;
        this.dniClient = dniClient;
        this.addressClient = addressClient;
        this.cityClient = cityClient;
        this.phoneNumber = phoneNumber;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.reservationCity = reservationCity;
        this.carReservation = carReservation;
        this.daysReservation = daysReservation;
        this.priceReservation = priceReservation;
    }

    public Integer getIdOnlineRent() {
        return idOnlineRent;
    }

    public void setIdOnlineRent(Integer idOnlineRent) {
        this.idOnlineRent = idOnlineRent;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public String getCityClient() {
        return cityClient;
    }

    public void setCityClient(String cityClient) {
        this.cityClient = cityClient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getReservationCity() {
        return reservationCity;
    }

    public void setReservationCity(String reservationCity) {
        this.reservationCity = reservationCity;
    }

    public String getCarReservation() {
        return carReservation;
    }

    public void setCarReservation(String carReservation) {
        this.carReservation = carReservation;
    }

    public int getDaysReservation() {
        return daysReservation;
    }

    public void setDaysReservation(int daysReservation) {
        this.daysReservation = daysReservation;
    }

    public String getPriceReservation() {
        return priceReservation;
    }

    public void setPriceReservation(String priceReservation) {
        this.priceReservation = priceReservation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOnlineRent != null ? idOnlineRent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnlineRent)) {
            return false;
        }
        OnlineRent other = (OnlineRent) object;
        if ((this.idOnlineRent == null && other.idOnlineRent != null) || (this.idOnlineRent != null && !this.idOnlineRent.equals(other.idOnlineRent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OnlineRent[ idOnlineRent=" + idOnlineRent + " ]";
    }
    
}
