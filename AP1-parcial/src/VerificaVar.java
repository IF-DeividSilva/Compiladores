import java.util.LinkedList;

public class VerificaVar {
    public static boolean verifica(String nomeVar, LinkedList<Token> tokens) {
        for (Token token : tokens) {
            if (token.getLexema().equals(nomeVar)) {
                return true;
            }
        }
        return false;
    }
}
