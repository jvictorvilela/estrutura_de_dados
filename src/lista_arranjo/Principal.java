package lista_arranjo;

/**
 *
 * @author João Victor Vilela
 */
public class Principal {
    public static void main(String[] args) {
        ListaArranjo lista = new ListaArranjo();
        lista.adicionarFinal(11111);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal(10);
        lista.adicionarFinal("testando...");
        lista.adicionar(3, "Uhuu!");
        //System.out.println(lista.excluir(3));
        lista.excluirPrimeiro();
        lista.excluirUltimo();
        lista.alterarItem(5, ":D");
        
        lista.imprimirLista();
    }
}
