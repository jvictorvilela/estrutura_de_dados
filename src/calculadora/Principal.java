package calculadora;

/**
 *
 * @author João Victor Vilela
 */
public class Principal {
    public static void main(String[] args) {
        
        Calculadora newcalculadora = new Calculadora();
        
        System.out.println(newcalculadora.calcular("5+(6*7)"));
    }
}
