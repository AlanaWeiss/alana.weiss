/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.lista1;

import java.util.Scanner;

/**
 *
 * @author alana'
 */
public class Exibicao {
    public static void main(String[] args) {
        boolean resultado;
        String invertida;
        int contarVogais;
        boolean stringPalindroma;
       
         try (final Scanner scanner = new Scanner(System.in)) {
            String inputString = scanner.nextLine ();
            
            resultado       = new ExercicioString().isEmpty(inputString);
            invertida       = new ExercicioString().inverter(inputString);
            contarVogais    = new ExercicioString().contaVogais(inputString);
            stringPalindroma = new ExercicioString().isPalindromo(inputString);

             System.out.println(resultado);
             System.out.println(invertida);
             System.out.println(contarVogais);
             System.out.println(stringPalindroma);
        } catch (Exception e) {
            //...
            } 
     }
}
