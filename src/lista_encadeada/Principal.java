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
        Pilha novapilha = new Pilha();
        novapilha.empilhar("10");
        novapilha.empilhar("20");
        novapilha.empilhar("30");
        novapilha.empilhar("40");
        novapilha.empilhar("50");
        System.out.println(novapilha.desempilhar());
        novapilha.imprimirPilha();
    }
}
