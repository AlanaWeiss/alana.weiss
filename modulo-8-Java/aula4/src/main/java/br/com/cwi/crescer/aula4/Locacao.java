/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author alana'
 */
@Entity
@Table(name = "LOCACAO")
public class Locacao {

    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "VALOR_TOTAL")
    private double valorTotal;

    @Column(name = "DATA_DEVOLUCAO")
    private Date dataDevolucao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_VIDEO")
    private Video video;
}
