/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Controller;

import br.com.crescer.aula4.tema.Funcionario;
import br.com.cwi.crescer.aula7.Service.FuncionarioService;
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
public class FuncionarioRest {

    @Autowired
    FuncionarioService service;

    @ResponseBody
    @RequestMapping(value = "/Funcionario", method = RequestMethod.GET)
    public Iterable<Funcionario> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/Funcionario", method = RequestMethod.POST)
    public Funcionario list(@RequestBody Funcionario a) {
        return service.save(a);
    }
    
    @ResponseBody
    @RequestMapping(value = "/Funcionario", method = RequestMethod.PUT)
    public Funcionario update(@RequestBody Funcionario a) {
        return service.update(a);
    }
}
