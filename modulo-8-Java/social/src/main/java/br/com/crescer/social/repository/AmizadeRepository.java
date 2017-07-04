/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;


import br.com.crescer.social.entity.Amizade;
import br.com.crescer.social.entity.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana.weiss
 */

public interface AmizadeRepository extends CrudRepository<Amizade, BigDecimal> {
    public Amizade findByIdsolicitanteAndStatus(BigDecimal id, String status);
//    public List<Usuario> findbyIdSolicitante(BigDecimal id);
    public Long countByIdsolicitadoAndStatus(Usuario usuario, Character status);
    public List<Amizade> findAllByIdsolicitanteOrIdsolicitado(Usuario usuario, Usuario usuario2);
    public List<Amizade> findAllByIdsolicitanteOrIdsolicitadoAndStatus(Usuario q, Usuario w, Character e);
    public List<Amizade> findAllByIdsolicitadoAndStatus(Usuario u, Character s);
    public List<Amizade> findAllByIdsolicitanteAndStatus(Usuario u, Character s);
    public List<Amizade> findAllByIdsolicitado(Usuario u);
}
