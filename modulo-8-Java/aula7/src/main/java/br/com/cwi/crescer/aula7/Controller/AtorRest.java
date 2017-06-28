/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Controller;

import br.com.cwi.crescer.aula7.Service.AtorService;
import br.com.cwi.crescer.aula7.Entity.Ator;
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
public class AtorRest {

    @Autowired
    AtorService service;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Ator> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/ator", method = RequestMethod.POST)
    public Ator list(@RequestBody Ator a) {
        return service.save(a);
    }
    
    @ResponseBody
    @RequestMapping(value = "/ator", method = RequestMethod.PUT)
    public Ator update(@RequestBody Ator a) {
        return service.update(a);
    }
}
