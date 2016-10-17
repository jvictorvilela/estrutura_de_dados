package lista_encadeada;

/**
 *
 * @author João Victor Vilela
 */
public class ListaEncadeada {
    private Celula primeiraCelula; // Ponteiro para a primeira celula.
    private Celula novaCelula; // Ponteiro para a última célula criada.
    private Celula celulaAnterior; // Ponteiro para a penultima célula criada.
    private int numeroCelulas; // Número de células existentes na lista.
    
    public ListaEncadeada() {
        numeroCelulas = 0;
        primeiraCelula = null;
        celulaAnterior = null;
        novaCelula = null;
    }
    
    public boolean isVazia() {
        if (numeroCelulas == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getNumeroCelulas() {
        return numeroCelulas;
    }
    
    public boolean adicionarItemInicio(Object conteudo) {
        if (conteudo == null) {
            return false;
        }
        novaCelula = new Celula(conteudo);
        novaCelula.setLink(primeiraCelula);
        primeiraCelula = novaCelula;
        this.numeroCelulas++;
        return true;
    }
    
    public boolean adicionarItem(Object conteudo) {
        if (conteudo == null) {
            return false;
        }
        novaCelula = new Celula(conteudo);
        if (numeroCelulas == 0) {
            primeiraCelula = novaCelula;
        } else {
            celulaAnterior.setLink(novaCelula);
        }
        celulaAnterior = novaCelula;
        numeroCelulas++;
        return true;
    }
    
    
    public Object excluirItem(int indice) {
        
        // Verificação de possíveis erros.
        if (indice < 0 || indice >= numeroCelulas) {
            return null;
        }
        
        if (numeroCelulas == 0) {
            return null;
        }
        
        if (numeroCelulas == 1) {
            Celula atual = getCelula(indice);
            this.primeiraCelula = null;
            this.numeroCelulas--;
            return atual.getConteudo();
        }
        
        if (indice == 0) {
            Celula atual = getCelula(0);
            Celula proxima = atual.getLink();
            this.primeiraCelula = proxima;
            this.numeroCelulas--;
            return atual.getConteudo();
        }
        
        Celula anterior = getCelula(indice-1);
        Celula atual = anterior.getLink();
        Celula proxima = atual.getLink();
        anterior.setLink(proxima);
        numeroCelulas--;
        return atual.getConteudo();
    }
    
    public Object excluirUltimo() {
        return this.excluirItem(numeroCelulas-1);
    }
    
    public void imprimirLista() {
        Celula link = primeiraCelula;
        for (int i = 0; i < numeroCelulas; i++) {
            System.out.println(link.getConteudo());
            link = link.getLink();
        }
    }
    
    public Object getItem(int indice) {
        if (indice < numeroCelulas && indice >= 0) {
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
    
    
    public Celula getCelula(int indice) {
        if (indice < numeroCelulas && indice >= 0) {
            Celula link = primeiraCelula;
            if (indice == 0) {
               return link;
            } else {
                for (int i = 0; i < indice; i++) {
                    link = link.getLink();
                }
            }
            return link;
        } else {
            return null;
        }
    }
    
    
}