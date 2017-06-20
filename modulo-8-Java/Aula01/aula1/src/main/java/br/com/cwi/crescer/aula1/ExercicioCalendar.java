/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author alana.weiss
 */
public class ExercicioCalendar {
    
    public static void main(String[] args) { 
        SimpleDateFormat format;
        
        format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        
        try (final Scanner data = new Scanner(System.in)) {
            System.out.println("Digite uma data (dd/mm/aaaa)");
                String input = data.nextLine ();
            System.out.println("Digite dias a serem somados");
                int diasSomados = data.nextInt();
                
                    calendar.setTime(format.parse(input));
                    calendar.add(Calendar.DAY_OF_YEAR, diasSomados);
                   
		System.out.println(calendar.getTime());
             } catch (Exception e) {
            //...
            }           
     }
}
