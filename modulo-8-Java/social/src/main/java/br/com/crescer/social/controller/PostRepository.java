/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author alana.weiss
 */
@Controller
public class PostRepository {

    @Autowired
    PostService service;

    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public Iterable<Post> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Post list(@RequestBody Post a) {
        return service.save(a);
    }

}
