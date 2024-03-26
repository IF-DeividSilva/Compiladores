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

// esse comeca o codigo 
// por favor compile esse aqui 

public class Main {
    public static void main(String[] args) {
         //for (int i = 0; i < args.length; i++){
            String nomeArq = "programa2.gyh";//args[0];
            // chama o metodo da class padroniza para add um espaço antes e dps dos delimitadores
            PadronizaArquivo.padroniza(nomeArq);

            // salva as linhas do arq ja padronizado em um vetor de strings
            List<String> linhas = LerArquivo.lerArquivo(nomeArq);

            // cria uma lista encadeada de tokens (no fim foi inutil)
            LinkedList<Token> tokens = new LinkedList<Token>();

            // variavel para saber se está na parte do codigo de declaração("dec") ou na parte de "prog"
            int controle = 0;

            // var para o indice da linha
            int indice = 0;

            // for para enquanto tiver linhas ele chamar o metodo analisador da classe analizador lexico 
            for (String linha : linhas) {
                indice++;
                controle = AnalisadorLexico.analisador (linha, indice, tokens, controle);
            }

            // for para colocar os tokens em um arquivo de saida
            for (Token token : tokens) {
                System.out.println(token);
            }
            System.out.println("<EOF>");
            
    //}
}
}
