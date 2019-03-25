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
@Table(name = "Planning")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planning.findAll", query = "SELECT p FROM Planning p")
    , @NamedQuery(name = "Planning.findByIdPlanning", query = "SELECT p FROM Planning p WHERE p.idPlanning = :idPlanning")
    , @NamedQuery(name = "Planning.findByHora", query = "SELECT p FROM Planning p WHERE p.hora = :hora")
    , @NamedQuery(name = "Planning.findByLunes", query = "SELECT p FROM Planning p WHERE p.lunes = :lunes")
    , @NamedQuery(name = "Planning.findByMartes", query = "SELECT p FROM Planning p WHERE p.martes = :martes")
    , @NamedQuery(name = "Planning.findByMiercoles", query = "SELECT p FROM Planning p WHERE p.miercoles = :miercoles")
    , @NamedQuery(name = "Planning.findByJueves", query = "SELECT p FROM Planning p WHERE p.jueves = :jueves")
    , @NamedQuery(name = "Planning.findByViernes", query = "SELECT p FROM Planning p WHERE p.viernes = :viernes")
    , @NamedQuery(name = "Planning.findBySabado", query = "SELECT p FROM Planning p WHERE p.sabado = :sabado")
    , @NamedQuery(name = "Planning.findByDomingo", query = "SELECT p FROM Planning p WHERE p.domingo = :domingo")})
public class Planning implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPlanning")
    private Integer idPlanning;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lunes")
    private String lunes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "martes")
    private String martes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "miercoles")
    private String miercoles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "jueves")
    private String jueves;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "viernes")
    private String viernes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sabado")
    private String sabado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "domingo")
    private String domingo;

    public Planning() {
    }

    public Planning(Integer idPlanning) {
        this.idPlanning = idPlanning;
    }

    public Planning(Integer idPlanning, String hora, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {
        this.idPlanning = idPlanning;
        this.hora = hora;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public Integer getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(Integer idPlanning) {
        this.idPlanning = idPlanning;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanning != null ? idPlanning.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.idPlanning == null && other.idPlanning != null) || (this.idPlanning != null && !this.idPlanning.equals(other.idPlanning))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Planning[ idPlanning=" + idPlanning + " ]";
    }
    
}
