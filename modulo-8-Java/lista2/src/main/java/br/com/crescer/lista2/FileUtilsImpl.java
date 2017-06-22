/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alana'
 */
public class FileUtilsImpl implements FileUtils{

    // O método mk deve criar um arquivo ou diretório.
    @Override
    public boolean mk(String string) {
        try {
            return new File(string).createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // O método rm deve excluir o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    @Override
    public boolean rm(String string) {
        final File file = new File(string);
        if(file.isDirectory()) {
            try {
              throw new Exception("Impossivel excluir repositoria.");
            } catch (Exception ex) {
              Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
              return false;
            }
          }
         return file.delete();
    }

    // O método ls deve mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos.
    @Override
    public String ls(String string) {
        final File file = new File(string);
        if (file.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            for(File f : file.listFiles())
              sb.append(f.getName() + "\n");
      
      return sb.toString();
        }else
            return file.getAbsolutePath();
    }

    // O método mv deve mover o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    @Override
    public boolean mv(String in, String out) {
        final File fileIn = new File(in);
        final File fileOut = new File(out);
        if(fileIn.isDirectory() || fileOut.isDirectory()) {
            System.out.println("Impossivel mover diretorio");
            return false;
        }
        return fileIn.renameTo(fileOut);
    }
    
}
