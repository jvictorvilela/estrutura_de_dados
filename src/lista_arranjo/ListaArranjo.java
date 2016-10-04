package lista_arranjo;

/**
 *
 * @author João Victor Vilela
 */
public class ListaArranjo {
    private int tam; // Tamanho atual do array.
    private int ultimo; // Indica a posição do ultimo elemento + 1.
    private int i;
    private Object lista[];
    private Object listaAuxiliar[];
    
    public ListaArranjo() {
        this.ultimo = 0;
        this.tam = 10;
        this.lista = new Object[tam];
    }
    
    public boolean isVazia() {
        if (ultimo == 0) {
            return true;
        } else {
            return false;
        }
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
        if (indice < 0 || indice > this.ultimo) {
            return false;
        }
        
        // Verifica se a lista está cheia.
        if (this.ultimo == this.tam) {
            this.ampliarLista();
        }
        
        if (indice == this.ultimo) {
            this.lista[indice] = item;
        } else {
            // Realoca os itens da lista
            for (i = this.ultimo-1; i >= indice; i--) {
                this.lista[i+1] = this.lista[i];
            }
            this.lista[indice] = item;
        }   
        
        ultimo++;
        return true;
    }
    
    // Método que adiciona item no final da lista.
    public boolean adicionarFinal(Object item) {
        return this.adicionar(this.ultimo, item);
    }
    
    // Método que adiciona item no inicio da lista.
    public boolean adicionarInicio(Object item) {
        return this.adicionar(0, item);
    }
    
    public Object excluir(int indice) {
        Object item;
        
        // Verifica possíveis erros.
        if (isVazia()) {
            return null;
        }
        if (indice < 0 || indice > this.ultimo) {
            return null;
        }
        
        item = this.lista[indice];
        //this.lista[indice] = null;
        
        // Realoca os itens, caso precise.
        if (indice < ultimo-1) {
            for (i = indice; i < this.ultimo; i++) {
                this.lista[i] = this.lista[i+1];
            }
        }
        
        this.lista[ultimo-1] = null;
        
        this.ultimo--;
        return item;
    }
    
    public Object excluirUltimo() {
        return excluir(ultimo-1);
    }
    
    public Object excluirPrimeiro() {
        return excluir(0);
    }
    
    public void alterarItem(int indice, Object item) {
        if (indice < 0 || indice > this.ultimo-1) {
            // Erro!
        } else {
            this.lista[indice] = item;
        }
    }
    
    // Método que imprime os itens da lista.
    public void imprimirLista() {
        if (this.isVazia()) {
            System.out.println("A lista está vazia!");
        } else {
            for (i = 0; i < ultimo; i++) {
                System.out.println(this.lista[i]);
            }
        }
    }
    
}
