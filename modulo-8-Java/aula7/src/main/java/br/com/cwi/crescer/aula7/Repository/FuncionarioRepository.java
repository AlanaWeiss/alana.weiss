/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Repository;

import br.com.crescer.aula4.tema.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana.weiss
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    
}
