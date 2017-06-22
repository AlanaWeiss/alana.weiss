/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author alana'
 */
public class ReaderUtilsImp implements ReaderUtils{

    @Override
    public String read(String string) throws Exception {
        
        if(!string.contains(".txt"))
            throw new Exception("Arquivo invalido. É necessario que seja um txt.");
        
        final File file = new File(string);
        
        if(file.isDirectory())
            throw new Exception("Arquivo inválido.");
        
        try (
            final Reader reader = new FileReader(file);
            final BufferedReader buffer = new BufferedReader(reader);
        ) {
            StringBuilder builder = new StringBuilder();
            
            buffer.lines().forEach(linha -> builder.append(linha).append("\n"));
            
            return builder.toString();
            
        } catch (FileNotFoundException e) {
            throw new Exception("Arquivo não encontrado.");
        }
    }
    
}
