// Generated from c:/Users/deivi/OneDrive/Área de Trabalho/UTFPR/6 periodo/Compiladores/AP2-Compilador/GyhRepaginadoLanguage.g4 by ANTLR 4.13.1

	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GyhRepaginadoLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, FimDelim=5, IniDelim=6, Atrib=7, OpRel=8, 
		AbrePar=9, FechaPar=10, OpBoolE=11, OpBoolOu=12, OpArit=13, PCProg=14, 
		PCDec=15, PCInt=16, PCReal=17, PCLer=18, PCImprimir=19, PCSe=20, PCSenao=21, 
		PCEntao=22, PCEnqto=23, PCIni=24, PCFim=25, Var=26, Cadeia=27, NumInt=28, 
		NumReal=29, WS=30, Comentario=31;
	public static final int
		RULE_programa = 0, RULE_listaDeclaracoes = 1, RULE_declaracao = 2, RULE_expressaoAritmetica = 3, 
		RULE_expressaoAritmeticalinha = 4, RULE_termoAritmetico = 5, RULE_termoAritmeticolinha = 6, 
		RULE_fatorAritmetico = 7, RULE_expressaoRelacional = 8, RULE_expressaoRelacional1 = 9, 
		RULE_termoRelacional = 10, RULE_operadorBooleano = 11, RULE_listaComandos = 12, 
		RULE_comando = 13, RULE_comandoEntrada = 14, RULE_comandoSaida = 15, RULE_comandoCondicao = 16, 
		RULE_comandoRepeticao = 17, RULE_subAlgoritmo = 18, RULE_comandoAtribuicao = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaDeclaracoes", "declaracao", "expressaoAritmetica", 
			"expressaoAritmeticalinha", "termoAritmetico", "termoAritmeticolinha", 
			"fatorAritmetico", "expressaoRelacional", "expressaoRelacional1", "termoRelacional", 
			"operadorBooleano", "listaComandos", "comando", "comandoEntrada", "comandoSaida", 
			"comandoCondicao", "comandoRepeticao", "subAlgoritmo", "comandoAtribuicao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "']'", "'['", "'<<'", null, "'('", 
			"')'", "'and'", "'or'", null, "'prog'", "'dec'", "'integer'", "'float'", 
			"'read'", "'print'", "'if'", "'else'", "'then'", "'while'", "'start'", 
			"'end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "FimDelim", "IniDelim", "Atrib", "OpRel", 
			"AbrePar", "FechaPar", "OpBoolE", "OpBoolOu", "OpArit", "PCProg", "PCDec", 
			"PCInt", "PCReal", "PCLer", "PCImprimir", "PCSe", "PCSenao", "PCEntao", 
			"PCEnqto", "PCIni", "PCFim", "Var", "Cadeia", "NumInt", "NumReal", "WS", 
			"Comentario"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GyhRepaginadoLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
		private ArrayList<Comando> _bclComandos;

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
			System.out.println("\n Erro semantico, variavel nao declarada "+nome);
			} 
		}
		public void printComandos(ArrayList<Comando> comandos) {
			for (Comando comando : comandos) {
				System.out.println(comando.toString());
			}
		}

	public GyhRepaginadoLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public List<TerminalNode> IniDelim() { return getTokens(GyhRepaginadoLanguageParser.IniDelim); }
		public TerminalNode IniDelim(int i) {
			return getToken(GyhRepaginadoLanguageParser.IniDelim, i);
		}
		public TerminalNode PCDec() { return getToken(GyhRepaginadoLanguageParser.PCDec, 0); }
		public List<TerminalNode> FimDelim() { return getTokens(GyhRepaginadoLanguageParser.FimDelim); }
		public TerminalNode FimDelim(int i) {
			return getToken(GyhRepaginadoLanguageParser.FimDelim, i);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public TerminalNode PCProg() { return getToken(GyhRepaginadoLanguageParser.PCProg, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(IniDelim);
			setState(41);
			match(PCDec);
			setState(42);
			match(FimDelim);
			setState(43);
			listaDeclaracoes();
			setState(44);
			match(IniDelim);
			setState(45);
			match(PCProg);
			setState(46);
			match(FimDelim);
			setState(47);
			listaComandos();
			 prog.setTabela(_tabelaSimbolo);
					  	prog.setComando(_pilhaComandos.pop());
					    prog.geradorCodigo();
					    imprimeTabelaSimbolo(_tabelaSimbolo); System.out.println("\nAnalise Sintatica finalizada com sucesso! "); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaDeclaracoesContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public ListaDeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracoes; }
	}

	public final ListaDeclaracoesContext listaDeclaracoes() throws RecognitionException {
		ListaDeclaracoesContext _localctx = new ListaDeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaDeclaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			declaracao();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Var) {
				{
				setState(51);
				listaDeclaracoes();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public TerminalNode IniDelim() { return getToken(GyhRepaginadoLanguageParser.IniDelim, 0); }
		public TerminalNode FimDelim() { return getToken(GyhRepaginadoLanguageParser.FimDelim, 0); }
		public TerminalNode PCInt() { return getToken(GyhRepaginadoLanguageParser.PCInt, 0); }
		public TerminalNode PCReal() { return getToken(GyhRepaginadoLanguageParser.PCReal, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(Var);
			setState(55);
			match(IniDelim);
			setState(56);
			_la = _input.LA(1);
			if ( !(_la==PCInt || _la==PCReal) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(57);
			match(FimDelim);
			 _nomeVar= _input.LT(-4).getText();
						  _tipoVar= _input.LT(-2).getText();
						  _valorVar= null;
						  
						  if(_tabelaSimbolo.exists(_nomeVar)==false){
						  		_simboloVar=new Simbolo(_nomeVar, _tipoVar, _valorVar);
						  		_tabelaSimbolo.setTabela(_simboloVar);	
						  }	
						  else{
						  	System.out.println("Erro semantico >> redeclaracao de variavel: "+_nomeVar);
						  }	  
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoAritmeticaContext extends ParserRuleContext {
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public ExpressaoAritmeticalinhaContext expressaoAritmeticalinha() {
			return getRuleContext(ExpressaoAritmeticalinhaContext.class,0);
		}
		public ExpressaoAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmetica; }
	}

	public final ExpressaoAritmeticaContext expressaoAritmetica() throws RecognitionException {
		ExpressaoAritmeticaContext _localctx = new ExpressaoAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expressaoAritmetica);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			termoAritmetico();
			setState(61);
			expressaoAritmeticalinha();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoAritmeticalinhaContext extends ParserRuleContext {
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public ExpressaoAritmeticalinhaContext expressaoAritmeticalinha() {
			return getRuleContext(ExpressaoAritmeticalinhaContext.class,0);
		}
		public ExpressaoAritmeticalinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmeticalinha; }
	}

	public final ExpressaoAritmeticalinhaContext expressaoAritmeticalinha() throws RecognitionException {
		ExpressaoAritmeticalinhaContext _localctx = new ExpressaoAritmeticalinhaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressaoAritmeticalinha);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(63);
					match(T__0);
					_varExp += " + ";
					setState(65);
					termoAritmetico();
					setState(66);
					expressaoAritmeticalinha();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(70);
					match(T__1);
					_varExp += " - ";
					setState(72);
					termoAritmetico();
					setState(73);
					expressaoAritmeticalinha();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoAritmeticoContext extends ParserRuleContext {
		public FatorAritmeticoContext fatorAritmetico() {
			return getRuleContext(FatorAritmeticoContext.class,0);
		}
		public TermoAritmeticolinhaContext termoAritmeticolinha() {
			return getRuleContext(TermoAritmeticolinhaContext.class,0);
		}
		public TermoAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmetico; }
	}

	public final TermoAritmeticoContext termoAritmetico() throws RecognitionException {
		TermoAritmeticoContext _localctx = new TermoAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_termoAritmetico);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			fatorAritmetico();
			setState(80);
			termoAritmeticolinha();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoAritmeticolinhaContext extends ParserRuleContext {
		public FatorAritmeticoContext fatorAritmetico() {
			return getRuleContext(FatorAritmeticoContext.class,0);
		}
		public TermoAritmeticolinhaContext termoAritmeticolinha() {
			return getRuleContext(TermoAritmeticolinhaContext.class,0);
		}
		public TermoAritmeticolinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmeticolinha; }
	}

	public final TermoAritmeticolinhaContext termoAritmeticolinha() throws RecognitionException {
		TermoAritmeticolinhaContext _localctx = new TermoAritmeticolinhaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_termoAritmeticolinha);
		int _la;
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(82);
					match(T__2);
					_varExp += " * ";
					setState(84);
					fatorAritmetico();
					setState(85);
					termoAritmeticolinha();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(89);
					match(T__3);
					_varExp += " / ";
					setState(91);
					fatorAritmetico();
					setState(92);
					termoAritmeticolinha();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorAritmeticoContext extends ParserRuleContext {
		public TerminalNode NumInt() { return getToken(GyhRepaginadoLanguageParser.NumInt, 0); }
		public TerminalNode NumReal() { return getToken(GyhRepaginadoLanguageParser.NumReal, 0); }
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public TerminalNode AbrePar() { return getToken(GyhRepaginadoLanguageParser.AbrePar, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GyhRepaginadoLanguageParser.FechaPar, 0); }
		public FatorAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatorAritmetico; }
	}

	public final FatorAritmeticoContext fatorAritmetico() throws RecognitionException {
		FatorAritmeticoContext _localctx = new FatorAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fatorAritmetico);
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NumInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(NumInt);
				_varExp += _input.LT(-1).getText();
				}
				break;
			case NumReal:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(NumReal);
				_varExp += _input.LT(-1).getText();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(Var);
				_varExp += _input.LT(-1).getText();
				}
				break;
			case AbrePar:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				match(AbrePar);
				_varExp += " ( ";
				setState(106);
				expressaoAritmetica();
				setState(107);
				match(FechaPar);
				_varExp += " ) ";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoRelacionalContext extends ParserRuleContext {
		public TermoRelacionalContext termoRelacional() {
			return getRuleContext(TermoRelacionalContext.class,0);
		}
		public ExpressaoRelacional1Context expressaoRelacional1() {
			return getRuleContext(ExpressaoRelacional1Context.class,0);
		}
		public ExpressaoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacional; }
	}

	public final ExpressaoRelacionalContext expressaoRelacional() throws RecognitionException {
		ExpressaoRelacionalContext _localctx = new ExpressaoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressaoRelacional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			termoRelacional();
			setState(113);
			expressaoRelacional1();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoRelacional1Context extends ParserRuleContext {
		public OperadorBooleanoContext operadorBooleano() {
			return getRuleContext(OperadorBooleanoContext.class,0);
		}
		public TermoRelacionalContext termoRelacional() {
			return getRuleContext(TermoRelacionalContext.class,0);
		}
		public ExpressaoRelacional1Context expressaoRelacional1() {
			return getRuleContext(ExpressaoRelacional1Context.class,0);
		}
		public ExpressaoRelacional1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacional1; }
	}

	public final ExpressaoRelacional1Context expressaoRelacional1() throws RecognitionException {
		ExpressaoRelacional1Context _localctx = new ExpressaoRelacional1Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressaoRelacional1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpBoolE || _la==OpBoolOu) {
				{
				setState(115);
				operadorBooleano();
				_varCondicao+=" ";
														if(_input.LT(-1).getText().equals("and")){_varCondicao+="&& ";} 
														else{_varCondicao+="|| ";}
				setState(117);
				termoRelacional();
				setState(118);
				expressaoRelacional1();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoRelacionalContext extends ParserRuleContext {
		public List<ExpressaoAritmeticaContext> expressaoAritmetica() {
			return getRuleContexts(ExpressaoAritmeticaContext.class);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica(int i) {
			return getRuleContext(ExpressaoAritmeticaContext.class,i);
		}
		public TerminalNode OpRel() { return getToken(GyhRepaginadoLanguageParser.OpRel, 0); }
		public TerminalNode AbrePar() { return getToken(GyhRepaginadoLanguageParser.AbrePar, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GyhRepaginadoLanguageParser.FechaPar, 0); }
		public TermoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoRelacional; }
	}

	public final TermoRelacionalContext termoRelacional() throws RecognitionException {
		TermoRelacionalContext _localctx = new TermoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termoRelacional);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				expressaoAritmetica();
				_varCondicao+=_varExp; _varExp=" ";
				setState(124);
				match(OpRel);
				_varCondicao+=" ";_varCondicao+=_input.LT(-1).getText();
				setState(126);
				expressaoAritmetica();
				_varCondicao+=_varExp; _varExp=" ";
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(AbrePar);
				_varCondicao+=" ( ";
				setState(131);
				expressaoRelacional();
				setState(132);
				match(FechaPar);
				_varCondicao+=" ) ";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperadorBooleanoContext extends ParserRuleContext {
		public TerminalNode OpBoolOu() { return getToken(GyhRepaginadoLanguageParser.OpBoolOu, 0); }
		public TerminalNode OpBoolE() { return getToken(GyhRepaginadoLanguageParser.OpBoolE, 0); }
		public OperadorBooleanoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorBooleano; }
	}

	public final OperadorBooleanoContext operadorBooleano() throws RecognitionException {
		OperadorBooleanoContext _localctx = new OperadorBooleanoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operadorBooleano);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==OpBoolE || _la==OpBoolOu) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ListaComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaComandos; }
	}

	public final ListaComandosContext listaComandos() throws RecognitionException {
		ListaComandosContext _localctx = new ListaComandosContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listaComandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			_bclComandos = new ArrayList<Comando>();
							_pilhaComandos.push(_bclComandos);
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				comando();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 94109696L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public ComandoEntradaContext comandoEntrada() {
			return getRuleContext(ComandoEntradaContext.class,0);
		}
		public ComandoSaidaContext comandoSaida() {
			return getRuleContext(ComandoSaidaContext.class,0);
		}
		public ComandoCondicaoContext comandoCondicao() {
			return getRuleContext(ComandoCondicaoContext.class,0);
		}
		public ComandoAtribuicaoContext comandoAtribuicao() {
			return getRuleContext(ComandoAtribuicaoContext.class,0);
		}
		public SubAlgoritmoContext subAlgoritmo() {
			return getRuleContext(SubAlgoritmoContext.class,0);
		}
		public ComandoRepeticaoContext comandoRepeticao() {
			return getRuleContext(ComandoRepeticaoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comando);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PCLer:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				comandoEntrada();
				}
				break;
			case PCImprimir:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				comandoSaida();
				}
				break;
			case PCSe:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				comandoCondicao();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				comandoAtribuicao();
				}
				break;
			case PCIni:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				subAlgoritmo();
				}
				break;
			case PCEnqto:
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				comandoRepeticao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoEntradaContext extends ParserRuleContext {
		public TerminalNode PCLer() { return getToken(GyhRepaginadoLanguageParser.PCLer, 0); }
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public ComandoEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEntrada; }
	}

	public final ComandoEntradaContext comandoEntrada() throws RecognitionException {
		ComandoEntradaContext _localctx = new ComandoEntradaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comandoEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(PCLer);
			setState(154);
			match(Var);
			 verificaVar(_input.LT(-1).getText());
									    ComandoLeitura cmd = new ComandoLeitura();
									    cmd.setId(_input.LT(-1).getText());
									    _pilhaComandos.peek().add(cmd);
									   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode PCImprimir() { return getToken(GyhRepaginadoLanguageParser.PCImprimir, 0); }
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public TerminalNode Cadeia() { return getToken(GyhRepaginadoLanguageParser.Cadeia, 0); }
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
	}

	public final ComandoSaidaContext comandoSaida() throws RecognitionException {
		ComandoSaidaContext _localctx = new ComandoSaidaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoSaida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(PCImprimir);
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				{
				setState(158);
				match(Var);
				 verificaVar(_input.LT(-1).getText());
										     ComandoEscrita cmd = new ComandoEscrita();
										     cmd.setId(_input.LT(-1).getText());
										    _pilhaComandos.peek().add(cmd);
										   
				}
				break;
			case Cadeia:
				{
				setState(160);
				match(Cadeia);

												ComandoEscrita cmd = new ComandoEscrita();
												cmd.setCadeia(_input.LT(-1).getText());
												_pilhaComandos.peek().add(cmd);
											
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoCondicaoContext extends ParserRuleContext {
		public TerminalNode PCSe() { return getToken(GyhRepaginadoLanguageParser.PCSe, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode PCEntao() { return getToken(GyhRepaginadoLanguageParser.PCEntao, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public TerminalNode PCSenao() { return getToken(GyhRepaginadoLanguageParser.PCSenao, 0); }
		public ComandoCondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicao; }
	}

	public final ComandoCondicaoContext comandoCondicao() throws RecognitionException {
		ComandoCondicaoContext _localctx = new ComandoCondicaoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comandoCondicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(PCSe);
			_varExp=""; _varCondicao=""; _varCondicaoif="";
			setState(166);
			expressaoRelacional();
			setState(167);
			match(PCEntao);

								_bclComandos = new ArrayList<Comando>(); 
								_pilhaComandos.push(_bclComandos);
								_pilhaCondicao.push(_varCondicao);
								
			setState(169);
			comando();

							  	_listTrue = _pilhaComandos.pop();
							  
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(171);
				match(PCSenao);

									_bclComandos = new ArrayList<Comando>(); 
									_pilhaComandos.push(_bclComandos);
								  
				setState(173);
				comando();

								  	_listFalse = _pilhaComandos.pop();
								  
				}
				break;
			}

								_varCondicaoif= _pilhaCondicao.pop();
								ComandoCondicao cmd= new ComandoCondicao(_varCondicaoif, _listTrue, _listFalse);
							   _pilhaComandos.peek().add(cmd); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoRepeticaoContext extends ParserRuleContext {
		public TerminalNode PCEnqto() { return getToken(GyhRepaginadoLanguageParser.PCEnqto, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode PCEntao() { return getToken(GyhRepaginadoLanguageParser.PCEntao, 0); }
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ComandoRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRepeticao; }
	}

	public final ComandoRepeticaoContext comandoRepeticao() throws RecognitionException {
		ComandoRepeticaoContext _localctx = new ComandoRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comandoRepeticao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(PCEnqto);
			_varExp=""; _varCondicaowhile=""; _varCondicao="";
			setState(182);
			expressaoRelacional();
			setState(183);
			match(PCEntao);

									_bclComandos = new ArrayList<Comando>();
									_pilhaComandos.push(_bclComandos);
									_pilhaCondicao.push(_varCondicao);
								
			setState(185);
			comando();

			                    listCmdAux = _pilhaComandos.pop();
								_varCondicaowhile = _pilhaCondicao.pop(); 
			                    ComandoRepeticao cmd = new ComandoRepeticao(_varCondicaowhile, listCmdAux);
			                    _pilhaComandos.peek().add(cmd);
			                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubAlgoritmoContext extends ParserRuleContext {
		public TerminalNode PCIni() { return getToken(GyhRepaginadoLanguageParser.PCIni, 0); }
		public TerminalNode PCFim() { return getToken(GyhRepaginadoLanguageParser.PCFim, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public SubAlgoritmoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAlgoritmo; }
	}

	public final SubAlgoritmoContext subAlgoritmo() throws RecognitionException {
		SubAlgoritmoContext _localctx = new SubAlgoritmoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subAlgoritmo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(PCIni);
			setState(190); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(189);
				comando();
				}
				}
				setState(192); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 94109696L) != 0) );
			setState(194);
			match(PCFim);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoAtribuicaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public TerminalNode Atrib() { return getToken(GyhRepaginadoLanguageParser.Atrib, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public ComandoAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoAtribuicao; }
	}

	public final ComandoAtribuicaoContext comandoAtribuicao() throws RecognitionException {
		ComandoAtribuicaoContext _localctx = new ComandoAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comandoAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(Var);

								  verificaVar(_input.LT(-1).getText());
								  _varId=_input.LT(-1).getText();
								  _varExp="";
								
			setState(198);
			match(Atrib);
			setState(199);
			expressaoAritmetica();

								   ComandoAtribuicao cmd=new ComandoAtribuicao(_varId, _varExp);
								   _pilhaComandos.peek().add(cmd); 	
								
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00cb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004E\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004L\b\u0004\u0003\u0004N\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006X\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006_\b\u0006\u0003\u0006a\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007o\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\ty\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0088"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\f\u008e\b\f\u000b\f"+
		"\f\f\u008f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0098"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00a3\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00b1\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0004\u0012\u00bf\b\u0012\u000b\u0012\f\u0012\u00c0"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&\u0000\u0002\u0001\u0000\u0010\u0011\u0001\u0000\u000b\f\u00cb\u0000"+
		"(\u0001\u0000\u0000\u0000\u00022\u0001\u0000\u0000\u0000\u00046\u0001"+
		"\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\bM\u0001\u0000\u0000"+
		"\u0000\nO\u0001\u0000\u0000\u0000\f`\u0001\u0000\u0000\u0000\u000en\u0001"+
		"\u0000\u0000\u0000\u0010p\u0001\u0000\u0000\u0000\u0012x\u0001\u0000\u0000"+
		"\u0000\u0014\u0087\u0001\u0000\u0000\u0000\u0016\u0089\u0001\u0000\u0000"+
		"\u0000\u0018\u008b\u0001\u0000\u0000\u0000\u001a\u0097\u0001\u0000\u0000"+
		"\u0000\u001c\u0099\u0001\u0000\u0000\u0000\u001e\u009d\u0001\u0000\u0000"+
		"\u0000 \u00a4\u0001\u0000\u0000\u0000\"\u00b4\u0001\u0000\u0000\u0000"+
		"$\u00bc\u0001\u0000\u0000\u0000&\u00c4\u0001\u0000\u0000\u0000()\u0005"+
		"\u0006\u0000\u0000)*\u0005\u000f\u0000\u0000*+\u0005\u0005\u0000\u0000"+
		"+,\u0003\u0002\u0001\u0000,-\u0005\u0006\u0000\u0000-.\u0005\u000e\u0000"+
		"\u0000./\u0005\u0005\u0000\u0000/0\u0003\u0018\f\u000001\u0006\u0000\uffff"+
		"\uffff\u00001\u0001\u0001\u0000\u0000\u000024\u0003\u0004\u0002\u0000"+
		"35\u0003\u0002\u0001\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u00005\u0003\u0001\u0000\u0000\u000067\u0005\u001a\u0000\u000078\u0005"+
		"\u0006\u0000\u000089\u0007\u0000\u0000\u00009:\u0005\u0005\u0000\u0000"+
		":;\u0006\u0002\uffff\uffff\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0003"+
		"\n\u0005\u0000=>\u0003\b\u0004\u0000>\u0007\u0001\u0000\u0000\u0000?@"+
		"\u0005\u0001\u0000\u0000@A\u0006\u0004\uffff\uffff\u0000AB\u0003\n\u0005"+
		"\u0000BC\u0003\b\u0004\u0000CE\u0001\u0000\u0000\u0000D?\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EN\u0001\u0000\u0000\u0000FG\u0005\u0002"+
		"\u0000\u0000GH\u0006\u0004\uffff\uffff\u0000HI\u0003\n\u0005\u0000IJ\u0003"+
		"\b\u0004\u0000JL\u0001\u0000\u0000\u0000KF\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MD\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000N\t\u0001\u0000\u0000\u0000OP\u0003\u000e\u0007"+
		"\u0000PQ\u0003\f\u0006\u0000Q\u000b\u0001\u0000\u0000\u0000RS\u0005\u0003"+
		"\u0000\u0000ST\u0006\u0006\uffff\uffff\u0000TU\u0003\u000e\u0007\u0000"+
		"UV\u0003\f\u0006\u0000VX\u0001\u0000\u0000\u0000WR\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000Xa\u0001\u0000\u0000\u0000YZ\u0005\u0004\u0000"+
		"\u0000Z[\u0006\u0006\uffff\uffff\u0000[\\\u0003\u000e\u0007\u0000\\]\u0003"+
		"\f\u0006\u0000]_\u0001\u0000\u0000\u0000^Y\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`W\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000a\r\u0001\u0000\u0000\u0000bc\u0005\u001c\u0000"+
		"\u0000co\u0006\u0007\uffff\uffff\u0000de\u0005\u001d\u0000\u0000eo\u0006"+
		"\u0007\uffff\uffff\u0000fg\u0005\u001a\u0000\u0000go\u0006\u0007\uffff"+
		"\uffff\u0000hi\u0005\t\u0000\u0000ij\u0006\u0007\uffff\uffff\u0000jk\u0003"+
		"\u0006\u0003\u0000kl\u0005\n\u0000\u0000lm\u0006\u0007\uffff\uffff\u0000"+
		"mo\u0001\u0000\u0000\u0000nb\u0001\u0000\u0000\u0000nd\u0001\u0000\u0000"+
		"\u0000nf\u0001\u0000\u0000\u0000nh\u0001\u0000\u0000\u0000o\u000f\u0001"+
		"\u0000\u0000\u0000pq\u0003\u0014\n\u0000qr\u0003\u0012\t\u0000r\u0011"+
		"\u0001\u0000\u0000\u0000st\u0003\u0016\u000b\u0000tu\u0006\t\uffff\uffff"+
		"\u0000uv\u0003\u0014\n\u0000vw\u0003\u0012\t\u0000wy\u0001\u0000\u0000"+
		"\u0000xs\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0013\u0001"+
		"\u0000\u0000\u0000z{\u0003\u0006\u0003\u0000{|\u0006\n\uffff\uffff\u0000"+
		"|}\u0005\b\u0000\u0000}~\u0006\n\uffff\uffff\u0000~\u007f\u0003\u0006"+
		"\u0003\u0000\u007f\u0080\u0006\n\uffff\uffff\u0000\u0080\u0088\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005\t\u0000\u0000\u0082\u0083\u0006\n\uffff"+
		"\uffff\u0000\u0083\u0084\u0003\u0010\b\u0000\u0084\u0085\u0005\n\u0000"+
		"\u0000\u0085\u0086\u0006\n\uffff\uffff\u0000\u0086\u0088\u0001\u0000\u0000"+
		"\u0000\u0087z\u0001\u0000\u0000\u0000\u0087\u0081\u0001\u0000\u0000\u0000"+
		"\u0088\u0015\u0001\u0000\u0000\u0000\u0089\u008a\u0007\u0001\u0000\u0000"+
		"\u008a\u0017\u0001\u0000\u0000\u0000\u008b\u008d\u0006\f\uffff\uffff\u0000"+
		"\u008c\u008e\u0003\u001a\r\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0019\u0001\u0000\u0000\u0000\u0091"+
		"\u0098\u0003\u001c\u000e\u0000\u0092\u0098\u0003\u001e\u000f\u0000\u0093"+
		"\u0098\u0003 \u0010\u0000\u0094\u0098\u0003&\u0013\u0000\u0095\u0098\u0003"+
		"$\u0012\u0000\u0096\u0098\u0003\"\u0011\u0000\u0097\u0091\u0001\u0000"+
		"\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000\u0097\u0093\u0001\u0000"+
		"\u0000\u0000\u0097\u0094\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u001b\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005\u0012\u0000\u0000\u009a\u009b\u0005\u001a"+
		"\u0000\u0000\u009b\u009c\u0006\u000e\uffff\uffff\u0000\u009c\u001d\u0001"+
		"\u0000\u0000\u0000\u009d\u00a2\u0005\u0013\u0000\u0000\u009e\u009f\u0005"+
		"\u001a\u0000\u0000\u009f\u00a3\u0006\u000f\uffff\uffff\u0000\u00a0\u00a1"+
		"\u0005\u001b\u0000\u0000\u00a1\u00a3\u0006\u000f\uffff\uffff\u0000\u00a2"+
		"\u009e\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3"+
		"\u001f\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u0014\u0000\u0000\u00a5"+
		"\u00a6\u0006\u0010\uffff\uffff\u0000\u00a6\u00a7\u0003\u0010\b\u0000\u00a7"+
		"\u00a8\u0005\u0016\u0000\u0000\u00a8\u00a9\u0006\u0010\uffff\uffff\u0000"+
		"\u00a9\u00aa\u0003\u001a\r\u0000\u00aa\u00b0\u0006\u0010\uffff\uffff\u0000"+
		"\u00ab\u00ac\u0005\u0015\u0000\u0000\u00ac\u00ad\u0006\u0010\uffff\uffff"+
		"\u0000\u00ad\u00ae\u0003\u001a\r\u0000\u00ae\u00af\u0006\u0010\uffff\uffff"+
		"\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0\u00ab\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0006\u0010\uffff\uffff\u0000\u00b3!\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005\u0017\u0000\u0000\u00b5\u00b6\u0006\u0011\uffff"+
		"\uffff\u0000\u00b6\u00b7\u0003\u0010\b\u0000\u00b7\u00b8\u0005\u0016\u0000"+
		"\u0000\u00b8\u00b9\u0006\u0011\uffff\uffff\u0000\u00b9\u00ba\u0003\u001a"+
		"\r\u0000\u00ba\u00bb\u0006\u0011\uffff\uffff\u0000\u00bb#\u0001\u0000"+
		"\u0000\u0000\u00bc\u00be\u0005\u0018\u0000\u0000\u00bd\u00bf\u0003\u001a"+
		"\r\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0019\u0000"+
		"\u0000\u00c3%\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u001a\u0000\u0000"+
		"\u00c5\u00c6\u0006\u0013\uffff\uffff\u0000\u00c6\u00c7\u0005\u0007\u0000"+
		"\u0000\u00c7\u00c8\u0003\u0006\u0003\u0000\u00c8\u00c9\u0006\u0013\uffff"+
		"\uffff\u0000\u00c9\'\u0001\u0000\u0000\u0000\u000f4DKMW^`nx\u0087\u008f"+
		"\u0097\u00a2\u00b0\u00c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}