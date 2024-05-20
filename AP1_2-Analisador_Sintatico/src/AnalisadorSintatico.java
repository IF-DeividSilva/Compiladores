import java.util.LinkedList;
public class AnalisadorSintatico {
    
    private LinkedList<Token> tokens;
    private int TokenIndex = 0;

    public AnalisadorSintatico(LinkedList<Token> tokens) {
        this.tokens = tokens;
    }
    // analisar q chama programa
    public void analisar() {
        programa();
    }

    // programa tenta dar matche [dec]
    // chama lista de declaracoes 
    // tenta dar matche [prog]
    // chama lista de comandos
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
    
    // lista de declaracoes chama declaracao
    // e dps faz uma chamada recusiva 
    // até achar o token "prog" 
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
        // caso nao seja um tipo var erro sintaico
        if(tokens.get(TokenIndex).getTipoToken() == TipoToken.Var){
            match(tokens.get(TokenIndex).getLexema());
        }else{
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token esperado: VARIAVEL");
        }
        match("[");
        tipoVar();
        match("]");
    }

    // verifica se o tipo da variavel é integer ou float
    // caso nao seja erro sintatico
    private void tipoVar() {
        if (tokens.get(TokenIndex).getLexema().equals("integer")) {
            match("integer");
        } else if (tokens.get(TokenIndex).getLexema().equals("float")) {
            match("float");
        } else {
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() +" Tipo de variável inválido");
        }
    }

    // chama o comando caso nao seja EOF ou end
    // comando retorna -1 caso nao seja um comando valido para evitar loop infinito
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

    // verifica se o proximo token é atribuicao ou se o atual é read, print, if, while ou start
    private int comando() {
    
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
            if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
                match(tokens.get(TokenIndex).getLexema());
                return 0;
            }
            return -1;
        }
        return 0;
    }
    // verifica se a atribuicao esta sendo feita em uma variavael
    // chama a expressao aritimetica
    private void comandoAtribuicao() {
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            match(tokens.get(TokenIndex).getLexema());
        }else{
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token esperado: VARIAVEL");
        }  
        match("<<");
        
        expressaoAritimetica();
    }

    // funcao para comando read 
    private void comandoEntrada() {
        match("read");
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            match(tokens.get(TokenIndex).getLexema());
        }else{
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token esperado: VARIAVEL");
        }    
    }
    
    // funcao para comando print
    private void comandoSaida() {
        match("print");
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            match(tokens.get(TokenIndex).getLexema());
        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Cadeia) {
            match(tokens.get(TokenIndex).getLexema());
        }else{
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token inesperado: " + tokens.get(TokenIndex).getLexema());
        }    
    }

    // funcao para comando if
    // chama expressao relacional
    // matche then
    // chama comando
    private void comandoCondicao() {
        match("if");
        expressaoRelacional(); 
        match("then"); 
        comando(); 

        if (TokenIndex < tokens.size() && tokens.get(TokenIndex).getLexema().equals("else")) {
            match("else"); 
            comando(); 
        }

    }
    
    // funcao para comando while
    // chama expressao relacional
    private void comandoRepeticao(){
        match("while");
        expressaoRelacional(); 
        match ("then");
        comando();
    }

    // funcao para subalgoritmo
    // matche start
    // chama lista de comandos
    // matche end
    private void subAlgoritmo() { 
        match("start");
        listaComandos();
        match ("end");
    }   

    // expressao aritimetica chama termo aritimetico
    // chama expressao aritimetica linha
    private void expressaoAritimetica(){
        termoAritimetico();
        expressaoAritimetica1();
    }

    // expressao aritimetica linha verifica se o proximo token é + ou -
    // chama termo aritimetico
    // chama expressao aritimetica linha recursivamente
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

    // termo aritimetico chama fator aritimetico
    // chama termo aritimetico linha
    private void termoAritimetico() {
        fatorAritimetico();
        termoAritimetico1();
    }

    // termo aritimetico linha verifica se o proximo token é * ou /
    // chama fator aritimetico
    // chama termo aritimetico linha recursivamente
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

    // fator aritimetico verifica se o token é um numero inteiro, real, variavel ou abre parenteses
    // chama expressao aritimetica caso seja um abre parenteses
    private void fatorAritimetico() {
        if (tokens.get(TokenIndex).getTipoToken() == TipoToken.NumInt) {
            match(tokens.get(TokenIndex).getLexema());

        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.NumReal) {
            match(tokens.get(TokenIndex).getLexema());;

        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.Var) {
            match(tokens.get(TokenIndex).getLexema());

        }else if (tokens.get(TokenIndex).getTipoToken() == TipoToken.AbrePar) {
            match("(");
            expressaoAritimetica();
            match(")");
        }else {
            throw new RuntimeException("Erro Sintatico: Linha "+  tokens.get(TokenIndex).getLinha() + " Token inesperado: " + tokens.get(TokenIndex).getLexema());
        }
    }
    
    // expressao relacional chama termo relacional
    // chama expressao relacional linha
    private void expressaoRelacional(){
        termoRelacional();
        expressaoRelacional1();
    }

    // expressao relacional linha verifica se o proximo token é or ou and
    // chama operador booleano
    // chama termo relacional
    // chama expressao relacional linha recursivamente
    private void expressaoRelacional1() {
        if (tokens.get(TokenIndex).getLexema().equals("or") || tokens.get(TokenIndex).getLexema().equals("and")) {
            operadorBooleano();
            termoRelacional();
            expressaoRelacional1();
        }else {
            return;
        }
    }

    // operador booleano verifica se o token é or ou and
    private void operadorBooleano(){
        if(tokens.get(TokenIndex).getLexema().equals("or")){
            match("or");
        }else if(tokens.get(TokenIndex).getLexema().equals("and")){
            match("and");
        }
    }

    // termo relacional verifica se o token é um abre parenteses
    // chama expressao relacional caso seja

    // chama expressao aritimetica
    // verifica se o token é um operador relacional
    // chama expressao aritimetica 
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

    // matche para verificar se o token é o esperado
    // caso seja vai para o proximo token
    private void match(String lexema) {
        if (tokens.get(TokenIndex).getLexema().equals(lexema)) {
            TokenIndex++;
        } else {
            throw new RuntimeException("Erro Sintatico: Linha "+ tokens.get(TokenIndex).getLinha() + " inesperado "+ tokens.get(TokenIndex).getLexema());
        }
    }
}
