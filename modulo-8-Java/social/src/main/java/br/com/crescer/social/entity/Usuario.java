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
 * @author alana.weiss
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo")
    , @NamedQuery(name = "Usuario.findByDatanascimento", query = "SELECT u FROM Usuario u WHERE u.datanascimento = :datanascimento")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByRole", query = "SELECT u FROM Usuario u WHERE u.role = :role")
    , @NamedQuery(name = "Usuario.findByOrganizacao", query = "SELECT u FROM Usuario u WHERE u.organizacao = :organizacao")
    , @NamedQuery(name = "Usuario.findByNick", query = "SELECT u FROM Usuario u WHERE u.nick = :nick")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 80)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 80)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 10)
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;
    @Size(max = 200)
    @Column(name = "SENHA")
    private String senha;
    @Size(max = 30)
    @Column(name = "ROLE")
    private String role;
    @Size(max = 80)
    @Column(name = "ORGANIZACAO")
    private String organizacao;
    @Size(max = 30)
    @Column(name = "NICK")
    private String nick;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private BigDecimal idusuario;
    @JsonIgnore
    @OneToMany(mappedBy = "idusuario")
    private Collection<Post> postCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idusuario")
    private Collection<Curtida> curtidaCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idsolicitante")
    private Collection<Amizade> amizadeCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idsolicitado")
    private Collection<Amizade> amizadeCollection1;

    public Usuario() {
    }

    public Usuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public BigDecimal getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    @XmlTransient
    public Collection<Curtida> getCurtidaCollection() {
        return curtidaCollection;
    }

    public void setCurtidaCollection(Collection<Curtida> curtidaCollection) {
        this.curtidaCollection = curtidaCollection;
    }

    @XmlTransient
    public Collection<Amizade> getAmizadeCollection() {
        return amizadeCollection;
    }

    public void setAmizadeCollection(Collection<Amizade> amizadeCollection) {
        this.amizadeCollection = amizadeCollection;
    }

    @XmlTransient
    public Collection<Amizade> getAmizadeCollection1() {
        return amizadeCollection1;
    }

    public void setAmizadeCollection1(Collection<Amizade> amizadeCollection1) {
        this.amizadeCollection1 = amizadeCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.RedeSocial.Entity.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
