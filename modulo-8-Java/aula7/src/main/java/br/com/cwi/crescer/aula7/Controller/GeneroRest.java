/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Controller;

import br.com.crescer.aula4.tema.Genero;
import br.com.cwi.crescer.aula7.Service.GeneroService;
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
public class GeneroRest {

    @Autowired
    GeneroService service;

    @ResponseBody
    @RequestMapping(value = "/Genero", method = RequestMethod.GET)
    public Iterable<Genero> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/Genero", method = RequestMethod.POST)
    public Genero list(@RequestBody Genero a) {
        return service.save(a);
    }
    
    @ResponseBody
    @RequestMapping(value = "/Genero", method = RequestMethod.PUT)
    public Genero update(@RequestBody Genero a) {
        return service.update(a);
    }
}
