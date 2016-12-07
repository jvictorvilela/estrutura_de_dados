package metodos_de_ordenacao;

/**
 *
 * @author João Victor Vilela
 */
public interface Item {
    public int compara(Item it);
    public void alteraChave(Object chave);
    public Object getChave();
}
