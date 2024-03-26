import java.util.LinkedList;
import java.util.StringTokenizer;

public class AnalisadorLexico {
    public static int analisador(String linha, int indice, LinkedList<Token> tokens, int controle)  {
        String input = linha;
        //tokenizer para quebrar as linhas em tokens onde tiver um espaço na linha e
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        while (tokenizer.hasMoreTokens()) {
            //nome recebe o proximo token
            String nome = tokenizer.nextToken();
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
                    // fazer verificacao de cadeia
                    // ?????consigo fazer um case aspas duplas????????
                    nome = tokenizer.nextToken();
                    if (nome.equals("\"")){
                        nome = tokenizer.nextToken();
                        Token tocadeia = new Token(TipoToken.Cadeia, nome);
                        tokens.add(tocadeia);
                        nome = tokenizer.nextToken();
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
                        if (nome.matches("[0-9]+")){
                        Token toknum = new Token(TipoToken.NumInt, nome);
                        tokens.add(toknum);
                        break;
                    }
                    else{
                        System.out.println("#Erro Léxico: <"+ nome +", linha: "+indice +">" );
                    }
            }
        }
        return controle;
    }
}
