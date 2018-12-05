# TAREA PARA PSP02

## Ejercicio 2

Para realizar este ejercicio se crea la clase **Filósofos**, de la que se van a crear los hilos que representen a los filósofos comiendo y pensando. Por defecto, todos los filósofos cuando van a coger un palillo, primero cogen el de su derecha. Se puede dar el caso que todos los hilos cogiesen el palillo de la derecha antes de ninguno consiga coger el de su izquierda, lo que produciría un bloqueo indefinido. Para evitar eso, a un hilo se le aplica la condición de zurdo y coge primero el palillo de su izquierda, por lo que el problema del bloqueo indefinido quedaría solucionado. Para controlar los palillos que le corresponden a cada filósofo se utiliza un array de **Semaphore**, uno por cada palillo disponible.

A cada filósofo se le añaden dos funciones, ``pensar()`` y ``comer()``. Se duermen los hilos en cada una de estas funciones para simular dichas acciones y que los demas hilos puedan ejecutarse mientras. Para la función ``comer()`` se controla si el filósofo puede coger los dos palillos para comer, sino se indica que está hambriento y que tiene que seguir esperando para coger sus palillos.

Para informar de los palillos que tiene asociado cada filósofo, se utiliza el método ``calculaPalillos(int id)``. 

En la clase principal, una vez generados los semáforos para los palillos, primero se crea un primer filósofo para asignarle manualmente sus parámetros, ya que el palillo derecho del primer hilo no sigue un orden lógico, y el resto se crean dentro de un bucle **for** para agilizar el proceso.

En la siguiente captura se puede apreciar el correcto funcionamiento de la aplicación:

![captura OrdenarNumeros](https://github.com/tfendo/psp01/blob/master/Actividad_1/capturas/Captura_1.png)  

También probé a crear un total de 15 hilos, para asegurarme de que no se producía ningún problema de concurrencia.

![captura OrdenarNumeros](https://github.com/tfendo/tarea_psp02/blob/master/Filosofos/capturas/Captura%20de%20pantalla%202018-12-02%20a%20las%2017.25.37.png)  
