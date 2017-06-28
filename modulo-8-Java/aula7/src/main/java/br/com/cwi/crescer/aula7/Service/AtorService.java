/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Service;

import br.com.cwi.crescer.aula7.Repository.AtorRepository;
import br.com.cwi.crescer.aula7.Entity.Ator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class AtorService {
    @Autowired
    AtorRepository repository;
    public Iterable<Ator> find(){
        return repository.findAll();
    }
    
    public Ator save(Ator a){
        return repository.save(a);
    }
    
    public Ator update(Ator a){
        Ator at;
        at = (Ator) repository.findOne(a.getId());
        at.setNome(a.getNome());
        return repository.save(at);
    }
}
