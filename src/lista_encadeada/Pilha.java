package lista_encadeada;

// Pilha utilizando lista encadeada

/**
 *
 * @author João Victor Vilela
 */
public class Pilha {
    ListaEncadeada lista;
    
    public Pilha() {
        lista = new ListaEncadeada();
    }
    
    public boolean empilhar(Object item) {
        return lista.adicionarItemInicio(item);
    }
    
    public Object desempilhar() {
        return lista.excluirItem(0);
    }
    
    public void imprimirPilha() {
        lista.imprimirLista();
    }
}
