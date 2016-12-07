package metodos_de_ordenacao;

/**
 *
 * @author João Victor Vilela
 */

/* 

A = 1
B = 2
C = 3
D = 4
E = 5
F = 6
G = 7
H = 8
I = 9
J = 10
K = 11
L = 12
M = 13
N = 14
O = 15
P = 16
Q = 17
R = 18
S = 19
T = 20
U = 21
V = 22
X = 23
Y = 24
Z = 25

*/
public class Letra implements Item {
    int chave;
    Object item;
    public Letra(Object item, int chave) {
        this.item = item;
        this.chave = chave;
    }
    
    public int compara(Item it) {
        Letra item = (Letra)it;
        if (this.chave < item.chave) {
            return -1;
        } else if (this.chave > item.chave) {
            return 1;
        }
        return 0;
    }
    
    public void alteraChave (Object chave) {
        Integer ch = (Integer)chave;
        this.chave = ch.intValue();
    }
    public Object getChave() {
        return this.chave;
    }
}
