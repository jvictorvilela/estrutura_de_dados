package calculadora;
import lista_encadeada.Fila;
import java.lang.Math;

/**
 *
 * @author João Victor Vilela
 */
public class Calculadora {
    public static float calcular(String exp) {
        String numString = ""; // String para concatenar os números.
        String opString; // String para guardar as operações
        String expString = "!"; // String para concatenar as expressões de dentro dos parenteses.
        String[] expressao; // Array que separa toda a expressão.
        short parenteses = 0;
        float resultado = 0;
        String num;
        String op;
        float b;
        
        Fila filaNum = new Fila();
        Fila filaOp = new Fila();
        
        expressao = exp.split((""));
        
        // Percorre todo o array expressao, separando numeros e operações e separando as expressoes entre parênteses.
        for (String aux : expressao) {
            
            // Verifica se é uma operação e se ela está fora dos parênteses.
            if ((aux.equals("+") || aux.equals("-") || aux.equals("*") || aux.equals("/") || aux.equals("^"))  && parenteses == 0) {
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
        
        
        num = (String)filaNum.desenfileirar(); // Desenfileira o primeiro número.
        
        // Corrige possível erro.
        if (num.isEmpty()) {
            num = (String)filaNum.desenfileirar();
        }
        
        if (num.contains("!")) {
            resultado = calcular(num);
        } else {
            resultado = Float.parseFloat(num);
        }
        
        while (!filaNum.isVazia()) {

            num = (String)filaNum.desenfileirar();
            op = (String)filaOp.desenfileirar();
            
            
            // Correção de possíveis erros.
            if (num.isEmpty()) {
                num = (String)filaNum.desenfileirar();
            }
            if (op.isEmpty()) {
                op = (String)filaOp.desenfileirar();
            }
            
            
            // Verifica se o número desenfileirado é uma expressão.
            if (num.contains("!")) {
                b = calcular(num);
            } else {
                b = Float.parseFloat(num);
            }
            
            switch (op) {
                case "+":
                    resultado = resultado + b;
                    break;
                case "-":
                    resultado = resultado - b;
                    break;
                case "*":
                    resultado = resultado * b;
                    break;    
                case "/":
                    resultado = resultado / b;
                    break;
                case "^":
                    resultado = (float)Math.pow(resultado,b);
                    break;
                default:
                    System.out.println("Erro! Operação inválida");
                    return 0;
            }        
        } 
        
        return resultado;
    }
}