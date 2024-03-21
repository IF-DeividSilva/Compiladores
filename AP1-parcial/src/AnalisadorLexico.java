import java.util.LinkedList;
import java.util.StringTokenizer;

public class AnalisadorLexico {
    public static int analisador(String linha, int indice, LinkedList<Token> tokens, int controle)  {
        String input = linha;
        Token tok1 = new Token(TipoToken.IniDelim, "[ ");;
        Token tok2 = new Token(TipoToken.FimDelim, "] ");;

        StringTokenizer tokenizer = new StringTokenizer(input, "[]  ()");
        while (tokenizer.hasMoreTokens()) {
            String nome = tokenizer.nextToken();
            switch (nome) {
                case "dec":
                    Token tokdec = new Token(TipoToken.PCDec, nome);
                    tokens.add(tok1);
                    tokens.add(tokdec);
                    tokens.add(tok2);
                    controle = 1;
                    break;
                case "integer":
                    String[] partes = input.split(" ");
                    String aux1 = partes[0];
                    boolean auxx=ValidaVar.validaVar(aux1);
                    if (auxx==true){
                        Token tokvar = new Token(TipoToken.Var, nome);
                        tokens.add(tokvar);
                    }
                    else{
                        System.out.println("ERRO var invalida linha: " + indice);
                        // erro de var invalida
                    }
                    if (partes.length >= 2) {
                        // Corrigindo a linha para usar substring e dividila a string em duas partes
                        int index = aux1.indexOf('[');
                        if (index != -1) {
                            aux1 = aux1.substring(index + 1); // Extrai tudo após o '['
                        }
                        String aux2 = partes[1];
                        aux2 = aux2.replace("[", "").replace("]", "");
                        Token tokint1 = new Token(TipoToken.Var, aux1);
                        Token tokint2 = new Token(TipoToken.PCInt, aux2);
                        tokens.add(tokint1);
                        tokens.add(tok1);
                        tokens.add(tokint2);
                        tokens.add(tok2);
                    }
                    break;
                
                case "prog":
                    Token tokprog = new Token(TipoToken.PCProg, nome);
                    tokens.add(tok1);
                    tokens.add(tokprog);
                    tokens.add(tok2);
                    controle = 2;
                    break;
                case "float":
                    Token tokfloat = new Token(TipoToken.PCReal, nome);
                    tokens.add(tok1);
                    tokens.add(tokfloat);
                    tokens.add(tok2);
                    break;
                case "read":
                    Token tokread = new Token(TipoToken.PCLer, nome);
                    tokens.add(tokread);
                    // para pegar o que vem depois da palavra chave "read"
                    String keyword = nome;
                    String proximo = "";
                    int index = input.indexOf(keyword);
                    if (index != -1) {
                    // Adiciona 1 ao índice para pular a palavra "read" e começar a partir do próximo caractere
                    proximo = input.substring(index + keyword.length()).trim();
                    }
                    // fazer outra classe para conferir se é uma variável valida (declarada)
                    boolean varOk = VerificaVar.verifica(proximo, tokens);
                    if (varOk == true) {
                        System.out.println("OKOK");
                        Token tokvarOk = new Token(TipoToken.Var, proximo);
                        tokens.add(tokvarOk);

                    }
                    else{
                        System.out.println("ERRO var nao declarada linha: " + indice);
                        // erro de var nao declarada
                    }


                    break;
                case "print":
                    Token tokprint = new Token(TipoToken.PCImprimir, nome);
                    tokens.add(tokprint);                    
                break;
                case "if":
                    Token tokif= new Token(TipoToken.PCSe, nome);
                    tokens.add(tokif); 
                    break;
                case "else":
                    Token tokelse = new Token(TipoToken.PCSenao, nome);
                    tokens.add(tokelse);
                    break;
                case "then":
                    Token tokthen = new Token(TipoToken.PCEntao, nome);
                    tokens.add(tokthen);
                    break;
                case "while":
                    Token tokwhile = new Token(TipoToken.PCEnqto, nome);
                    tokens.add(tokwhile);
                    break;
                case "start":
                    Token tokstart = new Token(TipoToken.PCIni, nome);
                    tokens.add(tokstart);
                    break;
                case "end":
                    Token tokend = new Token(TipoToken.PCFim, nome);
                    tokens.add(tokend);
                    break;
                case "<<":
                    Token tokatrib = new Token(TipoToken.Atrib, nome);
                    tokens.add(tokatrib);
                    break;
                case  "<":
                    Token tokmenor = new Token(TipoToken.OpRelMenor, nome);
                    tokens.add(tokmenor);
                    break;
                case "<=":
                    Token tokmenorigual = new Token(TipoToken.OpRelMenorIgual, nome);
                    tokens.add(tokmenorigual);
                    break;
                case ">":
                    Token tokmaior = new Token(TipoToken.OpRelMaior, nome);
                    tokens.add(tokmaior);
                    break;
                case "==":
                    Token tokequal = new Token(TipoToken.OpRelIgual, nome);
                    tokens.add(tokequal);
                    break;
                case ">=":
                    Token tokmaiorigual = new Token(TipoToken.OpRelMaiorIgual, nome);
                    tokens.add(tokmaiorigual);
                    break;
                case "<>":
                    Token tokdiferente = new Token(TipoToken.OpRelDif, nome);
                    tokens.add(tokdiferente);
                    break;
                case "and":
                    Token tokand = new Token(TipoToken.OpBoolE, nome);
                    tokens.add(tokand);
                    break;
                case "or":
                    Token tokor = new Token(TipoToken.OpBoolOu, nome);
                    tokens.add(tokor);
                    break;
                case "(":
                    Token tokabrepar = new Token(TipoToken.AbrePar, nome);
                    tokens.add(tokabrepar);
                    break;
                case ")":
                    Token tokfechapar = new Token(TipoToken.FechaPar, nome);
                    tokens.add(tokfechapar);
                    break;
                case " ":
                   
                default:
                    if (controle == 1){
                        //está na parte de declaração de variaveis
                        break;
                    }else if(VerificaVar.verifica(nome, tokens) == true){
                        Token tokvar = new Token(TipoToken.Var, nome);
                        tokens.add(tokvar);
                        break;

                    }else{
                        System.out.println("ERRO lexico desconhecido linha: " + indice);
                    }
            }
        }
        return controle;

    }
}
