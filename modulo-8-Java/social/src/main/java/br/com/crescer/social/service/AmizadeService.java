/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Amizade;
import br.com.crescer.social.entity.Solicitacao;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.AmizadeRepository;
import static oracle.net.aso.a.a;
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
}
