/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.RedeSocial.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alana'
 */
@Entity
@Table(name = "CURTIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curtida.findAll", query = "SELECT c FROM Curtida c")
    , @NamedQuery(name = "Curtida.findByIdcurtida", query = "SELECT c FROM Curtida c WHERE c.idcurtida = :idcurtida")})
public class Curtida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCURTIDA")
    private BigDecimal idcurtida;
    @OneToMany(mappedBy = "curtidas")
    private Collection<Post> postCollection;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;

    public Curtida() {
    }

    public Curtida(BigDecimal idcurtida) {
        this.idcurtida = idcurtida;
    }

    public BigDecimal getIdcurtida() {
        return idcurtida;
    }

    public void setIdcurtida(BigDecimal idcurtida) {
        this.idcurtida = idcurtida;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurtida != null ? idcurtida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curtida)) {
            return false;
        }
        Curtida other = (Curtida) object;
        if ((this.idcurtida == null && other.idcurtida != null) || (this.idcurtida != null && !this.idcurtida.equals(other.idcurtida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.RedeSocial.Entity.Curtida[ idcurtida=" + idcurtida + " ]";
    }
    
}
