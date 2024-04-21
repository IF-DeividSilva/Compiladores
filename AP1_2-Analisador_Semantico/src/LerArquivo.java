import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {

    // Método para ler um arquivo e retornar uma lista de strings
    public static List<String> lerArquivo(String nomeArq) {
        List<String> linhasProcessadas = new ArrayList<>();
        try {
            FileReader arq = new FileReader(nomeArq);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                // Remove espaços em branco no início e no final da linha
                linha = linha.trim();
                // "tratar" comentario
                int indice = linha.indexOf("#");
                // Se '#' estiver no início da linha, deixa a linha vazia
                if (indice == 0) {
                    linha = "";
                  // Se '#' estiver em outra posição, ignora o que está depois   
                } else if (indice != -1) {
                    linha = linha.substring(0, indice);
                }
                // Adiciona a linha processada à lista, mesmo que esteja vazia
                linhasProcessadas.add(linha);
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo: " + e.getMessage());
        }
        return linhasProcessadas;
    }
}
