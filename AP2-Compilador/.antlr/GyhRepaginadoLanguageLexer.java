// Generated from c:/Users/deivi/OneDrive/Área de Trabalho/UTFPR/6 periodo/Compiladores/AP2-Compilador/GyhRepaginadoLanguage.g4 by ANTLR 4.13.1

	import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GyhRepaginadoLanguageLexer extends Lexer {
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
		"\u0004\u0000\u001f\u00d4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007X\b\u0007\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u00a8\b\u0019\n\u0019\f\u0019\u00ab\t\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u00b1\b\u001a\n\u001a\f\u001a\u00b4\t\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0004\u001b\u00b9\b\u001b\u000b\u001b"+
		"\f\u001b\u00ba\u0001\u001c\u0004\u001c\u00be\b\u001c\u000b\u001c\f\u001c"+
		"\u00bf\u0001\u001c\u0001\u001c\u0004\u001c\u00c4\b\u001c\u000b\u001c\f"+
		"\u001c\u00c5\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0005\u001e\u00ce\b\u001e\n\u001e\f\u001e\u00d1\t\u001e\u0001"+
		"\u001e\u0001\u001e\u0000\u0000\u001f\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c"+
		"9\u001d;\u001e=\u001f\u0001\u0000\u0007\u0002\u0000<<>>\u0003\u0000*+"+
		"--//\u0001\u0000AZ\u0003\u000009AZaz\u0001\u000009\u0002\u0000\t\n  \u0001"+
		"\u0000\n\n\u00df\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000\u0000\u0003"+
		"A\u0001\u0000\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007E\u0001"+
		"\u0000\u0000\u0000\tG\u0001\u0000\u0000\u0000\u000bI\u0001\u0000\u0000"+
		"\u0000\rK\u0001\u0000\u0000\u0000\u000fW\u0001\u0000\u0000\u0000\u0011"+
		"Y\u0001\u0000\u0000\u0000\u0013[\u0001\u0000\u0000\u0000\u0015]\u0001"+
		"\u0000\u0000\u0000\u0017a\u0001\u0000\u0000\u0000\u0019d\u0001\u0000\u0000"+
		"\u0000\u001bf\u0001\u0000\u0000\u0000\u001dk\u0001\u0000\u0000\u0000\u001f"+
		"o\u0001\u0000\u0000\u0000!w\u0001\u0000\u0000\u0000#}\u0001\u0000\u0000"+
		"\u0000%\u0082\u0001\u0000\u0000\u0000\'\u0088\u0001\u0000\u0000\u0000"+
		")\u008b\u0001\u0000\u0000\u0000+\u0090\u0001\u0000\u0000\u0000-\u0095"+
		"\u0001\u0000\u0000\u0000/\u009b\u0001\u0000\u0000\u00001\u00a1\u0001\u0000"+
		"\u0000\u00003\u00a5\u0001\u0000\u0000\u00005\u00ac\u0001\u0000\u0000\u0000"+
		"7\u00b8\u0001\u0000\u0000\u00009\u00bd\u0001\u0000\u0000\u0000;\u00c7"+
		"\u0001\u0000\u0000\u0000=\u00cb\u0001\u0000\u0000\u0000?@\u0005+\u0000"+
		"\u0000@\u0002\u0001\u0000\u0000\u0000AB\u0005-\u0000\u0000B\u0004\u0001"+
		"\u0000\u0000\u0000CD\u0005*\u0000\u0000D\u0006\u0001\u0000\u0000\u0000"+
		"EF\u0005/\u0000\u0000F\b\u0001\u0000\u0000\u0000GH\u0005]\u0000\u0000"+
		"H\n\u0001\u0000\u0000\u0000IJ\u0005[\u0000\u0000J\f\u0001\u0000\u0000"+
		"\u0000KL\u0005<\u0000\u0000LM\u0005<\u0000\u0000M\u000e\u0001\u0000\u0000"+
		"\u0000NO\u0005>\u0000\u0000OX\u0005=\u0000\u0000PQ\u0005<\u0000\u0000"+
		"QX\u0005=\u0000\u0000RX\u0007\u0000\u0000\u0000ST\u0005<\u0000\u0000T"+
		"X\u0005>\u0000\u0000UV\u0005=\u0000\u0000VX\u0005=\u0000\u0000WN\u0001"+
		"\u0000\u0000\u0000WP\u0001\u0000\u0000\u0000WR\u0001\u0000\u0000\u0000"+
		"WS\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000X\u0010\u0001\u0000"+
		"\u0000\u0000YZ\u0005(\u0000\u0000Z\u0012\u0001\u0000\u0000\u0000[\\\u0005"+
		")\u0000\u0000\\\u0014\u0001\u0000\u0000\u0000]^\u0005a\u0000\u0000^_\u0005"+
		"n\u0000\u0000_`\u0005d\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005"+
		"o\u0000\u0000bc\u0005r\u0000\u0000c\u0018\u0001\u0000\u0000\u0000de\u0007"+
		"\u0001\u0000\u0000e\u001a\u0001\u0000\u0000\u0000fg\u0005p\u0000\u0000"+
		"gh\u0005r\u0000\u0000hi\u0005o\u0000\u0000ij\u0005g\u0000\u0000j\u001c"+
		"\u0001\u0000\u0000\u0000kl\u0005d\u0000\u0000lm\u0005e\u0000\u0000mn\u0005"+
		"c\u0000\u0000n\u001e\u0001\u0000\u0000\u0000op\u0005i\u0000\u0000pq\u0005"+
		"n\u0000\u0000qr\u0005t\u0000\u0000rs\u0005e\u0000\u0000st\u0005g\u0000"+
		"\u0000tu\u0005e\u0000\u0000uv\u0005r\u0000\u0000v \u0001\u0000\u0000\u0000"+
		"wx\u0005f\u0000\u0000xy\u0005l\u0000\u0000yz\u0005o\u0000\u0000z{\u0005"+
		"a\u0000\u0000{|\u0005t\u0000\u0000|\"\u0001\u0000\u0000\u0000}~\u0005"+
		"r\u0000\u0000~\u007f\u0005e\u0000\u0000\u007f\u0080\u0005a\u0000\u0000"+
		"\u0080\u0081\u0005d\u0000\u0000\u0081$\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005p\u0000\u0000\u0083\u0084\u0005r\u0000\u0000\u0084\u0085\u0005i"+
		"\u0000\u0000\u0085\u0086\u0005n\u0000\u0000\u0086\u0087\u0005t\u0000\u0000"+
		"\u0087&\u0001\u0000\u0000\u0000\u0088\u0089\u0005i\u0000\u0000\u0089\u008a"+
		"\u0005f\u0000\u0000\u008a(\u0001\u0000\u0000\u0000\u008b\u008c\u0005e"+
		"\u0000\u0000\u008c\u008d\u0005l\u0000\u0000\u008d\u008e\u0005s\u0000\u0000"+
		"\u008e\u008f\u0005e\u0000\u0000\u008f*\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0005t\u0000\u0000\u0091\u0092\u0005h\u0000\u0000\u0092\u0093\u0005e"+
		"\u0000\u0000\u0093\u0094\u0005n\u0000\u0000\u0094,\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0005w\u0000\u0000\u0096\u0097\u0005h\u0000\u0000\u0097\u0098"+
		"\u0005i\u0000\u0000\u0098\u0099\u0005l\u0000\u0000\u0099\u009a\u0005e"+
		"\u0000\u0000\u009a.\u0001\u0000\u0000\u0000\u009b\u009c\u0005s\u0000\u0000"+
		"\u009c\u009d\u0005t\u0000\u0000\u009d\u009e\u0005a\u0000\u0000\u009e\u009f"+
		"\u0005r\u0000\u0000\u009f\u00a0\u0005t\u0000\u0000\u00a00\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0005e\u0000\u0000\u00a2\u00a3\u0005n\u0000\u0000"+
		"\u00a3\u00a4\u0005d\u0000\u0000\u00a42\u0001\u0000\u0000\u0000\u00a5\u00a9"+
		"\u0007\u0002\u0000\u0000\u00a6\u00a8\u0007\u0003\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa4\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00b2\u0005"+
		"\"\u0000\u0000\u00ad\u00b1\u0007\u0003\u0000\u0000\u00ae\u00b1\u0003\u000f"+
		"\u0007\u0000\u00af\u00b1\u0003\r\u0006\u0000\u00b0\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00af\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\"\u0000\u0000"+
		"\u00b66\u0001\u0000\u0000\u0000\u00b7\u00b9\u0007\u0004\u0000\u0000\u00b8"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"8\u0001\u0000\u0000\u0000\u00bc\u00be\u0007\u0004\u0000\u0000\u00bd\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c3\u0005.\u0000\u0000\u00c2\u00c4\u0007"+
		"\u0004\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c6:\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\u0005"+
		"\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0006\u001d"+
		"\u0000\u0000\u00ca<\u0001\u0000\u0000\u0000\u00cb\u00cf\u0005#\u0000\u0000"+
		"\u00cc\u00ce\b\u0006\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3\u0006\u001e\u0000\u0000\u00d3"+
		">\u0001\u0000\u0000\u0000\n\u0000W\u00a7\u00a9\u00b0\u00b2\u00ba\u00bf"+
		"\u00c5\u00cf\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}