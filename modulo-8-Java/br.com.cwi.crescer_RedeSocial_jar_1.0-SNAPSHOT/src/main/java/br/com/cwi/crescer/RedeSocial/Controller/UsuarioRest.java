/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.RedeSocial.Controller;

import br.com.cwi.crescer.RedeSocial.Entity.Usuario;
import br.com.cwi.crescerRedeSocial.Service.UsuarioService;
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
public class UsuarioRest {

    @Autowired
    UsuarioService service;

    @ResponseBody
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public Iterable<Usuario> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario list(@RequestBody Usuario a) {
        return service.save(a);
    }
    
    @ResponseBody
    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario update(@RequestBody Usuario a) {
        return service.update(a);
    }
    
    @RequestMapping(value = "/usuario", method = RequestMethod.DELETE)
    public void delete(@RequestBody Usuario a) {
        service.delete(a);
    }
}
