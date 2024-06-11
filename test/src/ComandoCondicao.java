import java.util.ArrayList;

public class ComandoCondicao extends Comando{
	public String condicao;
	public ArrayList<Comando> listTrue;
	public ArrayList<Comando> listFalse;


    public ComandoCondicao(String condicao, ArrayList<Comando> listTrue, ArrayList<Comando> listFalse) {
	    this.condicao = condicao;
	    this.listTrue = listTrue;
	    this.listFalse = listFalse;
	}
    


    @Override
    public String geradorCodigo() {
        String str="\n\t if( "+this.condicao+" ){\n";
        for(Comando cmd: listTrue) {
            str+=cmd.geradorCodigo();
        }
        str+="\n\t }\n";
        
        if(listFalse.isEmpty()==false) {
            str+="\t else {\n";
            for(Comando cmd: listFalse) {
                str+=cmd.geradorCodigo();
            }
            str+="\t }\n";
        }
        return str;
    }


    public String getCondicao() {
        return condicao;
    }


    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }


    public ArrayList<Comando> getListTrue() {
        return listTrue;
    }


    public void setListTrue(ArrayList<Comando> listTrue) {
        this.listTrue = listTrue;
    }


    public ArrayList<Comando> getListFalse() {
        return listFalse;
    }


    public void setListFalse(ArrayList<Comando> listFalse) {
        this.listFalse = listFalse;
    }
        

	}
