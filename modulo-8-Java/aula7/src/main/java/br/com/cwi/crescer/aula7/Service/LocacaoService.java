/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Service;

import br.com.crescer.aula4.tema.Locacao;
import br.com.cwi.crescer.aula7.Entity.Ator;
import br.com.cwi.crescer.aula7.Repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class LocacaoService {
    @Autowired
    LocacaoRepository repository;
    public Iterable<Locacao> find(){
        return repository.findAll();
    }
    
    public Locacao save(Locacao a){
        return repository.save(a);
    }
    
    public Locacao update(Locacao a){
        Locacao at;
        at = (Locacao) repository.findOne(a.getId());
        at.setValorTotal(a.getValorTotal());
        return repository.save(at);
    }
}
