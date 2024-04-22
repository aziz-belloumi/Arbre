package EXsupp;

public class Main {
    public static void main(String[] args) {
        ExpressionEquilbre s = new ExpressionEquilbre();
        String exp1 = "(dbfe)dbhzdbzh(scack)";
        String exp2 = "()(()";
        boolean temp = s.estEquilibre(exp2);
        int a = s.trouverPremierDelimiteurIncorrect(exp2);
        System.out.println(a);
        System.out.println(temp);
        
    }
}
