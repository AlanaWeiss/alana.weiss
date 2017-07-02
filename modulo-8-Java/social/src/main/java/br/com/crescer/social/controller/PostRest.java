/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.service.PostService;
import br.com.crescer.social.service.UsuarioService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alana.weiss
 */
@RestController
@RequestMapping(value = "/publicacao")
public class PostRest {

    @Autowired
    PostService service;
    @Autowired
    UsuarioService uservice;

    
    @PostMapping
    public Post publicar(@RequestBody Post a) {
        return service.save(a);
    }
    
    @GetMapping(value = "/{id}")
    public List<Post> getPostUsuario(@PathVariable BigDecimal id){
        Usuario u = uservice.findByIdusuario(id);
        return service.findAllByIdusuario(u);
    }
    
    @GetMapping(value = "/amigos/{id}")
    public List<Post> getPostUsuarioEAmigos(@PathVariable BigDecimal id){
        Usuario u = uservice.findByIdusuario(id);
        return service.findPostAmigosEUsuario(u);
    }
//    
//    @ResponseBody
//    @PutMapping
//    public Usuario update(@RequestBody Usuario a) {
//        return service.update(a);
//    }
//    
//    @DeleteMapping
//    public void delete(@RequestBody Usuario a) {
//        service.delete(a);
//    }
    
}
