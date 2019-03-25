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
@Table(name = "Messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m")
    , @NamedQuery(name = "Messages.findByIdMessages", query = "SELECT m FROM Messages m WHERE m.idMessages = :idMessages")
    , @NamedQuery(name = "Messages.findByNameUser", query = "SELECT m FROM Messages m WHERE m.nameUser = :nameUser")
    , @NamedQuery(name = "Messages.findByTextMessage", query = "SELECT m FROM Messages m WHERE m.textMessage = :textMessage")
    , @NamedQuery(name = "Messages.findByDateMessage", query = "SELECT m FROM Messages m WHERE m.dateMessage = :dateMessage")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMessages")
    private Integer idMessages;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameUser")
    private String nameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "textMessage")
    private String textMessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dateMessage")
    private String dateMessage;

    public Messages() {
    }

    public Messages(Integer idMessages) {
        this.idMessages = idMessages;
    }

    public Messages(Integer idMessages, String nameUser, String textMessage, String dateMessage) {
        this.idMessages = idMessages;
        this.nameUser = nameUser;
        this.textMessage = textMessage;
        this.dateMessage = dateMessage;
    }

    public Integer getIdMessages() {
        return idMessages;
    }

    public void setIdMessages(Integer idMessages) {
        this.idMessages = idMessages;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessages != null ? idMessages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.idMessages == null && other.idMessages != null) || (this.idMessages != null && !this.idMessages.equals(other.idMessages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Messages[ idMessages=" + idMessages + " ]";
    }
    
}
