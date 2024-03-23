import java.util.LinkedList;

public class VerificaVar {
    public static boolean verifica(String nomeVar, LinkedList<Token> tokens) {
        for (Token token : tokens) {
            if (token.getTipoToken() == TipoToken.Var && token.getLexema().equals(nomeVar)) {
                return true;
            }
        }
        return false;
    }
}

