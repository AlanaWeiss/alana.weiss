/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class PostService {
    @Autowired
    PostRepository repository;
    
    @Autowired
    UsuarioService userServive;
    
    public Iterable<Post> find(){
        return repository.findAll();
    }
    
    public Post save(Post a){
       return repository.save(a);
    }
}
