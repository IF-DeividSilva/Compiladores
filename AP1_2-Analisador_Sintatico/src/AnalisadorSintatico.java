import java.util.LinkedList;
public class AnalisadorSintatico {
    
    private LinkedList<Token> tokens;
    private int TokenIndex = 0;

    public AnalisadorSintatico(LinkedList<Token> tokens) {
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
        if (!tokens.get(TokenIndex+1).getLexema().equals("prog")) {
            declaracao();
            listaDeclaracoes();
        }
    }    

    private void declaracao() {
        // pois ja foi verificado pelo analizador lexico 
        // provavel ja estar certo
        // arrumar para fazer uma lista de variaveis --nop yet--
        if(tokens.get(TokenIndex).getTipoToken() == TipoToken.Var){
            match(tokens.get(TokenIndex).getLexema());
        }
        match("[");
        tipoVar();
        match("]");
    }

    private void tipoVar() {
        if (tokens.get(TokenIndex).getLexema().equals("integer")) {
            match("integer");
        } else if (tokens.get(TokenIndex).getLexema().equals("float")) {
            match("float");
        } else {
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() +" Tipo de variável inválido");
        }
    }

    private void listaComandos() {
        if (TokenIndex < tokens.size()) {
            int aux = comando();
            if(tokens.get(TokenIndex).getLexema().equals("EOF")){
                return;
            }
            if(tokens.get(TokenIndex).getLexema().equals("end")){
                return;
            }
            if (aux == -1) {
                throw new RuntimeException("Erro Sintatico: Linha "+ tokens.get(TokenIndex).getLinha() + " inesperado "+ tokens.get(TokenIndex).getLexema());
            }
            listaComandos();
        }
    }

    private int comando() {
        // Implementar comandoAtribuicao, comandoEntrada, comandoSaida, comandoCondicao, comandoRepeticao, subAlgoritmo
        if (tokens.get(TokenIndex+1).getLexema().equals("<<")){
            comandoAtribuicao();
        }else if(tokens.get(TokenIndex).getLexema().equals("read")){
            comandoEntrada();
        }else if (tokens.get(TokenIndex).getLexema().equals("print")){
            comandoSaida();
        }else if (tokens.get(TokenIndex).getLexema().equals("if")){
            comandoCondicao();
        }else if (tokens.get(TokenIndex).getLexema().equals("while")){
            comandoRepeticao();
        }else if (tokens.get(TokenIndex).getLexema().equals("start")){
            subAlgoritmo();        
        }else{
            return -1;
        }
        return 0;
    }
    
    private void comandoAtribuicao() {
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            TokenIndex++;
        }else{
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token esperado: VARIAVEL");
        }  
        match("<<");
        
        expressaoAritimetica();
    }

    private void comandoEntrada() {
        match("read");
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            TokenIndex++;
        }else{
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token esperado: VARIAVEL");
        }    
    }
    
    private void comandoSaida() {
        match("print");
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            TokenIndex++;
        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Cadeia) {
            TokenIndex++;
        }else{
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token inesperado: " + tokens.get(TokenIndex).getLexema());
        }    
    }

    private void comandoCondicao() {
        match("if");
        expressaoRelacional(); 
        match("then"); 
        comando(); 

        // Verifica se o próximo token é "else"
        if (TokenIndex < tokens.size() && tokens.get(TokenIndex).getLexema().equals("else")) {
            match("else"); // Consome o token "else"
            comando(); // Processa o comando após "else"
        }

    }
    

    private void comandoRepeticao(){
        match("while");
        expressaoRelacional(); 
        match ("then");
        comando();
    }

    private void subAlgoritmo() { 
        match("start");
        listaComandos();
        match ("end");
    }   

    private void expressaoAritimetica(){
        termoAritimetico();
        expressaoAritimetica1();
    }
    private void expressaoAritimetica1(){
        if (tokens.get(TokenIndex).getLexema().equals("+")) {
            match("+");
            termoAritimetico();
            expressaoAritimetica1();
        }else if (tokens.get(TokenIndex).getLexema().equals("-")) {
            match("-");
            termoAritimetico();
            expressaoAritimetica1();
        }else {
            return;
        }
    }

    private void termoAritimetico() {
        fatorAritimetico();
        termoAritimetico1();
    }

    private void termoAritimetico1() {
        if (tokens.get(TokenIndex).getLexema().equals("*")) {
            match("*");
            fatorAritimetico();
            termoAritimetico1();
        }else if (tokens.get(TokenIndex).getLexema().equals("/")) {
            match("/");
            fatorAritimetico();
            termoAritimetico1();
        }else {
            return;
        }
    }

    private void fatorAritimetico() {
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.NumInt) {
            //arrumar para tentar dar match com o numero
            TokenIndex++;
        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.NumReal) {
            //arrumar para tentar dar match com o numero
            TokenIndex++;
        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            //arrumar para tentar dar match com a variavel
            TokenIndex++;
        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.AbrePar) {
            match("(");
            expressaoAritimetica();
            match(")");
        }else {
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token inesperado: " + tokens.get(TokenIndex).getLexema());
        }
    }
    
    private void expressaoRelacional(){
        termoRelacional();
        expressaoRelacional1();
    }

    private void expressaoRelacional1() {
        if (tokens.get(TokenIndex).getLexema().equals("or") || tokens.get(TokenIndex).getLexema().equals("and")) {
            operadorBooleano();
            termoRelacional();
            expressaoRelacional1();
        }else {
            return;
        }
    }

    private void operadorBooleano(){
        if(tokens.get(TokenIndex).getLexema().equals("or")){
            match("or");
        }else if(tokens.get(TokenIndex).getLexema().equals("and")){
            match("and");
        }
    }

    private void termoRelacional(){
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.AbrePar) {
            match("(");
            expressaoRelacional();
            match(")");
        }else{
            expressaoAritimetica();
            if(tokens.get(TokenIndex).getTipoToken() == TipoToken.OpRelDif){
                match(tokens.get(TokenIndex).getLexema());
                expressaoAritimetica();
            } else if(tokens.get(TokenIndex).getTipoToken() == TipoToken.OpRelIgual){
                match(tokens.get(TokenIndex).getLexema());
                expressaoAritimetica();
            } else if(tokens.get(TokenIndex).getTipoToken() == TipoToken.OpRelMaior){
                match(tokens.get(TokenIndex).getLexema());
                expressaoAritimetica();
            } else if(tokens.get(TokenIndex).getTipoToken() == TipoToken.OpRelMaiorIgual){
                match(tokens.get(TokenIndex).getLexema());
                expressaoAritimetica();
            } else if(tokens.get(TokenIndex).getTipoToken() == TipoToken.OpRelMenor){
                match(tokens.get(TokenIndex).getLexema());
                expressaoAritimetica();
            } else if(tokens.get(TokenIndex).getTipoToken() == TipoToken.OpRelMenorIgual){
                match(tokens.get(TokenIndex).getLexema());
                expressaoAritimetica();
            }
        }

    }

    private void match(String lexema) {
        if (tokens.get(TokenIndex).getLexema().equals(lexema)) {
            TokenIndex++;
        } else {
            throw new RuntimeException("Erro Sintatico: Linha "+ tokens.get(TokenIndex).getLinha() + " inesperado "+ tokens.get(TokenIndex).getLexema());
        }
    }
}
