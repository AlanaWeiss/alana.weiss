/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.RedeSocial.Repository;

import br.com.cwi.crescer.RedeSocial.Entity.Usuario;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana.weiss
 */
public interface UsuarioRepository extends CrudRepository<Usuario, BigDecimal> {
    
}
