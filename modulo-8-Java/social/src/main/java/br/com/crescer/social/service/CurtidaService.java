/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Curtida;
import br.com.crescer.social.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class CurtidaService {
    @Autowired
    CurtidaRepository repository;
    
    @Autowired
    UsuarioService userServive;
    
    public Iterable<Curtida> find(){
        return repository.findAll();
    }
    
    public Curtida save(Curtida a){
       return repository.save(a);
    }
}
