import java.util.LinkedList;

public class AnalisadorSemantico {

    private LinkedList<Token> tokens;
    private int currentTokenIndex = 0;

    public AnalisadorSemantico(LinkedList<Token> tokens) {
        this.tokens = tokens;
    }

    public void analisar() {
        programa();
    }

    private void programa() {
        match("[");
        match("dec");
        match("]");
        listaDeclaracoes();
        match("[");
        match("prog");
        match("]");
        listaComandos();
    }

    private void listaDeclaracoes() {
        declaracao();
        while (tokens.get(currentTokenIndex+1).getLexema().equals("[")) {
            declaracao();
        }
    }    

    private void declaracao() {
        // pois ja foi verificado pelo analizador lexico 
        // provavel ja estar certo
        // arrumar para fazer uma lista de variaveis

        match(tokens.get(currentTokenIndex).getLexema());
        match("[");
        tipoVar();
        match("]");
    }

    private void tipoVar() {
        if (tokens.get(currentTokenIndex).getLexema().equals("integer")) {
            match("integer");
        } else if (tokens.get(currentTokenIndex).getLexema().equals("float")) {
            match("float");
        } else {
            throw new RuntimeException("Tipo de variável inválido");
        }
    }

    private void listaComandos() {
        comando();
        while (tokens.get(currentTokenIndex+1).getLexema().equals("EOF")) {
            listaComandos();
        }
    }

    private void comando() {
        // Implementar comandoAtribuicao, comandoEntrada, comandoSaida, comandoCondicao, comandoRepeticao, subAlgoritmo
        if (tokens.get(currentTokenIndex+1).getLexema().equals("<<")){
            comandoAtribuicao();
        }else if(tokens.get(currentTokenIndex+1).getLexema().equals("read")){
            comandoEntrada();
        }else if (tokens.get(currentTokenIndex+1).getLexema().equals("print")){
            comandoSaida();
        }else if (tokens.get(currentTokenIndex+1).getLexema().equals("if")){
            comandoCondicao();
    }
    private void comandoAtribuicao() {
        match("VARIAVEL");
        match("<<");
    }

    private void comandoEntrada() {
        match("read");
        match("VARIAVEL");
    }
    
    private void comandoSaida() {
        match("print");
        // match variavel / cadeia
        //match("VARIAVEL");
    }

    private void match(String lexema) {
        if (tokens.get(currentTokenIndex).getLexema().equals(lexema)) {
            currentTokenIndex++;
        } else {
            throw new RuntimeException("Token esperado: " + lexema);
        }
    }
}
