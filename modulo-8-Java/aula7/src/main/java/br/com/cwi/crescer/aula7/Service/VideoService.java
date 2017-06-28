/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Service;

import br.com.crescer.aula4.tema.Video;
import br.com.cwi.crescer.aula7.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana.weiss
 */
@Service
public class VideoService {
    @Autowired
    VideoRepository repository;
    public Iterable<Video> find(){
        return repository.findAll();
    }
    
    public Video save(Video a){
        return repository.save(a);
    }
    
    public Video update(Video a){
        Video at;
        at = (Video) repository.findOne(a.getId());
        at.setNome(a.getNome());
        return repository.save(at);
    }
}
