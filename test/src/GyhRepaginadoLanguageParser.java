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
		T__0=1, T__1=2, T__2=3, FimDelim=4, IniDelim=5, Atrib=6, OpRel=7, AbrePar=8, 
		FechaPar=9, OpBoolE=10, OpBoolOu=11, OpArit=12, PCProg=13, PCDec=14, PCInt=15, 
		PCReal=16, PCLer=17, PCImprimir=18, PCSe=19, PCSenao=20, PCEntao=21, PCEnqto=22, 
		PCIni=23, PCFim=24, Var=25, Cadeia=26, NumInt=27, NumReal=28, WS=29, Comentario=30;
	public static final int
		RULE_programa = 0, RULE_listaDeclaracoes = 1, RULE_declaracao = 2, RULE_expressaoAritmetica = 3, 
		RULE_termoAritmetico = 4, RULE_termoAritmeticolinha = 5, RULE_fatorAritmetico = 6, 
		RULE_expressaoRelacional = 7, RULE_termoRelacional = 8, RULE_operadorBooleano = 9, 
		RULE_listaComandos = 10, RULE_comando = 11, RULE_comandoEntrada = 12, 
		RULE_comandoSaida = 13, RULE_comandoCondicao = 14, RULE_subAlgoritmo = 15, 
		RULE_comandoAtribuicao = 16, RULE_comandoRepeticao = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaDeclaracoes", "declaracao", "expressaoAritmetica", 
			"termoAritmetico", "termoAritmeticolinha", "fatorAritmetico", "expressaoRelacional", 
			"termoRelacional", "operadorBooleano", "listaComandos", "comando", "comandoEntrada", 
			"comandoSaida", "comandoCondicao", "subAlgoritmo", "comandoAtribuicao", 
			"comandoRepeticao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'*'", "'/'", "']'", "'['", "'<<'", null, "'('", "')'", 
			"'and'", "'or'", null, "'prog'", "'dec'", "'integer'", "'float'", "'read'", 
			"'print'", "'if'", "'else'", "'then'", "'while'", "'start'", "'end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "FimDelim", "IniDelim", "Atrib", "OpRel", "AbrePar", 
			"FechaPar", "OpBoolE", "OpBoolOu", "OpArit", "PCProg", "PCDec", "PCInt", 
			"PCReal", "PCLer", "PCImprimir", "PCSe", "PCSenao", "PCEntao", "PCEnqto", 
			"PCIni", "PCFim", "Var", "Cadeia", "NumInt", "NumReal", "WS", "Comentario"
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
		
		private String _varCondicao;
		//======
		private GeraCodigo prog = new GeraCodigo(); 
		
		private ArrayList<Comando> listCmd = new ArrayList<Comando>(); 
		private ArrayList<Comando> listCmdAux = new ArrayList<Comando>();

		private ArrayList<Comando> _varListTrue = new ArrayList<Comando>();
		private ArrayList<Comando> _varListFalse = new ArrayList<Comando>();

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
			setState(36);
			match(IniDelim);
			setState(37);
			match(PCDec);
			setState(38);
			match(FimDelim);
			setState(39);
			listaDeclaracoes();
			setState(40);
			match(IniDelim);
			setState(41);
			match(PCProg);
			setState(42);
			match(FimDelim);
			setState(43);
			listaComandos();
			 prog.setTabela(_tabelaSimbolo);
					  	prog.setComando(listCmd);
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
			setState(46);
			declaracao();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Var) {
				{
				setState(47);
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
			setState(50);
			match(Var);
			setState(51);
			match(IniDelim);
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==PCInt || _la==PCReal) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(53);
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
		public List<TermoAritmeticoContext> termoAritmetico() {
			return getRuleContexts(TermoAritmeticoContext.class);
		}
		public TermoAritmeticoContext termoAritmetico(int i) {
			return getRuleContext(TermoAritmeticoContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			termoAritmetico();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(57);
				match(T__0);
				setState(58);
				termoAritmetico();
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
		enterRule(_localctx, 8, RULE_termoAritmetico);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			fatorAritmetico();
			setState(62);
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
		enterRule(_localctx, 10, RULE_termoAritmeticolinha);
		int _la;
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(64);
					match(T__1);
					setState(65);
					fatorAritmetico();
					setState(66);
					termoAritmeticolinha();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(70);
					match(T__2);
					setState(71);
					fatorAritmetico();
					setState(72);
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
		enterRule(_localctx, 12, RULE_fatorAritmetico);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NumInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(NumInt);
				}
				break;
			case NumReal:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(NumReal);
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(Var);
				}
				break;
			case AbrePar:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				match(AbrePar);
				setState(82);
				expressaoAritmetica();
				setState(83);
				match(FechaPar);
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
		public List<TermoRelacionalContext> termoRelacional() {
			return getRuleContexts(TermoRelacionalContext.class);
		}
		public TermoRelacionalContext termoRelacional(int i) {
			return getRuleContext(TermoRelacionalContext.class,i);
		}
		public List<OperadorBooleanoContext> operadorBooleano() {
			return getRuleContexts(OperadorBooleanoContext.class);
		}
		public OperadorBooleanoContext operadorBooleano(int i) {
			return getRuleContext(OperadorBooleanoContext.class,i);
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
		enterRule(_localctx, 14, RULE_expressaoRelacional);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(87);
					termoRelacional();
					setState(88);
					operadorBooleano();
					_varCondicao+=" "+_input.LT(-1).getText()+" ";
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(96);
			termoRelacional();
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
		enterRule(_localctx, 16, RULE_termoRelacional);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				expressaoAritmetica();
				_varCondicao+=_varExp; _varExp="";
				setState(100);
				match(OpRel);
				_varCondicao+=_input.LT(-1).getText();
				setState(102);
				expressaoAritmetica();
				_varCondicao+=_varExp; _varExp="";
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(AbrePar);
				_varCondicao+=" ( ";
				setState(107);
				expressaoRelacional();
				setState(108);
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
		enterRule(_localctx, 18, RULE_operadorBooleano);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
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
		enterRule(_localctx, 20, RULE_listaComandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			comando();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCLer) | (1L << PCImprimir) | (1L << PCSe) | (1L << PCIni))) != 0)) {
				{
				setState(116);
				listaComandos();
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
		public SubAlgoritmoContext subAlgoritmo() {
			return getRuleContext(SubAlgoritmoContext.class,0);
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
		enterRule(_localctx, 22, RULE_comando);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PCLer:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				comandoEntrada();
				}
				break;
			case PCImprimir:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				comandoSaida();
				}
				break;
			case PCSe:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				comandoCondicao();
				}
				break;
			case PCIni:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				subAlgoritmo();
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
		enterRule(_localctx, 24, RULE_comandoEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(PCLer);
			setState(126);
			match(Var);
			 verificaVar(_input.LT(-1).getText()); //nao esquecer de verificar se a variável foi declarada
			                  ComandoLeitura cmd = new ComandoLeitura();
			                  cmd.setId(_input.LT(-1).getText());
			                  listCmd.add(cmd);
			                
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
		enterRule(_localctx, 26, RULE_comandoSaida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(PCImprimir);
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				{
				setState(130);
				match(Var);

									ComandoEscrita cmd = new ComandoEscrita();
									cmd.setId(_input.LT(-1).getText());
									listCmd.add(cmd);
								
				}
				break;
			case Cadeia:
				{
				setState(132);
				match(Cadeia);
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
		enterRule(_localctx, 28, RULE_comandoCondicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(PCSe);
			setState(136);
			expressaoRelacional();
			setState(137);
			match(PCEntao);
			setState(138);
			comando();

							  	_varListTrue = new ArrayList<Comando>(listCmdAux);
							  	listCmdAux.clear();
							  
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(140);
				match(PCSenao);
				setState(141);
				comando();

								  	_varListFalse = new ArrayList<Comando>(listCmdAux);
								  	listCmdAux.clear();
								  
				}
				break;
			}
			ComandoCondicao cmd= new ComandoCondicao(_varCondicao, _varListTrue, _varListFalse);
							   listCmdAux.add(cmd); 
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
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode PCFim() { return getToken(GyhRepaginadoLanguageParser.PCFim, 0); }
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
		enterRule(_localctx, 30, RULE_subAlgoritmo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(PCIni);
			setState(149);
			listaComandos();
			setState(150);
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
		enterRule(_localctx, 32, RULE_comandoAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(Var);
			 if(_tabelaSimbolo.exists(_input.LT(-1).getText())==false){
									System.out.println("\n\nVariavel nao declarada "+_input.LT(-1).getText());}
							    _varId=_input.LT(-1).getText();
								  _varExp="";
								
			setState(154);
			match(Atrib);
			setState(155);
			expressaoAritmetica();

								   ComandoAtribuicao cmd=new ComandoAtribuicao(_varId, _varExp);
								   listCmdAux.add(cmd); 	
								
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
			setState(158);
			match(PCEnqto);
			setState(159);
			expressaoRelacional();
			setState(160);
			match(PCEntao);
			setState(161);
			comando();

				_varListTrue.addAll(listCmdAux);
				listCmdAux.removeAll(listCmdAux);
				ComandoRepeticao cmd = new ComandoRepeticao(_varCondicao, _varListTrue);
				listCmdAux.add(cmd);

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00a7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\5\3\63\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5>\n\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\5\7G\n\7\3\7\3\7\3\7\3\7\5\7M\n\7\5\7O\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\bX\n\b\3\t\3\t\3\t\3\t\7\t^\n\t\f\t\16\ta\13\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nr\n\n\3\13\3\13\3\f"+
		"\3\f\5\fx\n\f\3\r\3\r\3\r\3\r\5\r~\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\5\17\u0088\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u0093\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$\2\4\3\2\21\22\3\2\f\r\2\u00a4\2&\3\2\2\2\4\60\3\2"+
		"\2\2\6\64\3\2\2\2\b:\3\2\2\2\n?\3\2\2\2\fN\3\2\2\2\16W\3\2\2\2\20_\3\2"+
		"\2\2\22q\3\2\2\2\24s\3\2\2\2\26u\3\2\2\2\30}\3\2\2\2\32\177\3\2\2\2\34"+
		"\u0083\3\2\2\2\36\u0089\3\2\2\2 \u0096\3\2\2\2\"\u009a\3\2\2\2$\u00a0"+
		"\3\2\2\2&\'\7\7\2\2\'(\7\20\2\2()\7\6\2\2)*\5\4\3\2*+\7\7\2\2+,\7\17\2"+
		"\2,-\7\6\2\2-.\5\26\f\2./\b\2\1\2/\3\3\2\2\2\60\62\5\6\4\2\61\63\5\4\3"+
		"\2\62\61\3\2\2\2\62\63\3\2\2\2\63\5\3\2\2\2\64\65\7\33\2\2\65\66\7\7\2"+
		"\2\66\67\t\2\2\2\678\7\6\2\289\b\4\1\29\7\3\2\2\2:=\5\n\6\2;<\7\3\2\2"+
		"<>\5\n\6\2=;\3\2\2\2=>\3\2\2\2>\t\3\2\2\2?@\5\16\b\2@A\5\f\7\2A\13\3\2"+
		"\2\2BC\7\4\2\2CD\5\16\b\2DE\5\f\7\2EG\3\2\2\2FB\3\2\2\2FG\3\2\2\2GO\3"+
		"\2\2\2HI\7\5\2\2IJ\5\16\b\2JK\5\f\7\2KM\3\2\2\2LH\3\2\2\2LM\3\2\2\2MO"+
		"\3\2\2\2NF\3\2\2\2NL\3\2\2\2O\r\3\2\2\2PX\7\35\2\2QX\7\36\2\2RX\7\33\2"+
		"\2ST\7\n\2\2TU\5\b\5\2UV\7\13\2\2VX\3\2\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2"+
		"\2\2WS\3\2\2\2X\17\3\2\2\2YZ\5\22\n\2Z[\5\24\13\2[\\\b\t\1\2\\^\3\2\2"+
		"\2]Y\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\5\22"+
		"\n\2c\21\3\2\2\2de\5\b\5\2ef\b\n\1\2fg\7\t\2\2gh\b\n\1\2hi\5\b\5\2ij\b"+
		"\n\1\2jr\3\2\2\2kl\7\n\2\2lm\b\n\1\2mn\5\20\t\2no\7\13\2\2op\b\n\1\2p"+
		"r\3\2\2\2qd\3\2\2\2qk\3\2\2\2r\23\3\2\2\2st\t\3\2\2t\25\3\2\2\2uw\5\30"+
		"\r\2vx\5\26\f\2wv\3\2\2\2wx\3\2\2\2x\27\3\2\2\2y~\5\32\16\2z~\5\34\17"+
		"\2{~\5\36\20\2|~\5 \21\2}y\3\2\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\31\3"+
		"\2\2\2\177\u0080\7\23\2\2\u0080\u0081\7\33\2\2\u0081\u0082\b\16\1\2\u0082"+
		"\33\3\2\2\2\u0083\u0087\7\24\2\2\u0084\u0085\7\33\2\2\u0085\u0088\b\17"+
		"\1\2\u0086\u0088\7\34\2\2\u0087\u0084\3\2\2\2\u0087\u0086\3\2\2\2\u0088"+
		"\35\3\2\2\2\u0089\u008a\7\25\2\2\u008a\u008b\5\20\t\2\u008b\u008c\7\27"+
		"\2\2\u008c\u008d\5\30\r\2\u008d\u0092\b\20\1\2\u008e\u008f\7\26\2\2\u008f"+
		"\u0090\5\30\r\2\u0090\u0091\b\20\1\2\u0091\u0093\3\2\2\2\u0092\u008e\3"+
		"\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\b\20\1\2\u0095"+
		"\37\3\2\2\2\u0096\u0097\7\31\2\2\u0097\u0098\5\26\f\2\u0098\u0099\7\32"+
		"\2\2\u0099!\3\2\2\2\u009a\u009b\7\33\2\2\u009b\u009c\b\22\1\2\u009c\u009d"+
		"\7\b\2\2\u009d\u009e\5\b\5\2\u009e\u009f\b\22\1\2\u009f#\3\2\2\2\u00a0"+
		"\u00a1\7\30\2\2\u00a1\u00a2\5\20\t\2\u00a2\u00a3\7\27\2\2\u00a3\u00a4"+
		"\5\30\r\2\u00a4\u00a5\b\23\1\2\u00a5%\3\2\2\2\16\62=FLNW_qw}\u0087\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}