import java.util.LinkedList;
import java.util.StringTokenizer;

public class AnalisadorLexico {
    public static int analisador(String linha, int indice, LinkedList<Token> tokens, int controle)  {
        String input = linha;
        //tokenizer para quebrar as linhas em tokens onde tiver um espaço na linha
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        while (tokenizer.hasMoreTokens()) {
            //nome recebe o proximo token
            String nome = tokenizer.nextToken();
            // cases para analisar e criar os tokens conforme sua classificacao
            switch (nome) {
                case "[":
                    Token tokabrecol = new Token(TipoToken.IniDelim, nome);
                    tokens.add(tokabrecol);
                    break;
                case "]":
                    Token tokfechacol = new Token(TipoToken.FimDelim, nome);
                    tokens.add(tokfechacol);
                    break;
                case "dec":
                    Token tokdec = new Token(TipoToken.PCDec, nome); 
                    tokens.add(tokdec);  
                    controle = 1;
                    break;  
                case "integer":
                    Token tokint2 = new Token(TipoToken.PCInt, nome);
                    tokens.add(tokint2);
                    break;
                case "prog":
                    Token tokprog = new Token(TipoToken.PCProg, nome);
                    tokens.add(tokprog);
                    controle = 2;
                    break;
                case "float":
                    Token tokfloat = new Token(TipoToken.PCReal, nome);
                    tokens.add(tokfloat);
                    break;
                case "read":
                    Token tokread = new Token(TipoToken.PCLer, nome);
                    tokens.add(tokread);
                    break;
                    case "print":
                    Token tokprint = new Token(TipoToken.PCImprimir, nome);
                    tokens.add(tokprint);
                    break;
    
                    case "\"":
                    // caso tenha aspas duplas ele pega o proximo token e verifica se é uma cadeia de caracteres
                    // se for ele salva um token
                    // tbm tem uma verificacao para caso nao tenha aspas duplas no final da possivel cadeia, caso nao tenha configura um erro lexico
                    // pois cadeia necessariamente tem que ter aspas duplas no inicio e no final
                    // e se for só uma aspas dupla no começo sem nada tbm configura um erro lexico
                    if(tokenizer.hasMoreTokens()){
                            nome = tokenizer.nextToken();
                            String aux1 = nome;
                            if(tokenizer.hasMoreTokens()){
                                nome = tokenizer.nextToken();
                            } else {
                                System.out.println("#Erro Léxico: <"+aux1 +", linha: "+indice +">" );
                                break;
                            }
                            if (nome.equals("\"")){
                                Token tocadeia = new Token(TipoToken.Cadeia, aux1);
                                tokens.add(tocadeia);
                                break;
                            }
                        } else {
                            System.out.println("#Erro Léxico: <"+nome +", linha: "+indice +">" );
                            break;
                        }
                
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
                   break;
                case "+":
                    Token tokmais = new Token(TipoToken.OpAritSoma, nome);
                    tokens.add(tokmais);
                    break;
                case "-":
                    Token tokmenos = new Token(TipoToken.OpAritSub, nome);
                    tokens.add(tokmenos);
                    break;
                case "/":
                    Token tokdiv = new Token(TipoToken.OpAritDiv, nome);
                    tokens.add(tokdiv);
                    break;
                case "*":
                    Token tokmult = new Token(TipoToken.OpAritMult, nome);
                    tokens.add(tokmult);
                    break;        
                default:
                        // aux para validar var 
                        // caso auxx seja true ele faz o tokens  
                        boolean auxx=ValidaVar.validaVar(nome);
                        if (auxx==true){
                            Token tokvar = new Token(TipoToken.Var, nome);
                            tokens.add(tokvar);
                            break;
                            
                        }
                        // para validar numero inteiro
                        if (nome.matches("[0-9]+")){
                        Token toknum = new Token(TipoToken.NumInt, nome);
                        tokens.add(toknum);
                        break;
                        }
                        // para validar numero float
                        if (nome.matches("[+-]?\\d*\\.?\\d+")) {
                            Token toknum = new Token(TipoToken.NumReal, nome);
                            tokens.add(toknum);
                            break;
                        }
                        
                    else{
                        // caso nao seja nenhum dos casos acima ele configura um erro lexico
                        System.out.println("#Erro Léxico: <"+ nome +", linha: "+indice +">" );
                    }
            }
        }
        // retorna o controle para saber se está na parte de "dec" ou "prog"
        return controle;
    }
}
