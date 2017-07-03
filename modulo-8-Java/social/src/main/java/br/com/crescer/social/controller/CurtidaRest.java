/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Curtida;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.service.CurtidaService;
import br.com.crescer.social.service.UsuarioService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(value = "/curtir")
public class CurtidaRest {

    @Autowired
    CurtidaService service;
    @Autowired
    UsuarioService uservice;

    
    @PostMapping
    public Curtida curtir(@RequestBody Curtida a) {
        return service.save(a);
    }    
    
    @GetMapping(value = "/{id}")
    public List<Curtida> getCurtidasPot(@PathVariable BigDecimal id){
        return service.findAllByIdPost(id);
    }
    
    @DeleteMapping(value = "/descurtir/{id}")
    public void descurtir(@PathVariable BigDecimal id){
     service.descurtir(id);
    }
}
