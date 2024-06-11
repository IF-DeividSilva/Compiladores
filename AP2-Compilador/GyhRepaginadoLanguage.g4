grammar GyhRepaginadoLanguage;

@header{
	import java.util.*;
}

@members{
	private String _nomeVar; 
	private String _tipoVar;
	private String _valorVar;
	
	private Simbolo _simboloVar;
	
	private String _varCondicao;
	private String _varAux;
	//======
	private GeraCodigo prog = new GeraCodigo(); 
	
	private ArrayList<Comando> listCmd = new ArrayList<Comando>(); 
	private ArrayList<Comando> listCmdAux = new ArrayList<Comando>();

	private ArrayList<Comando> _listTrue = new ArrayList<Comando>();
	private ArrayList<Comando> _listFalse = new ArrayList<Comando>();

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
		System.out.println("\n Erro semantico, variavel nao declarada"+nome);
		}
	} 
}


programa: IniDelim PCDec FimDelim listaDeclaracoes 
		  IniDelim PCProg FimDelim listaComandos 
		  { prog.setTabela(_tabelaSimbolo);
		  	prog.setComando(listCmd);
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
			};//declaracao de variáveis

expressaoAritmetica: termoAritmetico expressaoAritmeticalinha;

expressaoAritmeticalinha: 
				('+'  {_varExp += " + ";} termoAritmetico expressaoAritmeticalinha )?
				|('-' {_varExp += " - ";}  termoAritmetico expressaoAritmeticalinha)?;		

termoAritmetico: fatorAritmetico termoAritmeticolinha;

termoAritmeticolinha:
				('*' {_varExp += " * ";} fatorAritmetico  termoAritmeticolinha)?
				|('/'{_varExp += " / ";} fatorAritmetico  termoAritmeticolinha)? ; 

fatorAritmetico:  NumInt  {_varExp += _input.LT(-1).getText();}
				| NumReal {_varExp += _input.LT(-1).getText();}
				| Var     {_varExp += _input.LT(-1).getText();}
				| AbrePar {_varExp += " ( ";}
				   expressaoAritmetica 
				  FechaPar {_varExp += " ) ";}; //aparentemente ok!!! 


//Colocar ExpressaoRelacional, TermoRelacional, OperadorBooleano

expressaoRelacional: (termoRelacional operadorBooleano  {_varCondicao+=" "+_input.LT(-1).getText()+" ";}
					)* termoRelacional ;

termoRelacional: expressaoAritmetica    {_varCondicao+=_varExp; _varExp=" ";}
				 OpRel                  {_varCondicao+=" ";_varCondicao+=_input.LT(-1).getText();}
				 expressaoAritmetica    {_varCondicao+=_varExp; _varExp=" ";} 
				  
				 |AbrePar                {_varCondicao+=" ( ";}
				 expressaoRelacional 
				 FechaPar               {_varCondicao+=" ) ";};


operadorBooleano: 'or'| 'and';

listaComandos: (comando 
					{
					   listCmd.addAll(listCmdAux);
					   listCmdAux.removeAll(listCmdAux);
					 }
			   )+;

comando: comandoEntrada | comandoSaida | comandoCondicao  |comandoAtribuicao| subAlgoritmo|comandoRepeticao ; //arrumar isso aqui!!!! (BOTAR O REPTICAO)


//Colocar ComandoEntrada | ComandoSaida | ComandoCondicao | ComandoRepeticao | SubAlgoritmo


comandoEntrada: PCLer Var
						 { verificaVar(_input.LT(-1).getText());
						    ComandoLeitura cmd = new ComandoLeitura();
						    cmd.setId(_input.LT(-1).getText());
						    listCmdAux.add(cmd);
						   };

comandoSaida: PCImprimir  (Var
						   { verificaVar(_input.LT(-1).getText());
						     ComandoEscrita cmd = new ComandoEscrita();
						     cmd.setId(_input.LT(-1).getText());
						     listCmdAux.add(cmd);
						   }
						    
							|Cadeia);


comandoCondicao:  PCSe {_varExp=""; _varCondicao="";}
				  expressaoRelacional PCEntao comando
				  {
				  	_listTrue.addAll(listCmdAux);
				  	listCmdAux.removeAll(listCmdAux);
				  } 
				  (PCSenao comando
				  {
				  	_listFalse.addAll(listCmdAux);
				  	listCmdAux.removeAll(listCmdAux);
				  }
				  )?
				  {ComandoCondicao cmd= new ComandoCondicao(_varCondicao, _listTrue, _listFalse);
				   listCmdAux.add(cmd); };
				  


subAlgoritmo: PCIni (comando)+ PCFim;


comandoAtribuicao:  Var 
					{
					  verificaVar(_input.LT(-1).getText());
					  _varId=_input.LT(-1).getText();
					  _varExp="";
					}  
					Atrib expressaoAritmetica
					{
					   ComandoAtribuicao cmd=new ComandoAtribuicao(_varId, _varExp);
					   listCmdAux.add(cmd); 	
					};



comandoRepeticao: PCEnqto {_varExp=""; _varCondicao="";}
					expressaoRelacional PCEntao comando
					{
					_listTrue.addAll(listCmdAux);
					listCmdAux.removeAll(listCmdAux);
					ComandoRepeticao cmd = new ComandoRepeticao(_varCondicao, _listTrue);
					listCmdAux.add(cmd);
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






