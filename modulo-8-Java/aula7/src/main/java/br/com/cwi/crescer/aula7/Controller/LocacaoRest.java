/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Controller;

import br.com.crescer.aula4.tema.Locacao;
import br.com.cwi.crescer.aula7.Service.LocacaoService;
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
public class LocacaoRest {

    @Autowired
    LocacaoService service;

    @ResponseBody
    @RequestMapping(value = "/Locacao", method = RequestMethod.GET)
    public Iterable<Locacao> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/Locacao", method = RequestMethod.POST)
    public Locacao list(@RequestBody Locacao a) {
        return service.save(a);
    }
    
    @ResponseBody
    @RequestMapping(value = "/Locacao", method = RequestMethod.PUT)
    public Locacao update(@RequestBody Locacao a) {
        return service.update(a);
    }
}
