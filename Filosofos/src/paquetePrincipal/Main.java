package paquetePrincipal;

import java.util.concurrent.Semaphore;

/**
 *
 * @author HugoGuillin
 */
public class Main {
    public static void main(String[] args) {
        
        //Se crea un array que contendrá un semáforo para cada palillo.
        Semaphore[] palillos=new Semaphore[5];
        
        //Se rellena el array asignando un semáforo por palillo
        for (int i = 0; i < palillos.length; i++) {
            palillos[i]=new Semaphore(1);
        }
        
        /*Se crea el primer filósofo fuera del bucle para asignar 
        * correctamente el índice del semaforo del palillo derecho e 
        * indicar que este primer filósofo es zurdo*/
        (new Filosofos(0, palillos[0], palillos[4], true)).start();
        
        //Se generan el resto de filósofos
        for (int i = 1; i < 5; i++) {
            (new Filosofos(i, palillos[i], palillos[i-1], false)).start();
        }
    }
}
