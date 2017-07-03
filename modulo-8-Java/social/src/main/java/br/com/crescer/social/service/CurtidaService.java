/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Curtida;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.CurtidaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
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
    PostService postServive;
    
    public Iterable<Curtida> find(){
        return repository.findAll();
    }
    
    public Curtida save(Curtida a){
       return repository.save(a);
    }
    
    public List<Curtida> findAllByIdPost(BigDecimal id){
        Post p = postServive.findPostById(id);
        List<Curtida> amizade = repository.findByIdpost(p);
        return amizade;
    }
    
    public void descurtir(BigDecimal id){ 
        Curtida c = repository.findOne(id);
        repository.delete(c);
    }
}
