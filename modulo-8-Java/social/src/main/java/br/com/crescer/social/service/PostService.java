/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;
import br.com.crescer.social.entity.Amizade;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.PostRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author alana.weiss
 */
@Service
public class PostService {
    @Autowired
    PostRepository repository;
    
    @Autowired
    UsuarioService userServive;
    @Autowired
    AmizadeService amizadeServive;
    
    public Iterable<Post> find(){
        return repository.findAll();
    }
    
    public Post save(Post a){
        a.setData(new Date());
       return repository.save(a);
    }
    
    public List<Post> findAllByIdusuario(Usuario u){
        return repository.findAllByIdusuario(u);
    }
    
    public List<Post> findPostAmigosEUsuario(Usuario u){
        List<Amizade> amizade = amizadeServive.findAllByIdUsuario(u.getIdusuario());
        List<Usuario> amigosEUsuario = amizade.stream().filter(e -> e.getStatus() == 'p')
                 .map(e -> e.getIdsolicitado())
                 .filter(e -> e.getIdusuario()!= u.getIdusuario())
                 .collect(Collectors.toList());
        amigosEUsuario.add(u);
        return repository.findByIdusuarioInOrderByIdpostDesc(amigosEUsuario);
    }
}
