/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescerRedeSocial.Service;

import br.com.cwi.crescer.RedeSocial.Entity.Usuario;
import br.com.cwi.crescer.RedeSocial.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;
    public Iterable<Usuario> find(){
        return repository.findAll();
    }
    
    public Usuario save(Usuario a){
        return repository.save(a);
    }
    
    public Usuario update(Usuario a){
        Usuario at;
        at = (Usuario) repository.findOne(a.getIdusuario());
        at.setNome(a.getNome());
        at.setDatanascimento(a.getDatanascimento());
        at.setEmail(a.getEmail());
        at.setNick(a.getNick());
        at.setOrganizacao(a.getOrganizacao());
        return repository.save(at);
    }
    
    public void delete(Usuario a){
        Usuario at;
        at = (Usuario) repository.findOne(a.getIdusuario());
        repository.delete(at);
    }
}
