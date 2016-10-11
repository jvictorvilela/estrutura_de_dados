package calculadora;
import lista_encadeada.Pilha;

/**
 *
 * @author João Victor Vilela
 */
public class Calculadora {
    Pilha pilha;
    String[] numerosArray;
    String[] operacoesArray;
    public Calculadora() {
        pilha = new Pilha();
    }
    
    public String calcular(String expressao) {
        this.numerosArray = expressao.split("\\W");
        this.operacoesArray = expressao.split("\\w");
        return operacoesArray[0];
    }
    
}
