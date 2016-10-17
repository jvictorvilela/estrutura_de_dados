package lista_encadeada;

// Pilha utilizando lista encadeada

/**
 *
 * @author João Victor Vilela
 */
public class Pilha {
    ListaEncadeada lista;
    
    public Pilha() {
        this.lista = new ListaEncadeada();
    }
    
    public boolean empilhar(Object item) {
        return this.lista.adicionarItemInicio(item);
    }
    
    public Object desempilhar() {
        return this.lista.excluirItem(0);
    }
    
    public void imprimirPilha() {
        this.lista.imprimirLista();
    }
    
    public boolean isVazia() {
        return lista.isVazia();
    }
}
