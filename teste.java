import java.util.StringTokenizer;

public class teste {
    public static void main (String[] args) {
        String input = "[dec]" + //
                        "Parametro []" + //
                        "Fatorial[integer]";

        StringTokenizer tokenizer = new StringTokenizer(input, "[]");
        while (tokenizer.hasMoreTokens()) {
            String nome = tokenizer.nextToken();
                if (nome.equals("dec")){
                    //System.out.println("Token: " + token + "," + TipoToken.PCDec);
                   // System.out.println("Token: "+ "<" + TipoToken.PCDec + "," + "'"+token+"'" + ">");
                    Token tes = new Token(TipoToken.PCDec, nome);
                    System.out.println(tes);

                    nome = tokenizer.nextToken(); 
                    Token tesa = new Token(TipoToken.Var, nome);
                    System.out.println(tesa);
                    

                }

             
        }
    }
}
