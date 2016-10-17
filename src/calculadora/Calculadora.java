package calculadora;
import lista_encadeada.Pilha;

/**
 *
 * @author João Victor Vilela
 */
public class Calculadora {
        private int parAbertos;
        private String op;
        private String expressao;
        private Pilha pilhaNumeros;
        private Pilha pilhaOperacoes;
        private Pilha pilhaNumerosFinal;
        private Pilha pilhaOperacoesFinal;
        private String[] arrayExpressao;
        private String[] numerosArray;
        private Calculadora auxiliar;
        private float num;
        
        public Calculadora() {
            
        }
    
    
    public float calcular(String expressaoEntrada) {
        auxiliar = new Calculadora();
        expressao = "";
        pilhaNumeros = new Pilha();
        pilhaOperacoes = new Pilha();
        pilhaNumerosFinal = new Pilha();
        pilhaOperacoesFinal = new Pilha();
        float a = 0;
        float b = 0;
        float resultado = 0;
        parAbertos = 0; //Variável que controla os parenteses abertos.
        
        
        //Guarda apenas os números em um array
        numerosArray = expressaoEntrada.split("\\W");
        
        // Empilha os números, convertendo-os para float.
        for (int i = (numerosArray.length)-1; i >= 0; i--) {
            if (!numerosArray[i].isEmpty()) {
                pilhaNumeros.empilhar(Float.parseFloat(numerosArray[i]));
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
        
        
        // Coloca todos os elementos da pilha Final, resolvendo os parenteses.
        while (!pilhaNumeros.isVazia()) {
            op = (String)pilhaOperacoes.desempilhar();
            
            // verifica se existem prioridades na expressão.
            if (op.equals("(")) {
                expressao = "";
                parAbertos = 1;
                while (parAbertos > 0) {
                    num = (float)pilhaNumeros.desempilhar();
                    expressao = expressao+""+num;
                    op = (String)pilhaOperacoes.desempilhar();
                    
                    if (op.equals(")")) {
                        if (parAbertos < 1) {
                            expressao = expressao+""+op;
                        }
                        parAbertos--;
                    } else {
                        if (op.equals("(")) {
                            parAbertos++;
                        }
                        expressao = expressao+""+op;
                    }
                }
                
                // teste:
                System.out.println(expressao);
                // fim teste.
                
                pilhaNumerosFinal.empilhar(auxiliar.calcular(expressao));
                
            } else {
                pilhaOperacoesFinal.empilhar(op);
                
                pilhaNumerosFinal.empilhar(pilhaNumeros.desempilhar());
            }
        }
        
        pilhaNumerosFinal.imprimirPilha();
        pilhaOperacoesFinal.imprimirPilha();
        // Resolver pilha Final.
        return 1;
    }
    
}
