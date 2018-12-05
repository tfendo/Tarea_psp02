# TAREA PARA PSP02

## Ejercicio 1

Para realizar este ejercicio se crea una clase para el recurso compartido **Bufer** que contiene un array de 6 posiciones, que se va rellenando (siempre y cuando quede espacio libre) con letras generadas por el método ``produce()``. Asimismo, el método ``consume()`` va leyendo letras del bufer y las imprime por consola (siempre y cuando haya letras que leer en el array). A continuacion se crea una clase que representa a cada uno de los hilos de la aplicación, uno que llama 15 veces al método ``produce()`` y otro que hace lo propio con el método ``consume()``. 

No he sido capaz de conseguir que la salida por consola se vea como en la imagen de la tarea, pues se ejecutan las 6 instrucciones del bucle de cada método de forma consecutiva, sin que lleguen a mezclarse unas con otras. Pensé que podía ser del procesador de mi ordenador, pero probé la aplicación en otro pc y la salida es idéntica.

La salida por consola del IDE se puede observar a continuación:

![captura Productor_Consumidor](https://github.com/tfendo/tarea_psp02/blob/master/Productor_Consumidor/capturas/Captura%20de%20pantalla%202018-12-02%20a%20las%2018.29.07.png)
