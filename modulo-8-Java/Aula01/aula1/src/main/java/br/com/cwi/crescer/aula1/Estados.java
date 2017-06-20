/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.util.List;

/**
 *
 * @author alana.weiss
 */
public enum Estados {
    
        AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
        BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
        MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
        MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
        RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
        AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
        RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
        RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

        private String nome;

        private Estados(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
        
        static StringBuilder  estadosImpressao(Estados[] listaEstados){
            StringBuilder imprimir = new StringBuilder();
            StringBuilder append = null;
            for (int i = 0; i < listaEstados.length; i++){
                append = imprimir.append(listaEstados[i].getNome());
                append = imprimir.append(", ");
            }
            return append;
        }
}
