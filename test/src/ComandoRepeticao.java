import java.util.ArrayList;


public class ComandoRepeticao extends Comando{
    private String condicao;
    
    public ComandoRepeticao(String condicao, ArrayList<Comando> listaComandos) {
        this.condicao = condicao;
        this.listaComandos = listaComandos;
    }

    private ArrayList<Comando>  listaComandos;
    
    @Override
    public String geradorCodigo() {
        String str = "\n\t while( " + this.condicao + " ){\n";
        for (Comando cmd : listaComandos) {
            str += cmd.geradorCodigo();
        }
        str += "\n\t }\n";
        return str;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public ArrayList<Comando> getListaComandos() {
        return listaComandos;
    }

    public void setListaComandos(ArrayList<Comando> listaComandos) {
        this.listaComandos = listaComandos;
    }
    

}
