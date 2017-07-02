/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.service.AmizadeService;
import br.com.crescer.social.service.UsuarioService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author alana.weiss
 */
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioRest {

    @Autowired
    UsuarioService service;
    @Autowired
    AmizadeService amizadeService;
    @Autowired
    UsuarioLogado logado;

    @ResponseBody
     @GetMapping
        public Map<String, Object> listarUsuarios(Authentication authentication) {
        Usuario u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(service::findByEmail)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }

    @ResponseBody
    @PostMapping
    public Usuario list(@RequestBody Usuario a) {
        return service.save(a);
    }
    
    @ResponseBody
    @PutMapping
    public Usuario update(@RequestBody Usuario a) {
        return service.update(a);
    }
    
    @DeleteMapping
    public void delete(@RequestBody Usuario a) {
        service.delete(a);
    }
    
}
