/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;


import br.com.crescer.social.entity.Curtida;
import br.com.crescer.social.entity.Post;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana.weiss
 */

public interface CurtidaRepository extends CrudRepository<Curtida, BigDecimal> {
    public List<Curtida> findByIdpost(Post p);
}
