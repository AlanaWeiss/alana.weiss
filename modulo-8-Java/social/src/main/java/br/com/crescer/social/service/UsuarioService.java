/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.UsuarioRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        if(repository.findOneByEmailIgnoreCase(a.getEmail()) != null)
            throw new RuntimeException("Email já está em uso");
        a.setSenha(new BCryptPasswordEncoder().encode(a.getSenha()));
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
    
    public Usuario findByEmail(String email) {
    return repository.findOneByEmail(email);
  }
    
    public Usuario findByIdusuario(BigDecimal idusuario){
        return repository.findOne(idusuario);
    }
    
    public Iterable<Usuario> findAll(BigDecimal idusuario){
        return repository.findAll();
    }
    
     public Iterable<Usuario> findBySearch(String search) {
        return repository.findByNomeContainingIgnoreCase(search);
    }
}
