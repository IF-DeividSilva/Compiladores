// Generated from GyhRepaginadoLanguage.g4 by ANTLR 4.7.2

	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GyhRepaginadoLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitPrograma(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterListaDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitListaDeclaracoes(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitDeclaracao(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoAritmetica(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoAritmeticalinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoAritmeticalinha(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterTermoAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitTermoAritmetico(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterTermoAritmeticolinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitTermoAritmeticolinha(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterFatorAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitFatorAritmetico(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoRelacional(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoRelacional1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoRelacional1(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterTermoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitTermoRelacional(this);
		}
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

	public static class OperadorBooleanoContext extends ParserRuleContext {
		public TerminalNode OpBoolOu() { return getToken(GyhRepaginadoLanguageParser.OpBoolOu, 0); }
		public TerminalNode OpBoolE() { return getToken(GyhRepaginadoLanguageParser.OpBoolE, 0); }
		public OperadorBooleanoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorBooleano; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterOperadorBooleano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitOperadorBooleano(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterListaComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitListaComandos(this);
		}
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCLer) | (1L << PCImprimir) | (1L << PCSe) | (1L << PCEnqto) | (1L << PCIni) | (1L << Var))) != 0) );
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComando(this);
		}
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

	public static class ComandoEntradaContext extends ParserRuleContext {
		public TerminalNode PCLer() { return getToken(GyhRepaginadoLanguageParser.PCLer, 0); }
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public ComandoEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoEntrada(this);
		}
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

	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode PCImprimir() { return getToken(GyhRepaginadoLanguageParser.PCImprimir, 0); }
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public TerminalNode Cadeia() { return getToken(GyhRepaginadoLanguageParser.Cadeia, 0); }
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoSaida(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoCondicao(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoRepeticao(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterSubAlgoritmo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitSubAlgoritmo(this);
		}
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCLer) | (1L << PCImprimir) | (1L << PCSe) | (1L << PCEnqto) | (1L << PCIni) | (1L << Var))) != 0) );
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoAtribuicao(this);
		}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00cd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\5\6G\n\6\3\6\3\6\3\6\3\6\3\6\5\6N\n\6\5\6P\n\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\5\bZ\n\b\3\b\3\b\3\b\3\b\3\b\5\ba\n\b\5\bc\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tq\n\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\5\13{\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u008a\n\f\3\r\3\r\3\16\3\16\6\16\u0090\n\16\r\16\16\16"+
		"\u0091\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u009a\n\17\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\5\21\u00a5\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b3\n\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\6\24\u00c1\n\24\r\24\16\24\u00c2"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(\2\4\3\2\22\23\3\2\r\16\2\u00cd\2*\3\2\2\2"+
		"\4\64\3\2\2\2\68\3\2\2\2\b>\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16b\3\2\2\2"+
		"\20p\3\2\2\2\22r\3\2\2\2\24z\3\2\2\2\26\u0089\3\2\2\2\30\u008b\3\2\2\2"+
		"\32\u008d\3\2\2\2\34\u0099\3\2\2\2\36\u009b\3\2\2\2 \u009f\3\2\2\2\"\u00a6"+
		"\3\2\2\2$\u00b6\3\2\2\2&\u00be\3\2\2\2(\u00c6\3\2\2\2*+\7\b\2\2+,\7\21"+
		"\2\2,-\7\7\2\2-.\5\4\3\2./\7\b\2\2/\60\7\20\2\2\60\61\7\7\2\2\61\62\5"+
		"\32\16\2\62\63\b\2\1\2\63\3\3\2\2\2\64\66\5\6\4\2\65\67\5\4\3\2\66\65"+
		"\3\2\2\2\66\67\3\2\2\2\67\5\3\2\2\289\7\34\2\29:\7\b\2\2:;\t\2\2\2;<\7"+
		"\7\2\2<=\b\4\1\2=\7\3\2\2\2>?\5\f\7\2?@\5\n\6\2@\t\3\2\2\2AB\7\3\2\2B"+
		"C\b\6\1\2CD\5\f\7\2DE\5\n\6\2EG\3\2\2\2FA\3\2\2\2FG\3\2\2\2GP\3\2\2\2"+
		"HI\7\4\2\2IJ\b\6\1\2JK\5\f\7\2KL\5\n\6\2LN\3\2\2\2MH\3\2\2\2MN\3\2\2\2"+
		"NP\3\2\2\2OF\3\2\2\2OM\3\2\2\2P\13\3\2\2\2QR\5\20\t\2RS\5\16\b\2S\r\3"+
		"\2\2\2TU\7\5\2\2UV\b\b\1\2VW\5\20\t\2WX\5\16\b\2XZ\3\2\2\2YT\3\2\2\2Y"+
		"Z\3\2\2\2Zc\3\2\2\2[\\\7\6\2\2\\]\b\b\1\2]^\5\20\t\2^_\5\16\b\2_a\3\2"+
		"\2\2`[\3\2\2\2`a\3\2\2\2ac\3\2\2\2bY\3\2\2\2b`\3\2\2\2c\17\3\2\2\2de\7"+
		"\36\2\2eq\b\t\1\2fg\7\37\2\2gq\b\t\1\2hi\7\34\2\2iq\b\t\1\2jk\7\13\2\2"+
		"kl\b\t\1\2lm\5\b\5\2mn\7\f\2\2no\b\t\1\2oq\3\2\2\2pd\3\2\2\2pf\3\2\2\2"+
		"ph\3\2\2\2pj\3\2\2\2q\21\3\2\2\2rs\5\26\f\2st\5\24\13\2t\23\3\2\2\2uv"+
		"\5\30\r\2vw\b\13\1\2wx\5\26\f\2xy\5\24\13\2y{\3\2\2\2zu\3\2\2\2z{\3\2"+
		"\2\2{\25\3\2\2\2|}\5\b\5\2}~\b\f\1\2~\177\7\n\2\2\177\u0080\b\f\1\2\u0080"+
		"\u0081\5\b\5\2\u0081\u0082\b\f\1\2\u0082\u008a\3\2\2\2\u0083\u0084\7\13"+
		"\2\2\u0084\u0085\b\f\1\2\u0085\u0086\5\22\n\2\u0086\u0087\7\f\2\2\u0087"+
		"\u0088\b\f\1\2\u0088\u008a\3\2\2\2\u0089|\3\2\2\2\u0089\u0083\3\2\2\2"+
		"\u008a\27\3\2\2\2\u008b\u008c\t\3\2\2\u008c\31\3\2\2\2\u008d\u008f\b\16"+
		"\1\2\u008e\u0090\5\34\17\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\33\3\2\2\2\u0093\u009a\5\36\20"+
		"\2\u0094\u009a\5 \21\2\u0095\u009a\5\"\22\2\u0096\u009a\5(\25\2\u0097"+
		"\u009a\5&\24\2\u0098\u009a\5$\23\2\u0099\u0093\3\2\2\2\u0099\u0094\3\2"+
		"\2\2\u0099\u0095\3\2\2\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\35\3\2\2\2\u009b\u009c\7\24\2\2\u009c\u009d\7\34"+
		"\2\2\u009d\u009e\b\20\1\2\u009e\37\3\2\2\2\u009f\u00a4\7\25\2\2\u00a0"+
		"\u00a1\7\34\2\2\u00a1\u00a5\b\21\1\2\u00a2\u00a3\7\35\2\2\u00a3\u00a5"+
		"\b\21\1\2\u00a4\u00a0\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5!\3\2\2\2\u00a6"+
		"\u00a7\7\26\2\2\u00a7\u00a8\b\22\1\2\u00a8\u00a9\5\22\n\2\u00a9\u00aa"+
		"\7\30\2\2\u00aa\u00ab\b\22\1\2\u00ab\u00ac\5\34\17\2\u00ac\u00b2\b\22"+
		"\1\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\b\22\1\2\u00af\u00b0\5\34\17\2\u00b0"+
		"\u00b1\b\22\1\2\u00b1\u00b3\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2\u00b3\3"+
		"\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\22\1\2\u00b5#\3\2\2\2\u00b6\u00b7"+
		"\7\31\2\2\u00b7\u00b8\b\23\1\2\u00b8\u00b9\5\22\n\2\u00b9\u00ba\7\30\2"+
		"\2\u00ba\u00bb\b\23\1\2\u00bb\u00bc\5\34\17\2\u00bc\u00bd\b\23\1\2\u00bd"+
		"%\3\2\2\2\u00be\u00c0\7\32\2\2\u00bf\u00c1\5\34\17\2\u00c0\u00bf\3\2\2"+
		"\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c5\7\33\2\2\u00c5\'\3\2\2\2\u00c6\u00c7\7\34\2\2\u00c7"+
		"\u00c8\b\25\1\2\u00c8\u00c9\7\t\2\2\u00c9\u00ca\5\b\5\2\u00ca\u00cb\b"+
		"\25\1\2\u00cb)\3\2\2\2\21\66FMOY`bpz\u0089\u0091\u0099\u00a4\u00b2\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}