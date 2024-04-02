import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PadronizaArquivo {
    // Método para padronizar o arquivo
    public static void padroniza(String arq) {
        try {
            // Ler o arquivo
            FileReader fr = new FileReader(arq);
            BufferedReader br = new BufferedReader(fr);
            
            // Ler o conteúdo do arquivo
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                sb.append(linha);
                sb.append(System.lineSeparator()); // Adiciona uma quebra de linha para manter o formato original
            }
            br.close();
            fr.close();
            
            // Para adicionar espaços antes e depois dos delimitadores "[]()"
            String conteudoModificado = sb.toString().replaceAll("([\\[\\]\\(\\)\\\"])", " $1 ");
            
            // Salvar o conteúdo modificado de volta no arquivo
            FileWriter fw = new FileWriter(arq);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(conteudoModificado);
            bw.close();
            fw.close();
            
            System.out.println("Espaços adicionados com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    

