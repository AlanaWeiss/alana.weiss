/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alana'
 */
@Entity
@Table(name = "POST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findByIdpost", query = "SELECT p FROM Post p WHERE p.idpost = :idpost")
    , @NamedQuery(name = "Post.findByDatapublicacao", query = "SELECT p FROM Post p WHERE p.datapublicacao = :datapublicacao")
    , @NamedQuery(name = "Post.findByMensagem", query = "SELECT p FROM Post p WHERE p.mensagem = :mensagem")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOST")
    private BigDecimal idpost;
    @Column(name = "DATAPUBLICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapublicacao;
    @Size(max = 400)
    @Column(name = "MENSAGEM")
    private String mensagem;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;
    @JsonIgnore
    @OneToMany(mappedBy = "idpost")
    private Collection<Curtida> curtidaCollection;

    public Post() {
    }

    public Post(BigDecimal idpost) {
        this.idpost = idpost;
    }

    public BigDecimal getIdpost() {
        return idpost;
    }

    public void setIdpost(BigDecimal idpost) {
        this.idpost = idpost;
    }

    public Date getDatapublicacao() {
        return datapublicacao;
    }

    public void setDatapublicacao(Date datapublicacao) {
        this.datapublicacao = datapublicacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public Collection<Curtida> getCurtidaCollection() {
        return curtidaCollection;
    }

    public void setCurtidaCollection(Collection<Curtida> curtidaCollection) {
        this.curtidaCollection = curtidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpost != null ? idpost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idpost == null && other.idpost != null) || (this.idpost != null && !this.idpost.equals(other.idpost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entity.Post[ idpost=" + idpost + " ]";
    }
    
}
