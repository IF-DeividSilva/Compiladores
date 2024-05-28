grammar GyhRepaginadoLanguage;
@header{
	//import libs
}

@members{
	private String _nomeVar;
	private String _tipoVar;
	private String _valorVar; 

	private Simbolo _simboloVar;

	private TabelaSimbolo _tabelaVar = new TabelaSimbolos();

	public void imprimeTabelaSimbolo(TabelaSimbolo tabela){
		for (Simbolo s: tabela.getTabela.values()){
			System.out.println(s.toString();)
		}
	}
}



programa: IniDelim PCDec FimDelim listaDeclaracoes 
		  IniDelim PCProg FimDelim listaComandos 
		  {System.out.println("\nAnalise Sintatica finalizada com sucesso! Tendo a variavel "); };

listaDeclaracoes: declaracao (listaDeclaracoes)?;

declaracao: Var IniDelim (PCInt | PCReal) FimDelim {_nomeVar = _input.LT(-4).getText(); _tipoVar = _input.LT(-2).getText(); _valorVar = null; _simboloVar= new Simbolo(_nomeVar, _tipoVar, _valorVar); _simboloVar.set(_simboloVar);};

expressaoAritmetica: termoAritmetico 	 
		('+' termoAritmetico {System.out.print("  "+_input.LT(-2).getText()+"  ");}  )?; //arrumar isso aqui!!!!

termoAritmetico: fatorAritmetico {System.out.print(" "+_input.LT(-1).getText()+" ");} 
				('*' fatorAritmetico  {System.out.print("  "+_input.LT(-2).getText()+"  ");}  )?; //arrumar isso aqui!!!!

fatorAritmetico: NumInt| NumReal | Var
				 {System.out.print("  "+_input.LT(-1).getText()+"  ");}; //arrumar isso aqui!!!!; //arrumar isso aqui!!!!

//Colocar ExpressaoRelacional, TermoRelacional, OperadorBooleano

listaComandos: comando (listaComandos)?;

comando: comandoAtribuicao; //arrumar isso aqui!!!!


//Colocar ComandoEntrada | ComandoSaida | ComandoCondicao | ComandoRepeticao | SubAlgoritmo


comandoAtribuicao: Var Atrib {System.out.print("\nComando Atribuicao: "+ _input.LT(-2).getText()+" "+_input.LT(-1).getText());} expressaoAritmetica;


//==========


FimDelim: ']';
IniDelim: '[';
Atrib: '<<';
OpRel: '>=' | '<=' | '>' | '<' | '<>' | '==';
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





