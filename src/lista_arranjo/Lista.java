package lista_arranjo;

/**
 *
 * @author João Victor Vilela
 */
public class Lista {
    private int tam; // Tamanho atual do array.
    private int ultimo; // Indica a posição do ultimo elemento + 1.
    private int i;
    private Object lista[];
    private Object listaAuxiliar[];
    
    public Lista() {
        this.ultimo = 0;
        this.tam = 10;
        this.lista = new Object[tam];
    }
    
    public void ampliarLista() {
        this.listaAuxiliar = new Object[tam*2];
        
        // Copiando os itens do array antigo para o array auxiliar.
        i = 0;
        for (Object aux : lista) {
            this.listaAuxiliar[i] = aux;
            this.i++;
        }
        this.lista = this.listaAuxiliar;
        this.tam = this.tam*2;
    }
    
    // Método que recebe um índice e um item, e adiciona o item no índice informado.
    public boolean adicionar(int indice, Object item) {
        // Verifica possíveis erros.
        if (indice < 0 || indice > this.tam) {
            return false;
        }
        
        // Verifica se a lista está cheia.
        if (this.ultimo > this.tam) {
            this.ampliarLista();
        }
        
        if (indice == this.ultimo) {
            this.lista[ultimo] = item;
        } else {
            
        }   
        
        ultimo++;
        return true;
    }
    
    // Método que adiciona item no final da lista.
    public boolean adicionarFinal(Object item) {
        return this.adicionar(this.ultimo, item);
    }
    
}
