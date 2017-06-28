/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Controller;

import br.com.crescer.aula4.tema.Cliente;
import br.com.cwi.crescer.aula7.Service.ClienteService;
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
public class ClienteRest {

    @Autowired
    ClienteService service;

    @ResponseBody
    @RequestMapping(value = "/Cliente", method = RequestMethod.GET)
    public Iterable<Cliente> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/Cliente", method = RequestMethod.POST)
    public Cliente list(@RequestBody Cliente a) {
        return service.save(a);
    }
    
    @ResponseBody
    @RequestMapping(value = "/Cliente", method = RequestMethod.PUT)
    public Cliente update(@RequestBody Cliente a) {
        return service.update(a);
    }
}
