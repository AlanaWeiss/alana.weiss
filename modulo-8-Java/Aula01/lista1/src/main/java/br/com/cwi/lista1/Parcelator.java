/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.lista1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author alana'
 */
public class Parcelator implements IParcelator{

    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        Map parcelas = new LinkedHashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(dataPrimeiroVencimento);
        BigDecimal mensalidade = new BigDecimal(valorParcelar.floatValue()/numeroParcelas * (1 + (taxaJuros/100))).setScale(2, RoundingMode.UP);
        
        for(int i = 0; i<numeroParcelas; i++){
            parcelas.put(formatter.format(calendar.getTime()), mensalidade);
            calendar.add(Calendar.MONTH, 1);
        }
        
        return parcelas;
    }
    
}
