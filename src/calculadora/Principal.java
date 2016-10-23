package calculadora;
import java.util.Scanner;

/**
 *
 * @author João Victor Vilela
 */
public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite uma expressão matemática:");
        System.out.println(Calculadora.calcular(input.nextLine()));
    }
}
