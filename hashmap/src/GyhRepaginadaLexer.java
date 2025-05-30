// Generated from GyhRepaginada.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GyhRepaginadaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IniDelim=1, FimDelim=2, Atrib=3, OpRel=4, PCProg=5, PCDec=6, Var=7, Cadeia=8, 
		NumInt=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IniDelim", "FimDelim", "Atrib", "OpRel", "PCProg", "PCDec", "Var", "Cadeia", 
			"NumInt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'<<'", null, "'prog'", "'dec'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IniDelim", "FimDelim", "Atrib", "OpRel", "PCProg", "PCDec", "Var", 
			"Cadeia", "NumInt"
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


	public GyhRepaginadaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GyhRepaginada.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13H\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5$\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\7\b\61\n\b\f\b\16\b\64\13\b\3\t\3\t\3"+
		"\t\7\t9\n\t\f\t\16\t<\13\t\3\t\3\t\3\t\3\t\5\tB\n\t\3\n\6\nE\n\n\r\n\16"+
		"\nF\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\5\3\2C\\\5\2\62"+
		";C\\c|\3\2\62;\2O\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2"+
		"\2\5\27\3\2\2\2\7\31\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r*\3\2\2\2\17.\3\2"+
		"\2\2\21A\3\2\2\2\23D\3\2\2\2\25\26\7]\2\2\26\4\3\2\2\2\27\30\7_\2\2\30"+
		"\6\3\2\2\2\31\32\7>\2\2\32\33\7>\2\2\33\b\3\2\2\2\34\35\7@\2\2\35$\7?"+
		"\2\2\36\37\7>\2\2\37$\7?\2\2 $\7>\2\2!\"\7>\2\2\"$\7@\2\2#\34\3\2\2\2"+
		"#\36\3\2\2\2# \3\2\2\2#!\3\2\2\2$\n\3\2\2\2%&\7r\2\2&\'\7t\2\2\'(\7q\2"+
		"\2()\7i\2\2)\f\3\2\2\2*+\7f\2\2+,\7g\2\2,-\7e\2\2-\16\3\2\2\2.\62\t\2"+
		"\2\2/\61\t\3\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2"+
		"\63\20\3\2\2\2\64\62\3\2\2\2\65\66\7$\2\2\66:\t\2\2\2\679\t\3\2\28\67"+
		"\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;B\3\2\2\2<:\3\2\2\2=B\5\t\5\2>"+
		"?\5\7\4\2?@\7$\2\2@B\3\2\2\2A\65\3\2\2\2A=\3\2\2\2A>\3\2\2\2B\22\3\2\2"+
		"\2CE\t\4\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\24\3\2\2\2\n\2#"+
		"\60\628:AF\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}