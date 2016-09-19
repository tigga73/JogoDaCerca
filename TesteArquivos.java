/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testearquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TesteArquivos {

 
    public static void main(String[] args) {
       File arquivo = new File("ArquivosPlayer");
///////////////////////comando para criar a pasta do arquivo
//     arquivo.mkdir();
//     comando para apagar o diretorio do arquivo
//     arquivo.delete();

///////////////////////Criação de um arquivo de texto dentro do diretório
       File file = new File("ArquivosPlayer/lista_usuario.txt");
//     A criação de um arquivo precisa estar dentro de um método try catch em caso de erros  
//       try{
//           
//           file.createNewFile();
//           
//        }catch(IOException ex){
//           System.out.println("Falha na criação do arquivo");
//       }
// 

/////////////////////Processo para leitura do conteudo do aqrquivo

  try{
      
      FileWriter escrita = new FileWriter(file);
      BufferedWriter escrever = new BufferedWriter(escrita);
      
      escrever.write("Escrita de teste");
      
      escrever.close();
      escrita.close();
    
    FileReader leitura = new FileReader(file);
    BufferedReader leitura_buff = new BufferedReader(leitura);
    String linha = leitura_buff.readLine();
    
    do{
        System.out.println(linha);
        linha = leitura_buff.readLine();
    }while(linha !=null);
    

  }catch(IOException ex){
      System.out.println("Falha na leitura do arquivo");
  }
  
  
  
  
  
  
  
  
    }
    
}
