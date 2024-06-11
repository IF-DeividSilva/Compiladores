public class ComandoAtribuicao extends Comando {
    public String id;
	public String exp;
    
    public ComandoAtribuicao(String id, String exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String geradorCodigo() {
        // TODO Auto-generated method stub
        String str =null;
        str = "\n\t"+this.id+" = "+this.exp+";";
        return str;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

}
