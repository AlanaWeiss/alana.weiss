/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Service;

import br.com.crescer.aula4.tema.Genero;
import br.com.cwi.crescer.aula7.Entity.Ator;
import br.com.cwi.crescer.aula7.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class GeneroService {
    @Autowired
    GeneroRepository repository;
    public Iterable<Genero> find(){
        return repository.findAll();
    }
    
    public Genero save(Genero a){
        return repository.save(a);
    }
    
    public Genero update(Genero a){
        Genero at;
        at = (Genero) repository.findOne(a.getId());
        at.setDescricao(a.getDescricao());
        return repository.save(at);
    }
}
