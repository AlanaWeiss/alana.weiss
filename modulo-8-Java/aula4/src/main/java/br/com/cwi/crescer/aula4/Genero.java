/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author alana'
 */

@Entity
@Table(name = "GENERO")
public class Genero {
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
