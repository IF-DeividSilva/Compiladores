/*
 * 
 * @file Main.java
 * @author Deivid da Silva Galvão, RA 2408740
 * @brief Criação de um analisador sintatico (entrega parcial AP1) 
 * @version 0.1
 * @date 2024-05-10
 * 
 * @copyright Copyright (c) 2022
 * 
 */
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        for (String nomeArq : args) {

            // try para tratar erros sintaticos d0s arquivos 
            try {
                // chama o metodo da class padroniza para add um espaço antes e dps dos delimitadores
                PadronizaArquivo.padroniza(nomeArq);

                // salva as linhas do arq ja padronizado em um vetor de strings
                List<String> linhas = LerArquivo.lerArquivo(nomeArq);

                // cria uma lista encadeada de tokens (no fim foi inutil)
                LinkedList<Token> tokens = new LinkedList<Token>();
                // variavel para saber se está na parte do codigo de declaração("dec") ou na parte de "prog" inutil tbm
                int controle = 0;
                // var para o indice da linha
                int indice = 0;
                // for para enquanto tiver linhas ele chamar o metodo analisador da classe analizador lexico
                for (String linha : linhas) {
                    indice++;
                    AnalisadorLexico.analisador(linha, indice, tokens, controle);
                }
                tokens.add(new Token(TipoToken.FimArq, "EOF", indice));

                // for para colocar os tokens em um arquivo de saida ou printar na tela
                //**Erros estão sendo printados antes da lista de tokens**
                // System.out.println("<EOF>")
               // for (Token token : tokens) {
                 //   System.out.println(token);
               // }

                // chama o metodo analisar da classe analisador sintatico
                AnalisadorSintatico analisador = new AnalisadorSintatico(tokens);
                analisador.analisar();
                System.out.println("Nenhum erro sintatico encontrado no arquivo: " + nomeArq);
            } catch (RuntimeException e) {
                System.err.println("Erro encontrado no arquivo: " + nomeArq + ".  " + e.getMessage());
            };
        }
    }
}
