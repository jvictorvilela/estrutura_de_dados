package lista_encadeada;

/**
 *
 * @author João Victor
 */
public class Celula {
    private Object conteudo; // Conteúdo da célula
    private Celula link; // Ponteiro para a próxima célula.
    
    public Celula(Object conteudo) {
        this.conteudo = conteudo;
    }
    
    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }
    
    public Object getConteudo() {
        return this.conteudo;
    }
    
    public void setLink(Celula link) {
        this.link = link;
    }
    
    public Celula getLink() {
        return link;
    }
}