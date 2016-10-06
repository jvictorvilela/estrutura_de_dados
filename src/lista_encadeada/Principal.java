/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_encadeada;

/**
 *
 * @author aluno
 */
public class Principal {
    public static void main(String[] args) {
        Fila novaFila = new Fila();
        novaFila.enfileirar("10");
        novaFila.enfileirar("20");
        novaFila.enfileirar("30");
        novaFila.enfileirar("40");
        novaFila.enfileirar("50");
        
        novaFila.imprimirFila();
        System.out.println(novaFila.desenfileirar());
        System.out.println("");
        novaFila.imprimirFila();
    }
}
