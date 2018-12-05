
package caracteres;

import java.util.Random;

/**
 *
 * @author HugoGuillin
 */
public class Hilo_Consumidor implements Runnable{
    
    private Bufer bufer=new Bufer();

    public Hilo_Consumidor(Bufer bufer) {
        this.bufer=bufer;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            bufer.consume();
        }
    }    
}
