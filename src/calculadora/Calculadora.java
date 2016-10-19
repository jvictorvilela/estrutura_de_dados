package calculadora;
import lista_encadeada.Fila;

/**
 *
 * @author João Victor Vilela
 */
public class Calculadora {
    public static void calcular(String exp) {
        String numString = ""; // String para concatenar os números.
        String opString; // String para guardar as operações
        String expString = "!"; // String para concatenar as expressões de dentro dos parenteses.
        String[] expressao; // Array que separa toda a expressão.
        short parenteses = 0;
        
        Fila filaNum = new Fila();
        Fila filaOp = new Fila();
        
        expressao = exp.split((""));
        
        // Percorre todo o array expressao, separando numeros e operações e separando as expressoes entre parênteses.
        for (String aux : expressao) {
            
            // Verifica se é uma operação e se ela está fora dos parênteses.
            if ((aux.equals("+") || aux.equals("-") || aux.equals("*") || aux.equals("/")) && parenteses == 0) {
                filaOp.enfileirar(aux);
                
                // Enfileira os números que estavam sendo concatenados.
                filaNum.enfileirar(numString);
                numString = "";
                
            } else {
                
                // Verifica se está dentro de um parêntese.
                if (parenteses >= 1) {
                    if (aux.equals(")")) {
                        parenteses--;
                        
                        // Verifica se acabou a expressão que estava dentro do parêntese.
                        if (parenteses == 0) {
                            
                            // Enfileira toda a expressão dentro da fila dos números.
                            filaNum.enfileirar(expString);
                            expString = "!";
                        } else {
                            expString = expString+aux;
                        }
                        
                    } else {
                        expString = expString+aux;
                    }
                } else {
                    if (!aux.equals("(") && !aux.equals("!")) {
                        numString = numString+aux;
                    }
                } 
                
                if (aux.equals("(")) {
                    parenteses++;
                }

            }
        }
        
        // Verifica se restou algum número a direita.
        if (!numString.isEmpty()) {
            filaNum.enfileirar(numString);
            numString = "";
        }
        
        
        // Calcular as filas ....
        
        
        
        System.out.println("Pilha dos números:");
        filaNum.imprimirFila();
        System.out.println("Pilha das operações:");
        filaOp.imprimirFila();
        
    }
}
