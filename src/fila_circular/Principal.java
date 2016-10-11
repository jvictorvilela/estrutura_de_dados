package fila_circular;

/**
 *
 * @author João Victor Vilela
 */
public class Principal {
    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular();
        fila.enfileirar(10);
        fila.enfileirar(11);
        fila.enfileirar(12);
        fila.enfileirar(13);
        fila.enfileirar(14);
        fila.enfileirar(15);
        fila.enfileirar(16);
        fila.enfileirar(17);
        fila.enfileirar(18);
        fila.enfileirar(19);
        fila.enfileirar(20);
        fila.enfileirar(21);
        fila.enfileirar(22);
        fila.enfileirar(23);
        fila.enfileirar(24);
        fila.enfileirar(25);
        fila.enfileirar(26);
        
        fila.imprimirFila();
        System.out.println(fila.desenfileirar());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.desenfileirar());
        fila.enfileirar("teste");
        fila.enfileirar("teste");
        fila.enfileirar("teste");
        fila.enfileirar("teste");
        fila.imprimirFila();
    }
}
