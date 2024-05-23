grammarGyhRepaginada;

Programa: IniDelim PCDec FimDelim;




Atrib: '<<';
OpRel: '>=' | '<=' | '<' | '<>';
PCProg: 'prog';
PCDec: 'dec';


Var: [A-Z] ( [0-9] | [a-z] | [A-Z] )*;
Cadeia: '"' [A-Z] ( [0-9] | [a-z] | [A-Z] )* | OpRel | Atrib '"'

NumInt: [0-9]+;



