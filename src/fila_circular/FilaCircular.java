package fila_circular;

/**
 *
 * @author João Victor Vilela
 */
public class FilaCircular {
    int tam;
    Object[] lista;
    int tras;
    int frente;
    
    public FilaCircular() {
        tam = 10;
        lista = new Object[tam];
        tras = 0;
        frente = 0;
    }
    
   public boolean isVazia() {
       return tras==frente;
   }
   
   public boolean isCheia() {
       return (tras+1)%tam==frente;
   }
   
   public boolean enfileirar(Object item) {
       if (isCheia()) {
           System.out.println("A fila está cheia!");
           return false;
       }
       
       this.lista[tras] = item;
       tras = (tras+1)%tam;
       return true;
   }
   
   public Object desenfileirar() {
       Object retorno;
       if (isVazia()) {
           return false;
       }
       
       retorno = lista[frente];
       frente = (frente+1)%tam;
       return retorno;
   }
   
   public void imprimirFila() {
       int i = frente;
       while (i != tras-1) {
           System.out.println(lista[i]);
           i = (i+1)%tam;
       }
   }
   
}
