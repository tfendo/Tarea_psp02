package caracteres;

/**
 *
 * @author HugoGuillin
 */
public class Bufer {
    private char letra='A';
    private char[] array=new char[6];
    private boolean vacio=true, lleno=false;
    private int indice=0;
    
    /**
     * Método que se encarga de controlar si el array tiene espacio libre,
     * y en ese caso genera una letra y la introduce en el array. Si el array
     * se llena, el método envía un aviso al hilo para ponerlo en espera hasta
     * que vuelva a haber espacio libre en el array.
     */
    public synchronized void produce(){
        if(lleno){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        array[indice]=letra++;
        vacio=false;
        System.out.println("Depositado el carácter "+array[indice]+" en el buffer");
        indice++;
        if(indice==6){
            lleno=true;
        }
        
        notify();
    }
    
    /**
     * Método que se encarga de leer las letras generadas por el método <code>produce()</code>
     * Si el bufer está vacio, se envía una notificación al hilo para ponerlo en espera hasta
     * que vuelva a haber letras que leer
     */
    public synchronized void consume(){
        if(vacio){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        indice--;
        
        System.out.println("Recogiendo el carácter "+array[indice]+" del buffer");
        
        if(indice==0){
            vacio=true;
        }                
        
        lleno=false;
        
        notify();
    }
}
