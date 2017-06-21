/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.lista1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alana'
 */
public class CalendarUtils implements ICalendarUtils{

    @Override
    public DiaSemana diaSemana(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(sdf.format(date)));
            int dia = calendar.get(Calendar.DAY_OF_WEEK)-1;
            return DiaSemana.values()[dia];
        } catch (Exception e) {
            System.out.println("Impossivel fazer parse da data");
            return null;
        }
    }

    @Override
    public String tempoDecorrido(Date date) {
        int anos, dias, meses;
        Date atual = new Date();
        long diferenca = Math.abs(atual.getTime() - date.getTime());
        int semMilisegundos = (int)diferenca / (24 * 60 * 60 * 1000);
        
        anos = semMilisegundos / 365;
        semMilisegundos = semMilisegundos-(anos*365);
        meses = semMilisegundos / 30;
        semMilisegundos = semMilisegundos-(meses*30);
        dias = semMilisegundos ;

        return String.format("%1s ano(s), %2s mês(es) e %3s dia(s)", anos, meses, dias);
        
    }  
    
}
