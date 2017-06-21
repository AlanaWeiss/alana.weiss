/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.lista1;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author alana'
 */
public class Exibicao {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String[] args) {
        boolean resultado;
        String invertida;
        int contarVogais;
        boolean stringPalindroma;
        
       
         try (final Scanner scanner = new Scanner(System.in)) {
           /* String inputString = scanner.nextLine ();
            resultado       = new ExercicioString().isEmpty(inputString);
            invertida       = new ExercicioString().inverter(inputString);
            contarVogais    = new ExercicioString().contaVogais(inputString);
            stringPalindroma = new ExercicioString().isPalindromo(inputString);

             System.out.println(resultado);
             System.out.println(invertida);
             System.out.println(contarVogais);
             System.out.println(stringPalindroma);*/
           /* 
            CalendarUtils calendarUtil = new CalendarUtils();
            String dateIn = scanner.nextLine();
            Date date = (Date)formatter.parse(dateIn);
            
            System.out.println(calendarUtil.diaSemana(date).toString());*/
           System.out.println(new Parcelator().calcular(new BigDecimal(1000), 10, 10, new Date("06/30/2016")));
            
        } catch (Exception e) {
            //...
            } 
     }
}
