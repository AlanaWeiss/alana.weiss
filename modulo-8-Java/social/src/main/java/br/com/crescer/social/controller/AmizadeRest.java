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
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alana.weiss
 */
@RestController
@RequestMapping("/amizade")
public class AmizadeRest {
  @Autowired
  private AmizadeService service;
  
  @Autowired
  private UsuarioService serviceUser;
  
  @GetMapping(value = "/{id}")
  public Amizade get(@PathVariable BigDecimal id) {
    return service.findById(id);
  }
  
//  @GetMapping
//  public List<Amizade> get() {
//    return service.findAll();
//  }
  
//  @GetMapping(value = "/aceitos")
//  public Long countAceitos(@RequestParam BigDecimal idUsuario, @RequestParam Character aceito) {
//    return service.countByIdUsuarioAndAceito(idUsuario, aceito);
//  }
  
  @PostMapping
  @ResponseBody
  public Amizade post(@RequestBody Amizade amigos) {
    return service.save(amigos);
  }
  
  @GetMapping(value = "/lista/{id}")
  public List<Amizade> getAmigos(@PathVariable BigDecimal id) {
    return service.findAllByIdUsuario(id);
  }
  
  @PutMapping
  public Amizade update(@RequestParam BigDecimal idUsuario, @RequestParam Character aceito) {
    return null;
  }
  
  @GetMapping(value = "/pendentes/{id}")
  public List<Usuario> amigosUser(@PathVariable BigDecimal id){
      Usuario user = serviceUser.findByIdusuario(id);
        List<Amizade> amizade = service.findAllByIdUsuario(id);
        List<Usuario> amigos = amizade.stream().filter(e -> e.getStatus() == 'p')
                 .map(e -> e.getIdsolicitado())
                 .filter(e -> e.getIdusuario()!= user.getIdusuario())
                 .collect(Collectors.toList());
        return amigos;
  }
}