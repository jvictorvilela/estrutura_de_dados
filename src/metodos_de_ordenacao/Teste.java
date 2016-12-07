/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_de_ordenacao;
import java.util.Random;

/**
 *
 * @author João Victor Vilela
 */
public class Teste {
    public static void main(String[] args) {
        
        Random numAleatorio = new Random();
        long tempoInicio;
        long tempoFim;

        int[] vetor = new int[16000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = numAleatorio.nextInt(500);
        }
       
       
        /*
        System.out.println("Itens desordenados:");
        for (int aux : vetor) {
            System.out.println(aux);
        }
*/
        
        // Iniciando a contagem do tempo.
        tempoInicio = System.currentTimeMillis();
        
        Ordenacao.mySort(vetor);
        
        // Finalizando a contagem do tempo.
        tempoFim = System.currentTimeMillis();
        
        long tempo = tempoFim-tempoInicio;
        
        
        /*
        System.out.println("Itens ordenados:");
        for (int aux : vetor) {
            System.out.println(aux);
        }
*/
        
        System.out.println();
        System.out.println("Tempo: "+tempo);
    }
}
