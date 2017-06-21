/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.lista1;

import java.text.Normalizer;
import java.util.Scanner;

/**
 *
 * @author alana'
 */
public class ExercicioString implements StringUtils {
    
   
    public boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

   
    public String inverter(String string) {
        if(isEmpty(string))
            return "String vazia, impossivel reverte-la";
        String reverso = new StringBuilder(string).reverse().toString();
        return reverso;
    }

  
    public int contaVogais(String string) {
        int contarVogais = 0;
        string.toLowerCase();
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                contarVogais++;
        }
        return contarVogais;
    }

    
    public boolean isPalindromo(String string) {
        String stringSemEspaco = normalize(string).replaceAll("\\s","").toLowerCase();
        String stringInvertida = inverter(stringSemEspaco);
        if (stringSemEspaco.equals(stringInvertida)) {
            return true;
        } else
            return false;
    }
    
    private static String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
