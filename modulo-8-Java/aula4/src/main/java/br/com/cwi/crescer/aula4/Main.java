/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

/**
 *
 * @author alana'
 */
public class Main {
    public static void main(String[] args) {
        Dao generoDao = new CrudDaoImpl<Genero, Long>(Genero.class);
        
//        Genero genero = new Genero();
//        genero.setDescricao("blablabla");
//        generoDao.save(genero);
        
           System.out.println(generoDao.findAll());
        
//        
//        Dao videoDao = new CrudDaoImpl<Video, Long>(Video.class);
//        Video video = new Video();
//        video.setNome("first");
//        video.setDataLancamento(new Date(2017,06,25));
//        video.setQuantidadeEstoque(10);
//        video.setDuracao("120 min");
//        video.setGenero(genero);
    }
}
