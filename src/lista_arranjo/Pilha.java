package lista_arranjo;

// Pilha utilizando lista arranjo


/**
 *
 * @author João Victor Vilela
 */
public class Pilha {
    ListaArranjo lista;
    
    public Pilha() {
        lista = new ListaArranjo();
    }
    
    public boolean empilhar(Object item) {
        return lista.adicionarFinal(item);
    }
    
    public Object desempilhar() {
        return lista.excluirUltimo();
    }
    
    public void imprimirPilha() {
        lista.imprimirLista();
    }
}
