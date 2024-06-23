grammar GyhRepaginadoLanguage;

@header{
	import java.util.*;
}

@members{
	private String _nomeVar; 
	private String _tipoVar;
	private String _valorVar;
	
	private Simbolo _simboloVar;
	
	private Stack<String> _pilhaCondicao = new Stack<String>();
	private String _varCondicao;
	private String _varCondicaoif;
	private String _varCondicaowhile;
	private String _varAux;
	//======
	private GeraCodigo prog = new GeraCodigo(); 
	
	private ArrayList<Comando> listCmd = new ArrayList<Comando>(); 
	private ArrayList<Comando> listCmdAux = new ArrayList<Comando>();
	private ArrayList<Comando> listCmdAux1 = new ArrayList<Comando>();

	private Stack<ArrayList<Comando>>  _pilhaComandos = new Stack<ArrayList<Comando>>();
	private Stack<ArrayList<Comando>>  _pilhaComandosAux = new Stack<ArrayList<Comando>>();
	private ArrayList<Comando> _bclComandos;

	private Stack<ArrayList<Comando>> _listTrue = new Stack<ArrayList<Comando>>();
	private ArrayList<Comando> _True = new ArrayList<Comando>();
	private Stack<ArrayList<Comando>> _listFalse = new Stack<ArrayList<Comando>>();
	private ArrayList<Comando> _False = new ArrayList<Comando>();

	//======
	private String _varId;
	private String _varExp;	


	private TabelaSimbolo _tabelaSimbolo = new TabelaSimbolo();
	
	public void imprimeTabelaSimbolo(TabelaSimbolo tabela){
		for(Simbolo s: tabela.getTabela().values()){
			System.out.println(s.toString());
		}
	}
	public void verificaVar(String nome){
		if(!_tabelaSimbolo.exists(nome)){
		System.out.println("\n Erro semantico, variavel nao declarada "+nome);
		} 
	}
    public static void imprimirPilha(Stack<ArrayList<Comando>> pilha) {
        System.out.println("Elementos da pilha:");
        for (ArrayList<Comando> elemento : pilha) {
            System.out.println(elemento);
        }
    }


	private String verificaTipoExp(String exp) {
		if (exp.matches("\\d+")) {
			return "integer";
		} else if (exp.matches("\\d+\\.\\d+")) {
			return "float";
		} else {
			return "indefinido"; 
		}
	}
}


programa: IniDelim PCDec FimDelim listaDeclaracoes 
		  IniDelim PCProg FimDelim listaComandos 
		  { prog.setTabela(_tabelaSimbolo);
		  	prog.setComando(_pilhaComandos.pop());
		    prog.geradorCodigo();
		    imprimeTabelaSimbolo(_tabelaSimbolo); System.out.println("\nAnalise Sintatica finalizada com sucesso! "); };

listaDeclaracoes: declaracao (listaDeclaracoes)?;

declaracao: Var IniDelim (PCInt | PCReal) FimDelim
			{ _nomeVar= _input.LT(-4).getText();
			  _tipoVar= _input.LT(-2).getText();
			  _valorVar= null;
			  
			  if(_tabelaSimbolo.exists(_nomeVar)==false){
			  		_simboloVar=new Simbolo(_nomeVar, _tipoVar, _valorVar);
			  		_tabelaSimbolo.setTabela(_simboloVar);	
			  }	
			  else{
			  	System.out.println("Erro semantico >> redeclaracao de variavel: "+_nomeVar);
			  }	  
			};//declaracao de var
expressaoAritmetica: termoAritmetico expressaoAritmeticalinha;

expressaoAritmeticalinha: 
				('+'  {_varExp += " + ";} termoAritmetico expressaoAritmeticalinha )?
				|('-' {_varExp += " - ";}  termoAritmetico expressaoAritmeticalinha)?;		

termoAritmetico: fatorAritmetico termoAritmeticolinha;

termoAritmeticolinha:
				('*' {_varExp += " * ";} fatorAritmetico termoAritmeticolinha)?
				|('/'{_varExp += " / ";} fatorAritmetico termoAritmeticolinha)? ; 

fatorAritmetico:  NumInt  {_varExp += _input.LT(-1).getText();}
				| NumReal {_varExp += _input.LT(-1).getText();}
				| Var     {_varExp += _input.LT(-1).getText();}
				| AbrePar {_varExp += " ( ";}
				   expressaoAritmetica 
				  FechaPar {_varExp += " ) ";}; 

expressaoRelacional: termoRelacional expressaoRelacional1;

expressaoRelacional1: (operadorBooleano  {_varCondicao+=" ";
										if(_input.LT(-1).getText().equals("and")){_varCondicao+="&& ";} 
										else{_varCondicao+="|| ";}}termoRelacional expressaoRelacional1)?;

termoRelacional: expressaoAritmetica    {_varCondicao+=_varExp; _varExp=" ";}
				 OpRel                  {_varCondicao+=" ";_varCondicao+=_input.LT(-1).getText();}
				 expressaoAritmetica    {_varCondicao+=_varExp; _varExp=" ";} 
				  
				 |AbrePar                {_varCondicao+=" ( ";}
				 expressaoRelacional 
				 FechaPar               {_varCondicao+=" ) ";};

