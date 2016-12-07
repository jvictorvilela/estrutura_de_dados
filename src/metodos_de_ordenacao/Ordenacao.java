package metodos_de_ordenacao;

/**
 *
 * @author João Victor Vilela
 */

// Classe com métodos de ordenação.
public class Ordenacao {
    
    // Selection Sort
    public static void selectionSort(int vetor[]) {
        // Percorre todo o array
        for (int i = 0; i < vetor.length; i++) {
            int min = i;
            // Percorre o array procurando um item menor que "min"
            for (int j = i+1; j < vetor.length; j++) {
                // Compara o item da posição J com o item "min" e verifica qual o menor.
                if (vetor[j] < vetor[min]) {
                    min = j;
                }
            }
            
            // Realiza a troca do menor com o que está no posição min
            int x = vetor[min];
            vetor[min] = vetor[i];
            vetor[i] = x;
        }
    }
    // Selection Sort
    
    
    // Insertion Sort
    
    /* 
    O método começa da posição 1, e a medida que vai percorrendo as outras posiçãos, vai recolocando em seu devido lugar.
    */
    public static void insertionSort(int vetor[]) {
        int j;
        for (int i = 1; i < vetor.length; i++) { // Percorre todo o array a partir do elemento 1.
            int x = vetor[i]; // X é o elemento que vai ser colocado na sua posição correta na esquerda do array.
            j = i-1;
            
            vetor[0] = x; // Sentinela (A primeira posição do array é a sentinela, o x sempre será colocado nesta posição do array).
            while (x < vetor[j]) { 
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = x;
        }
    }
    // Fim Insertion Sort
    
    
    // Shell Sort
    public static void shellSort(int[] vetor) {
        int h = 1; // A váriavel h vai definir o salto.
        do {
            h = h*3+1;
        } while (h < vetor.length);
        do {
            h /= 3;
            for (int i = h+1; i < vetor.length; i++) {
                int x = vetor[i];
                int j = i;
                while(vetor[j-h] > x) {
                    vetor[j] = vetor[j-h];
                    j -= h;
                    if (j <= h) {
                        break;
                    }
                }
                vetor[j] = x;
            }
        } while(h != 1); 
    }
    // Fim Shell Sort
 

    // Quick sort   
    public static void quickSort(int[] vetor) {
        quickSort(vetor, 0, vetor.length-1);
    }
        
        

    
    private static void quickSort(int[] vetor, int inicio, int fim) {
        
          if (inicio < fim) {
                 int posicaoPivo = separar(vetor, inicio, fim); // Coloca o pivô no lugar correto.
                 quickSort(vetor, inicio, posicaoPivo - 1);
                 quickSort(vetor, posicaoPivo + 1, fim);
          }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
          int posicaoPivo = inicio; // Posição do pivo
          int pivo = vetor[posicaoPivo]; // Valor do pivô
          int i = inicio;
          int f = fim;
          while (i <= f) {
                 if (vetor[i] <= pivo) // Incrementa o "incio" até encontrar um valor maior que o pivô
                        i++;
                 else if (pivo < vetor[f]) // Decrementa o "fim" até encontrar um valor menor ou igual ao pivô
                        f--;
                 else { // i troca de posição com f.
                    int troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;

                 } // Se "fim" utrapassar "inicio", sai do laço.
          }
          
          // Troca o valor do pivô com o valor de "fim". 
          if (vetor[f] != pivo) {
            vetor[posicaoPivo] = vetor[f];
            vetor[f] = pivo;
            
          }
          return f;
    }
    // Fim Quick Sort
    
    
    // Merge Sort
    public static void mergeSort(int[] vetor)  {
        int[] aux = new int[vetor.length];
        mergeSort(vetor, aux,  0,  vetor.length - 1);
    }


    /*
    Este método realiza a divisão do vetor recursivamente até que não seja mais possível realizar a divisão.
    */
    
    private static void mergeSort(int[] vetor, int[] aux, int left, int right) {
        if( left < right ) {
            int center = (left + right) / 2;
            mergeSort(vetor, aux, left, center);
            mergeSort(vetor, aux, center + 1, right);
            merge(vetor, aux, left, center + 1, right);
        }
    }


    private static void merge(int[] vetor, int[] aux, int left, int right, int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd) {
            if(vetor[left] <= vetor[right]) {
                aux[k++] = vetor[left++];
            }
            else {
                aux[k++] = vetor[right++];
            }
        }

        while(left <= leftEnd) {
            aux[k++] = vetor[left++];
        }

        while(right <= rightEnd) {
            aux[k++] = vetor[right++];
        }

        for(int i = 0; i < num; i++, rightEnd--) {
            vetor[rightEnd] = aux[rightEnd];
        }
    }
    // Fim Merge Sort
    
    
    
    // MySort
    public static void mySort(int[] vetor) {
        int aux;
        for (int i = 0; i < vetor.length; i++) { 
            for (int j = 0; j < vetor.length-1; j++) {
                if (vetor[j] > vetor[j+1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
    }
    // Fim MySort
    
}
