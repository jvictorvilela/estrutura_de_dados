package inversao_de_strings;
import lista_arranjo.Pilha;
import java.util.Scanner;

/**
 *
 * @author João Victor Vilela
 */
public class Inversao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String texto;
        String[] palavras;
        Pilha pilha = new Pilha();
        texto = input.nextLine();
        palavras = texto.split(" ");
        for (String aux : palavras) {
            pilha.empilhar(aux);
        }
        for (int i = 0; i < palavras.length; i++) {
            System.out.print(pilha.desempilhar()+" ");
        }
        System.out.println();
    }
}
