package lista_arranjo;

/**
 *
 * @author João Victor Vilela
 */
public class Principal {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.empilhar("10");
        p.empilhar("20");
        p.empilhar("30");
        p.empilhar("40");
        p.desempilhar();
        p.imprimirPilha();
    }
}
