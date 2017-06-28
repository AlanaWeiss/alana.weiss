/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Service;

import br.com.crescer.aula4.tema.Funcionario;
import br.com.cwi.crescer.aula7.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository repository;
    public Iterable<Funcionario> find(){
        return repository.findAll();
    }
    
    public Funcionario save(Funcionario a){
        return repository.save(a);
    }
    
    public Funcionario update(Funcionario a){
        Funcionario at;
        at = (Funcionario) repository.findOne(a.getId());
        at.setNome(a.getNome());
        return repository.save(at);
    }
}
