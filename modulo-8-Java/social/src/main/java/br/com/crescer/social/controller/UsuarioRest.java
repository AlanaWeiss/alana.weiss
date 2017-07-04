/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Amizade;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.service.AmizadeService;
import br.com.crescer.social.service.UsuarioService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alana.weiss
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRest {

    @Autowired
    UsuarioService service;
    @Autowired
    AmizadeService amizadeService;
    @Autowired
    UsuarioLogado logado;

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

    @PostMapping
    public Usuario list(@RequestBody Usuario a) {
        return service.save(a);
    }
    
    @PutMapping
    public Usuario update(@RequestBody Usuario a) {
        return service.update(a);
    }
    
    @DeleteMapping
    public void delete(@RequestBody Usuario a) {
        service.delete(a);
    }
    
    @GetMapping("/search")
    public Iterable<Usuario> findBySearch(@RequestParam String busca) {
        return service.findBySearch(busca);
    }
            
    @GetMapping("/{id}")
    public Usuario findUsuario(@PathVariable BigDecimal id) {
        return service.findByIdusuario(id);
    }
    
    @GetMapping("/naoAmigo/{id}")
    public List<Usuario> findNaoAmigos(@PathVariable BigDecimal id){
        return service.findByIdUsuarioNotIn(id);
    }
}
