package hashmap;

import java.io.IOException;

// java -jar antlr-4.7.2-complete.jar GyhRepaginada.g4 -o src

import java.util.HashMap;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Main {
	
/**
 * @param args
 */
public static void main(String[] args) {
	try{
	CharStream cs =  CharStream.fromFileName("programa1.gyh") ;
	GyhRepaginadaLexer lexer = new GyhRepaginadaLexer(cs);
	CommonTokenStream token = new CommonTokenStream(lexer);
	Token t;

	while((t=lexer.NextToken()).getType() != Token.EOF){
		System.out.println (t.toString())
	}
	
	}catch(IOException e){
		e.printStackTrace();
	}
	/*HashMap<Integer, String> carro = new HashMap<Integer, String>();
	
	carro.put(123, "Palio");
	carro.put(321, "Corsa");
	carro.put(255, "Escort");
	carro.put(254, "Chevette");
	carro.put(688, "HB20");
	carro.put(777, "Gol");
	
	for(int chave: carro.keySet()){
		System.out.println(carro.get(chave));
		}
	
	for(String c: carro.values()) {
		System.out.println(c);
		}*/

		
		
	}

}
