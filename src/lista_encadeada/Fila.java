package lista_encadeada;

/**
 *
 * @author João Victor Vilela
 */
public class Fila {
    ListaEncadeada lista;
    public Fila() {
        this.lista = new ListaEncadeada();
    }
    
    public boolean enfileirar(Object item) {
        return this.lista.adicionarItem(item);
    }
    
    public Object desenfileirar() {
        return this.lista.excluirItem(0);
    }
    
    public void imprimirFila() {
        this.lista.imprimirLista();
    }
}
