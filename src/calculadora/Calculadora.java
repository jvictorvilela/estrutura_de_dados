package calculadora;
import lista_encadeada.Pilha;

/**
 *
 * @author João Victor Vilela
 */
public class Calculadora {

        
    
    
    public static int calcular(String expressaoEntrada) {
        int parAbertos;
        String op = null;
        String expressao;
        Pilha pilhaNumeros;
        Pilha pilhaOperacoes;
        Pilha pilhaNumerosFinal;
        Pilha pilhaOperacoesFinal;
        String[] arrayExpressao;
        String[] numerosArray;
        Calculadora auxiliar;
        int num = 0;
        
        expressao = "";
        pilhaNumeros = new Pilha();
        pilhaOperacoes = new Pilha();
        pilhaNumerosFinal = new Pilha();
        pilhaOperacoesFinal = new Pilha();

        int resultado = 0;
        parAbertos = 0; //Variável que controla os parenteses abertos.
        
        
        //Guarda apenas os números em um array
        numerosArray = expressaoEntrada.split("\\W");
        
        // Empilha os números, convertendo-os para int.
        for (int i = 0; i < numerosArray.length; i++) {
            if (!numerosArray[i].isEmpty()) {
                pilhaNumeros.empilhar(Integer.parseInt(numerosArray[i]));
            }
        }
        
        
        
        //Separa toda a expressão em um array
        arrayExpressao = expressaoEntrada.split("");
        
        //Procura por caracteres especiais e os coloca na pilha de operações
        for (int i = 0 ; i < arrayExpressao.length ; i++) {
            if (arrayExpressao[i].contains("+") || arrayExpressao[i].contains("-") || arrayExpressao[i].contains("*") || arrayExpressao[i].contains("/") || arrayExpressao[i].contains("(") || arrayExpressao[i].contains(")")) {
                pilhaOperacoes.empilhar(arrayExpressao[i]);
            }
        }
        
        
        // Coloca todos os elementos na pilha Final, resolvendo os parenteses.
        while (!pilhaNumeros.isVazia()) {
            op = (String)pilhaOperacoes.desempilhar();
            
            // verifica se existem prioridades na expressão.
            if ("(".equals(op)) {
                expressao = "";
                parAbertos = 1;
                while (parAbertos > 0) {
                    
                    num = (int)pilhaNumeros.desempilhar();
                    expressao = expressao+""+num;
                    op = (String)pilhaOperacoes.desempilhar();
                    
                    if (")".equals(op)) {
                        if (parAbertos < 1) {
                            expressao = expressao+""+op;
                        }
                        parAbertos--;
                    } else {
                        if ("(".equals(op)) {
                            parAbertos++;
                        }
                        expressao = expressao+""+op;
                    }
                }
                
                
                System.out.println(expressao);
                pilhaNumerosFinal.empilhar(calcular(expressao));
                
            } else {
                pilhaOperacoesFinal.empilhar(op);
                
                pilhaNumerosFinal.empilhar(pilhaNumeros.desempilhar());
            }
        }
        
        // Teste
        pilhaNumerosFinal.imprimirPilha();
        pilhaOperacoesFinal.imprimirPilha();
        // Fim teste
        
        
        // Resolve pilha Final.
        
        // Pequena gambiarra para resolver problema.
        
        
        while (op == null) {
            op = (String)pilhaOperacoesFinal.desempilhar();
        }
        
        resultado = (int)pilhaNumerosFinal.desempilhar();
        
        System.out.println("Pilhas Finais:");
        pilhaNumerosFinal.imprimirPilha();
        pilhaOperacoesFinal.imprimirPilha();
        System.out.println("Fim Pilhas Finais.");
        
        while (!pilhaNumerosFinal.isVazia()) {
            num = (int)pilhaNumerosFinal.desempilhar();
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