operadorBooleano: 'or'| 'and';

listaComandos: {_bclComandos = new ArrayList<Comando>();
				_pilhaComandos.push(_bclComandos);} (comando )+;

comando: comandoEntrada | comandoSaida | comandoCondicao | comandoAtribuicao | subAlgoritmo | comandoRepeticao ; 

comandoEntrada: PCLer Var
						 { verificaVar(_input.LT(-1).getText());
						    ComandoLeitura cmd = new ComandoLeitura();
						    cmd.setId(_input.LT(-1).getText());
						    _pilhaComandos.peek().add(cmd);
						   };

comandoSaida: PCImprimir  (Var
						   { verificaVar(_input.LT(-1).getText());
						     ComandoEscrita cmd = new ComandoEscrita();
						     cmd.setId(_input.LT(-1).getText());
						    _pilhaComandos.peek().add(cmd);
						   }
						    
							|Cadeia {
								ComandoEscrita cmd = new ComandoEscrita();
								cmd.setCadeia(_input.LT(-1).getText());
								_pilhaComandos.peek().add(cmd);
							});

comandoCondicao:  PCSe {_varExp=""; _varCondicao=""; _varCondicaoif="";}
				  expressaoRelacional PCEntao {
					_bclComandos = new ArrayList<Comando>(); 
					_pilhaComandos.push(_bclComandos);
					_pilhaCondicao.push(_varCondicao);
					}comando
				  {
					imprimirPilha(_pilhaComandos);
					_True = _pilhaComandos.pop();
				  	_listTrue.push(_True);
				  } 
				  (PCSenao
				  {
					_bclComandos = new ArrayList<Comando>(); 
					_pilhaComandos.push(_bclComandos);
				  }
				   comando
				  {
					imprimirPilha(_pilhaComandos);
					_False = _pilhaComandos.pop();
				  	_listFalse.push(_False);
				  }
				  )?
				  {
					_True = _listTrue.pop();

					if (!_listFalse.isEmpty()) {
						_False = _listFalse.pop(); 
					}

					_varCondicaoif= _pilhaCondicao.pop();
					ComandoCondicao cmd= new ComandoCondicao(_varCondicaoif, _True, _False);
				   _pilhaComandos.peek().add(cmd); };				

comandoRepeticao: PCEnqto {_varExp=""; _varCondicaowhile=""; _varCondicao="";}
                    expressaoRelacional PCEntao 
					{
						_bclComandos = new ArrayList<Comando>();
						_pilhaComandos.push(_bclComandos);
						_pilhaCondicao.push(_varCondicao);
					}
					comando
                    {
						listCmdAux = _pilhaComandos.pop();
						_varCondicaowhile = _pilhaCondicao.pop(); 
						ComandoRepeticao cmd = new ComandoRepeticao(_varCondicaowhile, listCmdAux);
						_pilhaComandos.peek().add(cmd);
                    };

subAlgoritmo: PCIni (comando)+ PCFim;

comandoAtribuicao:  Var 
					{
					  verificaVar(_input.LT(-1).getText());
					  _varId=_input.LT(-1).getText();
					  _varExp="";
					}  
					Atrib expressaoAritmetica
					{
					   verificaVar(_varId);
						Simbolo simbolo = _tabelaSimbolo.getTabela().get(_varId);
						if (simbolo != null) {
							String tipoVar = simbolo.getTipo();
							String tipoExp = verificaTipoExp(_varExp);

							if (tipoVar.equals("integer") && tipoExp.equals("float")) {
								System.out.println("Erro semântico >> atribuição de float para inteiro na variável: " + _varId);
							} else if (tipoVar.equals("float") && tipoExp.equals("integer")) {
								System.out.println("Erro semântico >> atribuição de integer para float na variável: " + _varId);
							}
							ComandoAtribuicao cmd = new ComandoAtribuicao(_varId, _varExp);
							_pilhaComandos.peek().add(cmd);
						}
					};

//==========

FimDelim: ']';
IniDelim: '[';
Atrib: '<<';
OpRel: '>=' | '<=' | '>' | '<' | '<>' | '==';
AbrePar: '(';
FechaPar: ')';
OpBoolE: 'and';
OpBoolOu: 'or';
OpArit: '*' | '/' | '+' | '-' ;
PCProg: 'prog';
PCDec:  'dec';
PCInt: 'integer';
PCReal: 'float'; 
PCLer: 'read';
PCImprimir: 'print';
PCSe: 'if';
PCSenao: 'else';
PCEntao: 'then';
PCEnqto: 'while';
PCIni: 'start';
PCFim: 'end';

Var: [A-Z] ( [0-9] | [a-z] | [A-Z] )*;

Cadeia:  '"' ( [0-9] | [a-z] | [A-Z] | OpRel | Atrib )* '"';

NumInt: [0-9]+;

NumReal: [0-9]+ '.' [0-9]+;

WS: (' ' | '\n' | '\t')->skip;

Comentario: '#' ~('\n')* ->skip;