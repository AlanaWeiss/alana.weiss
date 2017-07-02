/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author alana.weiss
 */
@Controller
@RequestMapping(value = "/publicacao")
public class PostRest {

    @Autowired
    PostService service;

    
    @ResponseBody
    @PostMapping
    public Post list(@RequestBody Post a) {
        return service.save(a);
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
