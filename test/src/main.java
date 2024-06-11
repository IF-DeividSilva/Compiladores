import java.io.IOException;
import java.util.HashMap;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class main {

	public static void main(String[] args) throws IOException {
		CharStream fromFileName = CharStreams.fromFileName("programa1.gyh");
		CharStream cs = fromFileName;
		GyhRepaginadoLanguageLexer lexer = new GyhRepaginadoLanguageLexer(cs);
		CommonTokenStream token = new CommonTokenStream(lexer);
		GyhRepaginadoLanguageParser parser = new GyhRepaginadoLanguageParser(token);
		
		parser.programa();
		
		/*
		Token t;
		
		while( (t=lexer.nextToken()).getType() != Token.EOF) {
			System.out.println("<"+ lexer.VOCABULARY.getSymbolicName(t.getType()) +"," + t.getText()+">");
			//< Lexema, Padrao>
		}	
		*/
	}

}


//TODO Auto-generated method stub
		/*HashMap<Integer, String> carro = new HashMap<Integer, String>(); 
		
		carro.put(123, "Mustang");
		carro.put(124, "Uno");
		carro.put(125, "Corvet");
		carro.put(126, "Fusca");
		carro.put(127, "Corsa");
		carro.put(128, "Marea");
		carro.put(129, "Yaris");
		
		for(int i=123; i<130; ++i) {
			System.out.println(carro.get(i));
		}
		
		
		
		carro.put(123, "Mustang");
		carro.put(321, "Uno");
		carro.put(255, "Corvet");
		carro.put(522, "Fusca");
		carro.put(888, "Corsa");
		carro.put(789, "Marea");
		carro.put(233, "Yaris");
		/*
		//imprimindo usando as chaves 
		for(int chave: carro.keySet()) {
			System.out.println(carro.get(chave));
		}
		
		
		//imprimindo usando informação 
		for(String c: carro.values()) {
			System.out.println(c);
		}
		*/
