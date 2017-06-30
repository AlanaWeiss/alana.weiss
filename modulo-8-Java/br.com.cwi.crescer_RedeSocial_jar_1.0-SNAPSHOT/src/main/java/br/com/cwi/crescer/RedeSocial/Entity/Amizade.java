/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.RedeSocial.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alana'
 */
@Entity
@Table(name = "AMIZADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amizade.findAll", query = "SELECT a FROM Amizade a")
    , @NamedQuery(name = "Amizade.findByIdamizade", query = "SELECT a FROM Amizade a WHERE a.idamizade = :idamizade")
    , @NamedQuery(name = "Amizade.findByStatus", query = "SELECT a FROM Amizade a WHERE a.status = :status")})
public class Amizade implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAMIZADE")
    private BigDecimal idamizade;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "IDSOLICITANTE", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idsolicitante;
    @JoinColumn(name = "IDSOLICITADO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idsolicitado;

    public Amizade() {
    }

    public Amizade(BigDecimal idamizade) {
        this.idamizade = idamizade;
    }

    public BigDecimal getIdamizade() {
        return idamizade;
    }

    public void setIdamizade(BigDecimal idamizade) {
        this.idamizade = idamizade;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Usuario getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(Usuario idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public Usuario getIdsolicitado() {
        return idsolicitado;
    }

    public void setIdsolicitado(Usuario idsolicitado) {
        this.idsolicitado = idsolicitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idamizade != null ? idamizade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizade)) {
            return false;
        }
        Amizade other = (Amizade) object;
        if ((this.idamizade == null && other.idamizade != null) || (this.idamizade != null && !this.idamizade.equals(other.idamizade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.RedeSocial.Entity.Amizade[ idamizade=" + idamizade + " ]";
    }
    
}
