import java.util.LinkedList;
import java.util.List;

//java Main programa1.gyh

public class Main {
    public static void main(String[] args) {
       // if (args.length > 0) {
            // ideia 1 - alterar o arquivo colocando espaços antes e apos delimitadores (),[] 
            // ideia 2 - pegar as linhas e colocar espaços antes e apos os delimitadores
            System.out.println("Tesre");
            String nomeArq = "programa1.gyh";//args[0];
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
