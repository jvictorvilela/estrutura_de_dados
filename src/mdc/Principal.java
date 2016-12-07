package mdc;
import java.util.Scanner;

/**
 *
 * @author João Victor Vilela
 */
public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float x;
        float y;
        x = input.nextFloat();
        y = input.nextFloat();
        System.out.println(Mdc.calcular(x, y));
    }
}
