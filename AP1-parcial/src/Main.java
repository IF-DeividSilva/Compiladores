/*
 * 
 * @file Main.java
 * @author Deivid da Silva Galvão, RA 2408740
 * @brief Criação de um analisador lexico (entrega parcial AP1) 
 * @version 0.1
 * @date 2024-03-23
 * 
 * @copyright Copyright (c) 2022
 * 

 */

import java.util.LinkedList;
import java.util.List;

//java Main programa1.gyh

public class Main {
    public static void main(String[] args) {
       // if (args.length > 0) {
            String nomeArq = "programa2.gyh";//args[0];
            
            PadronizaArquivo.padroniza(nomeArq);//
            
            List<String> linhas = LerArquivo.lerArquivo(nomeArq);
            LinkedList<Token> tokens = new LinkedList<Token>();
            int controle = 0;

            int indice = 0;
            for (String linha : linhas) {
                indice++;
                controle = AnalisadorLexico.analisador (linha, indice, tokens, controle);
            }
            for (Token token : tokens) {
                System.out.println(token);
            }
        //} else {
          //  System.out.println("Por favor, forneça o caminho do arquivo como argumento.");
        //}
    }
}
