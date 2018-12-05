
package caracteres;

import java.util.Random;

/**
 *
 * @author HugoGuillin
 */
public class Hilo_Productor implements Runnable{
    
    private Bufer bufer=new Bufer();
    
    public Hilo_Productor(Bufer bufer) {
        this.bufer=bufer;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            bufer.produce();            
        }
    }    
}
