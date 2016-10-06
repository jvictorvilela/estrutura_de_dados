package fila_circular;

/**
 *
 * @author João Victor Vilela
 */
public class FilaCircular {
    int tam;
    Object[] lista;
    int t;
    int f;
    public FilaCircular() {
        tam = 6;
        lista = new Object[tam];
        t = 0;
        f = 0;
    }
    
   public boolean isVazia() {
       return t==f;
   }
   
   public boolean isCheia() {
       return (t+1)%tam==f;
   }
   
   public boolean enfileirar(Object item) {
       if (isCheia()) {
           return false;
       }
       
       this.lista[t] = item;
       t = (t+1)%tam;
       return true;
   }
   
   public Object desenfileirar() {
       Object retorno;
       if (isVazia()) {
           return false;
       }
       
       retorno = lista[f];
       f = (f+1)%tam;
       return retorno;
   }
   
   public void imprimirFila() {
       //
   }
   
}
