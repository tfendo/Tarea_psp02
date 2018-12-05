package paquetePrincipal;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author HugoGuillin
 */
public class Filosofos extends Thread{
    
    //ID de cada filósofo
    private int id;
    
    //Propiedad que indíca si el filósofo es zurdo o no
    private boolean zurdo;
    
    //Se asigna un semáfora a cada uno de los palillos que cada filósofo puede coger
    private Semaphore izq, der;
    
    /**
     * 
     * @param id ID del filósofo
     * @param izq Palillo izquierdo del filósofo
     * @param der Palillo derecho del filósofo
     * @param zurdo Si uno de los filósofos es zurdo y coge antes el tenedor de su izquierda
     * (al revés que los demás) se evita el bloqueo indefinido que se produce si todos los 
     * filósofos cogen a la vez primero el tenedor de su derecha.
     */
    public Filosofos(int id, Semaphore izq, Semaphore der, boolean zurdo) {
        this.id = id;
        this.izq=izq;
        this.der=der;
        this.zurdo=zurdo;
    }
    
    
    
    @Override
    public void run() {
        while(true){
            try{
                pensar();
                comer();
            }catch(InterruptedException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Método que se encarga de obtener los dos palillos para cada filósofo, para 
     * que así este pueda comer. 
     * @throws InterruptedException 
     */
    public void comer() throws InterruptedException{
        if(zurdo){
            izq.acquire();
            if(der.tryAcquire()){//Si el filósofo coge el segundo palillo, quiere decir que ya puede comer
                System.out.println("Filósofo "+id+" está comiendo");
                
            }else{//Si no puede coger el segundo palillo tendrá que seguir intentándolo hasta que lo consiga
                System.out.println("Filósofo "+id+" está hambriento");                
            }
        }else{
            der.acquire();
            if(izq.tryAcquire()){//Si el filósofo coge el segundo palillo, quiere decir que ya puede comer
                System.out.println("Filósofo "+id+" está comiendo");
            }else //Si no puede coger el segundo palillo tendrá que seguir intentándolo hasta que lo consiga
                System.out.println("Filósofo "+id+" está hambriento");
        }
        
        //Se duerme el hilo para simular el tiempo que un filósofo tarda en comer
        sleep(new Random().nextInt(1000));
        
        calculaPalillos(id);
        
        //Una vez que el filósofo acaba de comer, libera los palillos
        izq.release();
        der.release();
            
    }
    
    /**
     * Método que simula que un filósofo está pensando, para que otros puedan coger dos palillos y comer
     * @throws InterruptedException 
     */
    public void pensar() throws InterruptedException{
        System.out.println("Filósofo "+id+" está pensando.");
        
        //Se duerme el hilo para simular el tiempo que un filósofo pasa pensando
        sleep(new Random().nextInt(1000));
    }
    
    /**
     * Calcula los números de palillo que le corresponden a cada filósofo.
     * @param id ID del filósofo del que se van a calcular sus números de palillo
     */
    private void calculaPalillos(int id){
        int palillo_Derecho, palillo_Izquierdo;
        palillo_Izquierdo=id;

        if(id==0){
            palillo_Derecho=4;
        }else{
            palillo_Derecho=id-1;
        }           
        System.out.println("Filósofo "+id+" termina de comer. Libres palillos "+palillo_Derecho+" y "
        +palillo_Izquierdo);
    }
    
}
