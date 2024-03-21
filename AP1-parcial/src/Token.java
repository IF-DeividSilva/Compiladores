public class Token {
    private TipoToken tipoToken;
    private String lexema;
    //private int linha;

    public Token( TipoToken tipoToken, String lexema) {
        this.lexema = lexema;
        this.tipoToken = tipoToken;
      //  this.linha = linha;
    }

    @Override
    public String toString() {
        return "<" + tipoToken + ", " +  lexema + ">";
    }
}