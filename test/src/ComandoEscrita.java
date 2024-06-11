public class ComandoEscrita extends Comando{

	private String id; 
	
	@Override
	public String geradorCodigo() {		
		String str="\n\tprintf(\"%d\","+this.id+");"; 
		return str;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}

