package calculadora;
import lista_encadeada.Pilha;
import lista_encadeada.Fila;

/**
 *
 * @author João Victor Vilela
 */
public class Calculadora_old {

        
    
    
    public static int calcular(String expressaoEntrada) {
        int parAbertos;
        String op = null;
        String expressao;
        Pilha pilhaNumeros;
        Pilha pilhaOperacoes;
        Fila filaNumerosFinal;
        Fila filaOperacoesFinal;
        String[] arrayExpressao;
        String[] numerosArray;
        Calculadora_old auxiliar;
        int num = 0;
        int cont = 0;
        
        expressao = "";
        pilhaNumeros = new Pilha();
        pilhaOperacoes = new Pilha();
        filaNumerosFinal = new Fila();
        filaOperacoesFinal = new Fila();

        int resultado = 0;
        parAbertos = 0; //Variável que controla os parenteses abertos.
        
        
        //Guarda apenas os números em um array
        numerosArray = expressaoEntrada.split("\\W");
        
        // Empilha os números, convertendo-os para int.
        for (int i = (numerosArray.length)-1; i >= 0; i--) {
            if (!numerosArray[i].isEmpty()) {
                pilhaNumeros.empilhar(Integer.parseInt(numerosArray[i]));
            }
        }
        
        
        //Separa toda a expressão em um array
        arrayExpressao = expressaoEntrada.split("");
        
        //Procura por caracteres especiais e os coloca na pilha de operações
        for (int i = (arrayExpressao.length)-1 ; i >= 0 ; i--) {
            if (arrayExpressao[i].contains("+") || arrayExpressao[i].contains("-") || arrayExpressao[i].contains("*") || arrayExpressao[i].contains("/") || arrayExpressao[i].contains("(") || arrayExpressao[i].contains(")")) {
                pilhaOperacoes.empilhar(arrayExpressao[i]);
            }
        }
        
        //Apenas para fins de teste.
        System.out.println("Imprimindo pilhas de numeros e operações:");
        pilhaNumeros.imprimirPilha();
        pilhaOperacoes.imprimirPilha();
        //
        
        
        // Coloca todos os elementos nas filas Finais, resolvendo os parenteses.
        while (!pilhaNumeros.isVazia()) {
            
            if (cont == 0) {
                op = (String)pilhaOperacoes.desempilhar();
            }
            
            // verifica se existem prioridades na expressão.
            if ("(".equals(op)) {
                expressao = "";
                parAbertos = 1;
               

                while (parAbertos > 0) {  
                    
                    op = (String)pilhaOperacoes.desempilhar();
                    
                    if (")".equals(op)) {
                        if (parAbertos > 1) {
                            num = (int)pilhaNumeros.desempilhar();
                            expressao = expressao+""+num;
                            expressao = expressao+""+op;
                            parAbertos--;
                        } else {

                            num = (int)pilhaNumeros.desempilhar();
                            expressao = expressao+""+num;
                            parAbertos--;
                        }
                    } else {
                        if ("(".equals(op)) {
                            parAbertos++;
                            expressao = expressao+""+op;
                        } else {
                            num = (int)pilhaNumeros.desempilhar();
                            expressao = expressao+""+num;
                            expressao = expressao+""+op;
                        }
                    }
                }

                System.out.println(expressao);
                filaNumerosFinal.enfileirar(calcular(expressao));
                op = (String)pilhaOperacoes.desempilhar();
                
            } else {
                filaOperacoesFinal.enfileirar(op);
                op = (String)pilhaOperacoes.desempilhar();
                if (!"(".equals(op) || cont == 0) {
                    filaNumerosFinal.enfileirar(pilhaNumeros.desempilhar());
                }
                
            }
            
            cont++;
        }
        
        // Teste
        filaNumerosFinal.imprimirFila();
        filaOperacoesFinal.imprimirFila();
        // Fim teste
        
        
        // Resolve fila Final.
        
        // Pequena gambiarra para resolver problema.
        op = (String)filaOperacoesFinal.desenfileirar();
        while (op == null) {
            op = (String)filaOperacoesFinal.desenfileirar();
        }
        
        resultado = (int)filaNumerosFinal.desenfileirar();
        
        
        while (!filaNumerosFinal.isVazia()) {
            num = (int)filaNumerosFinal.desenfileirar();
            //op = (String)pilhaOperacoesFinal.desempilhar();
            //System.out.println(op);
            
            switch (op) {
                case "+":
                    resultado = resultado+num;
                    break;
                case "-":
                    resultado = resultado-num;
                    break;
                case "*":
                    resultado = resultado*num;
                    break;
                case "/":
                    System.out.println(resultado+"/"+num+"=");
                    resultado = resultado/num;
                    break;
                default:
                    System.out.println("Erro!");
                    break;
            } 

        }

        return resultado;
    }
    
}
