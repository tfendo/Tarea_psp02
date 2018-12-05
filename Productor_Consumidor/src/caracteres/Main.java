
package caracteres;

/**
 *
 * @author HugoGuillin
 */
public class Main {
    public static void main(String[] args) {
        
        Bufer bufer=new Bufer();
        Thread hilo_productor=new Thread(new Hilo_Productor(bufer));
        Thread hilo_consumidor=new Thread(new Hilo_Consumidor(bufer));
        
        hilo_productor.start();
        hilo_consumidor.start();
    }
}
