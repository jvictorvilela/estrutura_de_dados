package lista_encadeada;

/**
 *
 * @author João Victor
 */
public class ListaEncadeada {
    private Celula primeiraCelula; // Ponteiro para a primeira celula.
    private Celula novaCelula; // Ponteiro para a última célula criada.
    private Celula celulaAnterior; // Ponteiro para a penultima célula criada.
    private int numeroCelulas; // Número de células existentes na lista.
    
    public ListaEncadeada() {
        numeroCelulas = 0;
        celulaAnterior = null;
        novaCelula = null;
    }
    
    public int getNumeroCelulas() {
        return numeroCelulas;
    }
    
    public void adicionarItem(Object conteudo) {
        novaCelula = new Celula (conteudo);
        if (numeroCelulas == 0) {
            primeiraCelula = novaCelula;
        } else {
            celulaAnterior.setLink(novaCelula);
        }
        celulaAnterior = novaCelula;
        numeroCelulas++;
    }
    
    public void excluirItem(int indice) {
        
    }
    
    public void imprimirLista() {
        Celula link = primeiraCelula;
        for (int i = 0; i < numeroCelulas; i++) {
            System.out.println(link.getConteudo());
            link = link.getLink();
        }
    }
    
    public Object getItem(int indice) {
        if (indice < numeroCelulas && indice > 0) {
            Celula link = primeiraCelula;
            if (indice == 0) {
               return link.getConteudo();
            } else {
                for (int i = 0; i < indice; i++) {
                    link = link.getLink();
                }
            }
            return link.getConteudo();
        } else {
            return null;
        }
    }
}