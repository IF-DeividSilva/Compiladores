import java.util.ArrayList;
import java.util.HashMap;

public class TabelaSimbolo {
	HashMap<String, Simbolo> tabela;
	
	
	public ArrayList<Simbolo> getAll(){
		ArrayList<Simbolo> list= new ArrayList<Simbolo>();
		
		for(Simbolo simbolo: tabela.values()) {
			list.add(simbolo);
		}
		
		return list;
	}

	
	public TabelaSimbolo() {		
		this.tabela = new HashMap<String, Simbolo>();
	}

	public HashMap<String, Simbolo> getTabela() {
		return tabela;
	}

	public void setTabela(Simbolo simbolo) {
		this.tabela.put(simbolo.getNome(), simbolo);
	}
	
	public boolean exists(String nome) {
		return this.tabela.get(nome)!=null;
	}
	
	
}
