// Generated from GyhRepaginadoLanguage.g4 by ANTLR 4.7.2

	import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GyhRepaginadoLanguageLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "FimDelim", "IniDelim", "Atrib", "OpRel", 
			"AbrePar", "FechaPar", "OpBoolE", "OpBoolOu", "OpArit", "PCProg", "PCDec", 
			"PCInt", "PCReal", "PCLer", "PCImprimir", "PCSe", "PCSenao", "PCEntao", 
			"PCEnqto", "PCIni", "PCFim", "Var", "Cadeia", "NumInt", "NumReal", "WS", 
			"Comentario"
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


	public GyhRepaginadoLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GyhRepaginadoLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00d6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\tZ\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\7\33\u00aa"+
		"\n\33\f\33\16\33\u00ad\13\33\3\34\3\34\3\34\3\34\7\34\u00b3\n\34\f\34"+
		"\16\34\u00b6\13\34\3\34\3\34\3\35\6\35\u00bb\n\35\r\35\16\35\u00bc\3\36"+
		"\6\36\u00c0\n\36\r\36\16\36\u00c1\3\36\3\36\6\36\u00c6\n\36\r\36\16\36"+
		"\u00c7\3\37\3\37\3\37\3\37\3 \3 \7 \u00d0\n \f \16 \u00d3\13 \3 \3 \2"+
		"\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!\3\2\t\4\2>>@@\5\2,-//\61\61\3\2C\\\5\2\62;C\\c|\3\2\62;\4\2\13"+
		"\f\"\"\3\2\f\f\2\u00e1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2"+
		"\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2\21Y\3\2\2"+
		"\2\23[\3\2\2\2\25]\3\2\2\2\27_\3\2\2\2\31c\3\2\2\2\33f\3\2\2\2\35h\3\2"+
		"\2\2\37m\3\2\2\2!q\3\2\2\2#y\3\2\2\2%\177\3\2\2\2\'\u0084\3\2\2\2)\u008a"+
		"\3\2\2\2+\u008d\3\2\2\2-\u0092\3\2\2\2/\u0097\3\2\2\2\61\u009d\3\2\2\2"+
		"\63\u00a3\3\2\2\2\65\u00a7\3\2\2\2\67\u00ae\3\2\2\29\u00ba\3\2\2\2;\u00bf"+
		"\3\2\2\2=\u00c9\3\2\2\2?\u00cd\3\2\2\2AB\7-\2\2B\4\3\2\2\2CD\7/\2\2D\6"+
		"\3\2\2\2EF\7,\2\2F\b\3\2\2\2GH\7\61\2\2H\n\3\2\2\2IJ\7_\2\2J\f\3\2\2\2"+
		"KL\7]\2\2L\16\3\2\2\2MN\7>\2\2NO\7>\2\2O\20\3\2\2\2PQ\7@\2\2QZ\7?\2\2"+
		"RS\7>\2\2SZ\7?\2\2TZ\t\2\2\2UV\7>\2\2VZ\7@\2\2WX\7?\2\2XZ\7?\2\2YP\3\2"+
		"\2\2YR\3\2\2\2YT\3\2\2\2YU\3\2\2\2YW\3\2\2\2Z\22\3\2\2\2[\\\7*\2\2\\\24"+
		"\3\2\2\2]^\7+\2\2^\26\3\2\2\2_`\7c\2\2`a\7p\2\2ab\7f\2\2b\30\3\2\2\2c"+
		"d\7q\2\2de\7t\2\2e\32\3\2\2\2fg\t\3\2\2g\34\3\2\2\2hi\7r\2\2ij\7t\2\2"+
		"jk\7q\2\2kl\7i\2\2l\36\3\2\2\2mn\7f\2\2no\7g\2\2op\7e\2\2p \3\2\2\2qr"+
		"\7k\2\2rs\7p\2\2st\7v\2\2tu\7g\2\2uv\7i\2\2vw\7g\2\2wx\7t\2\2x\"\3\2\2"+
		"\2yz\7h\2\2z{\7n\2\2{|\7q\2\2|}\7c\2\2}~\7v\2\2~$\3\2\2\2\177\u0080\7"+
		"t\2\2\u0080\u0081\7g\2\2\u0081\u0082\7c\2\2\u0082\u0083\7f\2\2\u0083&"+
		"\3\2\2\2\u0084\u0085\7r\2\2\u0085\u0086\7t\2\2\u0086\u0087\7k\2\2\u0087"+
		"\u0088\7p\2\2\u0088\u0089\7v\2\2\u0089(\3\2\2\2\u008a\u008b\7k\2\2\u008b"+
		"\u008c\7h\2\2\u008c*\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f\7n\2\2\u008f"+
		"\u0090\7u\2\2\u0090\u0091\7g\2\2\u0091,\3\2\2\2\u0092\u0093\7v\2\2\u0093"+
		"\u0094\7j\2\2\u0094\u0095\7g\2\2\u0095\u0096\7p\2\2\u0096.\3\2\2\2\u0097"+
		"\u0098\7y\2\2\u0098\u0099\7j\2\2\u0099\u009a\7k\2\2\u009a\u009b\7n\2\2"+
		"\u009b\u009c\7g\2\2\u009c\60\3\2\2\2\u009d\u009e\7u\2\2\u009e\u009f\7"+
		"v\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7v\2\2\u00a2\62"+
		"\3\2\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7f\2\2\u00a6"+
		"\64\3\2\2\2\u00a7\u00ab\t\4\2\2\u00a8\u00aa\t\5\2\2\u00a9\u00a8\3\2\2"+
		"\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\66"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b4\7$\2\2\u00af\u00b3\t\5\2\2\u00b0"+
		"\u00b3\5\21\t\2\u00b1\u00b3\5\17\b\2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7$"+
		"\2\2\u00b88\3\2\2\2\u00b9\u00bb\t\6\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd:\3\2\2\2\u00be"+
		"\u00c0\t\6\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\7\60\2\2\u00c4"+
		"\u00c6\t\6\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8<\3\2\2\2\u00c9\u00ca\t\7\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00cc\b\37\2\2\u00cc>\3\2\2\2\u00cd\u00d1\7%\2\2\u00ce"+
		"\u00d0\n\b\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d5\b \2\2\u00d5@\3\2\2\2\f\2Y\u00a9\u00ab\u00b2\u00b4\u00bc\u00c1"+
		"\u00c7\u00d1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}