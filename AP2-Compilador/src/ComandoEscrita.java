public class ComandoEscrita extends Comando{

	private String id; 
	private String cadeia;
	
	public String getCadeia() {
		return cadeia;
	}

	public void setCadeia(String cadeia) {
		this.cadeia = cadeia;
	}

	@Override
	public String geradorCodigo() {
		String str=null;
		if (cadeia != null) {
			// Se uma cadeia foi definida, imprima a cadeia
			str = "\n\tprintf(" + this.cadeia + ");";
		} else {
			// Caso contrário, imprima o identificador
			str = "\n\tprintf(\"%d\","+this.id+");";
		}
		return str;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}

