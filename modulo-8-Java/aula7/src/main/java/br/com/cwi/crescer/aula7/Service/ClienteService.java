/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Service;

import br.com.crescer.aula4.tema.Cliente;
import br.com.cwi.crescer.aula7.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;
    public Iterable<Cliente> find(){
        return repository.findAll();
    }
    
    public Cliente save(Cliente a){
        return repository.save(a);
    }
    
    public Cliente update(Cliente a){
        Cliente at;
        at = (Cliente) repository.findOne(a.getId());
        at.setNome(a.getNome());
        return repository.save(at);
    }
}
