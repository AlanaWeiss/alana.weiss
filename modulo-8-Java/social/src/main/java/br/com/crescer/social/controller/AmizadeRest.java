/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Amizade;
import br.com.crescer.social.entity.Solicitacao;
import br.com.crescer.social.service.AmizadeService;
import oracle.security.o5logon.a;
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
public class AmizadeRest {

    @Autowired
    AmizadeService service;

    @ResponseBody
    @RequestMapping(value = "/amizade", method = RequestMethod.GET)
    public Iterable<Amizade> list() {
        return service.find();
    }
//
    @ResponseBody
    @RequestMapping(value = "/amizade", method = RequestMethod.POST)
    public Amizade list(@RequestBody Amizade s) {
        return service.save(s);
    }
    
}
