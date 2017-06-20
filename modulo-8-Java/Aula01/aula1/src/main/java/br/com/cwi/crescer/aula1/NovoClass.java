/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author alana.weiss
 */
public class NovoClass {
    
    public static void main(String[] args) { 
        Estados estados = null; 
        Estados[] listEstados = Estados.values();
        Arrays.sort(listEstados, Collections.reverseOrder());
     
         System.out.println(Estados.estadosImpressao(listEstados));
     }
}
