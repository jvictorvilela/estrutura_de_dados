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
        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionarItem(10);
        lista.adicionarItem(11);
        lista.adicionarItem(12);
        lista.adicionarItem(11);
        lista.adicionarItem(12);
        lista.adicionarItem(13);
        lista.adicionarItem(14);
        lista.adicionarItem(15);
        lista.adicionarItem(16);
        lista.adicionarItem(17);
        lista.imprimirLista();
        System.out.println("-----------");
        lista.excluirItem(3);
        lista.excluirUltimo();
        lista.excluirUltimo();
        lista.excluirUltimo();
        lista.excluirUltimo();
        lista.excluirUltimo();
        lista.imprimirLista();
    }
}
