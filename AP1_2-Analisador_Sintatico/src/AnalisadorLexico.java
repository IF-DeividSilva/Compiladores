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
                    Token tokabrecol = new Token(TipoToken.IniDelim, nome, indice);
                    tokens.add(tokabrecol);
                    break;
                case "]":
                    Token tokfechacol = new Token(TipoToken.FimDelim, nome, indice);
                    tokens.add(tokfechacol);
                    break;
                case "dec":
                    Token tokdec = new Token(TipoToken.PCDec, nome, indice); 
                    tokens.add(tokdec);  
                    controle = 1;
                    break;  
                case "integer":
                    Token tokint2 = new Token(TipoToken.PCInt, nome, indice);
                    tokens.add(tokint2);
                    break;
                case "prog":
                    Token tokprog = new Token(TipoToken.PCProg, nome, indice);
                    tokens.add(tokprog);
                    controle = 2;
                    break;
                case "float":
                    Token tokfloat = new Token(TipoToken.PCReal, nome, indice);
                    tokens.add(tokfloat);
                    break;
                case "read":
                    Token tokread = new Token(TipoToken.PCLer, nome, indice);
                    tokens.add(tokread);
                    break;
                    case "print":
                    Token tokprint = new Token(TipoToken.PCImprimir, nome, indice);
                    tokens.add(tokprint);
                    break;

                    
                    case "\"":
                    // Inicializa uma string para armazenar a cadeia de caracteres
                    StringBuilder cadeiaBuilder = new StringBuilder();
                
                    // Loop para coletar todos os tokens até encontrar uma aspa dupla de fechamento
                    while (tokenizer.hasMoreTokens()) {
                        String tokenAtual = tokenizer.nextToken();
                
                        // Verifica se o token atual é uma aspa dupla de fechamento
                        if (tokenAtual.equals("\"")) {
                            // Se for, não adiciona a aspa dupla de fechamento à cadeia
                            // Cria um novo token com a cadeia construída até agora
                            Token tocadeia = new Token(TipoToken.Cadeia, cadeiaBuilder.toString(), indice);
                            tokens.add(tocadeia);
                            break; // Sai do loop
                        } else {
                            // Adiciona o token atual à cadeia
                            cadeiaBuilder.append(tokenAtual);
                            // Adiciona um espaço após o token, exceto após a aspa dupla de fechamento
                            if (tokenizer.hasMoreTokens()) {
                                cadeiaBuilder.append(" ");
                            }
                        }
                    }
                
                    // Verifica se o loop terminou sem encontrar uma aspa dupla de fechamento
                    if (!cadeiaBuilder.toString().endsWith("\"")) {
                        // Se não encontrou, configura um erro léxico
                        System.out.println("#Erro Léxico: <" + cadeiaBuilder.toString() + ", linha: " + indice + ">");
                    }
                    break; // Sai do switch
                
                
                
                case "if":
                    Token tokif= new Token(TipoToken.PCSe, nome, indice);
                    tokens.add(tokif); 
                    break;
                case "else":
                    Token tokelse = new Token(TipoToken.PCSenao, nome, indice);
                    tokens.add(tokelse);
                    break;
                case "then":
                    Token tokthen = new Token(TipoToken.PCEntao, nome ,indice);
                    tokens.add(tokthen);
                    break;
                case "while":
                    Token tokwhile = new Token(TipoToken.PCEnqto, nome, indice);
                    tokens.add(tokwhile);
                    break;
                case "start":
                    Token tokstart = new Token(TipoToken.PCIni, nome, indice);
                    tokens.add(tokstart);
                    break;
                case "end":
                    Token tokend = new Token(TipoToken.PCFim, nome, indice);
                    tokens.add(tokend);
                    break;
                case "<<":
                    Token tokatrib = new Token(TipoToken.Atrib, nome, indice);
                    tokens.add(tokatrib);
                    break;
                case  "<":
                    Token tokmenor = new Token(TipoToken.OpRelMenor, nome, indice);
                    tokens.add(tokmenor);
                    break;
                case "<=":
                    Token tokmenorigual = new Token(TipoToken.OpRelMenorIgual, nome, indice);
                    tokens.add(tokmenorigual);
                    break;
                case ">":
                    Token tokmaior = new Token(TipoToken.OpRelMaior, nome, indice);
                    tokens.add(tokmaior);
                    break;
                case "==":
                    Token tokequal = new Token(TipoToken.OpRelIgual, nome, indice);
                    tokens.add(tokequal);
                    break;
                case ">=":
                    Token tokmaiorigual = new Token(TipoToken.OpRelMaiorIgual, nome ,indice);
                    tokens.add(tokmaiorigual);
                    break;
                case "<>":
                    Token tokdiferente = new Token(TipoToken.OpRelDif, nome ,indice);
                    tokens.add(tokdiferente);
                    break;
                case "and":
                    Token tokand = new Token(TipoToken.OpBoolE, nome ,indice);
                    tokens.add(tokand);
                    break;
                case "or":
                    Token tokor = new Token(TipoToken.OpBoolOu, nome , indice  );
                    tokens.add(tokor);
                    break;
                case "(":
                    Token tokabrepar = new Token(TipoToken.AbrePar, nome, indice);
                    tokens.add(tokabrepar);
                    break;
                case ")":
                    Token tokfechapar = new Token(TipoToken.FechaPar, nome, indice);
                    tokens.add(tokfechapar);
                    break;
                case " ":
                   break;
                case "+":
                    Token tokmais = new Token(TipoToken.OpAritSoma, nome, indice);
                    tokens.add(tokmais);
                    break;
                case "-":
                    Token tokmenos = new Token(TipoToken.OpAritSub, nome, indice);
                    tokens.add(tokmenos);
                    break;
                case "/":
                    Token tokdiv = new Token(TipoToken.OpAritDiv, nome, indice );
                    tokens.add(tokdiv);
                    break;
                case "*":
                    Token tokmult = new Token(TipoToken.OpAritMult, nome, indice);
                    tokens.add(tokmult);
                    break;        
                default:
                        // aux para validar var 
                        // caso auxx seja true ele faz o tokens  
                        boolean auxx=ValidaVar.validaVar(nome);
                        if (auxx==true){
                            Token tokvar = new Token(TipoToken.Var, nome, indice);
                            tokens.add(tokvar);
                            break;
                            
                        }
                        // para validar numero inteiro
                        if (nome.matches("[0-9]+")){
                        Token toknum = new Token(TipoToken.NumInt, nome, indice);
                        tokens.add(toknum);
                        break;
                        }
                        // para validar numero float
                        if (nome.matches("[+-]?\\d*\\.?\\d+")) {
                            Token toknum = new Token(TipoToken.NumReal, nome, indice);
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
