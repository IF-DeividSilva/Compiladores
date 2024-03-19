import java.util.List;

//java Main programa1.gyh

public class Main {
    public static void main(String[] args) {
       // if (args.length > 0) {
            String nomeArq = "programa1.gyh";//args[0];
            List<String> linhas = LerArquivo.lerArquivo(nomeArq);
            for (String linha : linhas) {
                System.out.println(linha);
            }
        //} else {
          //  System.out.println("Por favor, forneça o caminho do arquivo como argumento.");
        //}
    }
}
