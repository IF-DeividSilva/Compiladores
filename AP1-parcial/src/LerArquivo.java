import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {
    // Método para ler o arquivo e retornar as linhas processadas
    public static List<String> lerArquivo(String nomeArq) {
        List<String> linhasProcessadas = new ArrayList<>();
        try {
            FileReader arq = new FileReader(nomeArq);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                // Remove espaços em branco no início e no final da linha
                linha = linha.trim();
                // Ignora linhas vazias
                if (!linha.isEmpty()) {
                    // "tratar" comentario
                    int indice = linha.indexOf("#");
                    // caso encontrar '#' na linha usa o subsring para ignorar o que está depois (*comentario*)
                    if (indice != -1) {
                        linha = linha.substring(0, indice);
                    }
                    linhasProcessadas.add(linha);
                }
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo: " + e.getMessage());
        }
        return linhasProcessadas;
    }
}
