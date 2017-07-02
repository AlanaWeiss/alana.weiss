/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Amizade;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.AmizadeRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class AmizadeService {
    @Autowired
    AmizadeRepository repository;
    
    @Autowired
    UsuarioService userServive;
    
    public Iterable<Amizade> find(){
        return repository.findAll();
    }
    
    public Amizade save(Amizade a){
       return repository.save(a);
    }
      public Amizade save2(Amizade b){
        
       return repository.save(b);
    }

  
  public Amizade findById(BigDecimal id) {
    return repository.findOne(id);
  }

  
   public List<Amizade> findAllByIdUsuario(BigDecimal idUsuario) {
    final Usuario usuario = new Usuario();
    usuario.setIdusuario(idUsuario);
    Usuario usuario2 = usuario;
    return repository.findAllByIdsolicitanteOrIdsolicitado(usuario, usuario2);
  }
}
