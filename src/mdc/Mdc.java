package mdc;

/**
 *
 * @author João Victor Vilela
 */
public class Mdc {
    public static float calcular(float x, float y) {  
        if (y <= x && x % y == 0) {  
            return y;  
        } else if (y < x) {  
            return calcular(y, x);  
        } else {  
            return calcular(y, x % y);  
        }  
    }   
}

