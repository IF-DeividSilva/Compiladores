import java.util.LinkedList;

public class VerificaVar {
    // Verifica se a var está na lista de tokens var caso encontre retorna true
    public static boolean verifica(String nomeVar, LinkedList<Token> tokens) {
        for (Token token : tokens) {
            // está comparando se o tipo é var e se o lexema é igual o var que foi passado por parametro
            if (token.getTipoToken() == TipoToken.Var && token.getLexema().equals(nomeVar)) {
                return true;
            }
        }
        return false;
    }
}

