/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.Pessoa;

/**
 *
 * @author alana.weiss
 */
public class Main {
    public static void main(String[] args) {
        final PaisDao paisDao = new PaisDaoImpl();
        
        final Pais pais = new Pais();
        
        pais.setId(2l);
        pais.setNome("Estados Unidos da America");
        pais.setSigla("USA");
        
        paisDao.update(pais);
        
        
    }
}
