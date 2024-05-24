grammar GyhRepaginadoLanguage;

programa: IniDelim PCDec FimDelim;

IniDelim: '[';
FimDelim: ']';
Atrib: '<<';
OpRel: '>=' | '<=' | '>' | '<' | '<>';
PCProg: 'prog';
PCDec: 'dec';
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

Var: [A-Z] ([0-9] |[a-z] | [A-Z])*;
Cadeia: '"' ([0-9] |[a-z] | [A-Z] | OpRel | Atrib)* '"';
NumInt: [0-9]+;
NumReal: [0-9]+ '.' [0-9]+;

WS: (' ' | '\n' | '\t')->skip;
Comentario: '#' ~('\n')* ->skip;


programa : IniDelim PCDec FimDelim listaDeclaracoes IniDelim PCDec FimDelim listaComandos;

pistaDeclaracoes: declaracao (listaDeclaracoes)?;

declaracao: Var IniDelim tipoVar FimDelim;

tipoVar: 'integer' | 'float';

//arrumar
expressaoAritmetica: expressaoAritmetica '+' termoAritmetico | expressaoAritmetica '-' termoAritmetico | termoAritmetico;

termoAritmetico: termoAritmetico '*' fatorAritmetico | termoAritmetico '/' fatorAritmetico | fatorAritmetico;

fatorAritmetico : NumInt| NumReal | Var | '(' expressaoAritmetica ')'

expressaoRelacional: expressaoRelacional operadorBooleano termoRelacional | termoRelacional;

termoRelacional: expressaoAritmetica OP_REL expressaoAritmetica | '(' expressaoRelacional ')';

operadorBooleano: 'or' | 'and';

listaComandos: comando (listaComandos)? | comando;

comando: comandoAtribuicao | comandoEntrada | comandoSaida | comandoCondicao | comandoRepeticao | subAlgoritmo;

comandoAtribuicao: Var Atrib expressaoAritmetica;

comandoEntrada: 'read' Var;

comandoSaida: 'print'  Var | 'print' CADEIA;

comandoCondicao: 'if' expressaoRelacional 'then' comando | 'if' expressaoRelacional 'then' comando 'else' comando;

comandoRepeticao : 'while' expressaoRelacional 'then' comando;

subAlgoritmo → 'start' listaComandos 'end';
