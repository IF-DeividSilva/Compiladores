public class ValidaVar {
    public static boolean validaVar(String var) {
        // verificando se a string var passada por parametro
        // começa com letra maiuscula seguida de letras minusculas ou maiusculas ou numeros em qualquer ordem
        // caso atenda os criterios retorna true
        if (var.matches("[A-Z][a-zA-Z0-9]*")) {
            return true;
        }
        return false;
    }
}
