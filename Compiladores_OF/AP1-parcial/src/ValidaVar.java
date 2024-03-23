public class ValidaVar {
    public static boolean validaVar(String var) {
        if (var.matches("[A-Z][a-zA-Z0-9]*")) {
            return true;
        }
        return false;
    }
}
