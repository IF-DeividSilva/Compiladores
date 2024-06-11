
public class Simbolo {
	String nome;
	String tipo;
	String valor;	
	
	
	public Simbolo(String nome, String tipo, String valor) {
		this.nome=nome;
		this.tipo=tipo;
		this.valor=valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Simbolo [nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + "]";
	}	
	
}
