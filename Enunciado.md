Objetivo
Este ejercicio consiste en simular la gestión de un parking concurrido.
Escenario
El sistema debe simular un parking con un número N de plazas (configurable) y un
número M de coches (configurable, p.ej., M > N).
● Cada coche debe ser un hilo independiente.
● El parking es el recurso compartido que todos los hilos "coche" intentan
usar.
Requisitos
● Entrada Controlada: El parking tiene un "dispositivo de control" de entrada.
Un coche solo puede entrar si hay plazas libres. Si el parking está lleno, los
coches que intentan entrar deben esperar a que una plaza quede disponible.
● Gestión de Plazas: Cuando un coche entra, se le asigna una plaza libre
(debes gestionar qué plazas están libres u ocupadas).
● Salida y Notificación: Cuando un coche sale del parking, libera su plaza.
Esta acción debe notificar al control de entrada para que un coche que esté
esperando (si hay alguno) pueda ocupar la plaza recién liberada.
● Ciclo Continuo: Los coches están en un bucle infinito :
○ Intentan entrar al parking.
○ Una vez dentro, simulan estar aparcados (esperando un tiempo
aleatorio).
○ Salen del parking.
○ Simulan estar fuera (esperando otro tiempo aleatorio) antes de volver
a intentar entrar .
Ejemplo de salida:
ENTRADA: Coche 1 aparca en 0.
Plazas libres: 4
Parking: [1] [0] [0] [0] [0]
ENTRADA: Coche 2 aparca en 1.
Plazas libres: 3
Parking: [1] [2] [0] [0] [0]
ENTRADA: Coche 3 aparca en 2.
Plazas libres: 2
Parking: [1] [2] [3] [0] [0]
ENTRADA: Coche 4 aparca en 3.
Plazas libres: 1
Parking: [1] [2] [3] [4] [0]
ENTRADA: Coche 5 aparca en 4.
Plazas libres: 0
Parking: [1] [2] [3] [4] [5]
SALIDA: Coche 2 saliendo.
Plazas libres: 1
Parking: [1] [0] [3] [4] [5]
ENTRADA: Coche 6 aparca en 1.
Plazas libres: 0
Parking: [1] [6] [3] [4] [5]
Pista:
Pensad en el Parking como el 'Almacén' de los apuntes . Los coches son
'Productores' (de plazas ocupadas) y 'Consumidores' (de plazas ocupadas) a la vez.
Bonus:
Podéis ir más allá del ejercicio y añadir características que consideréis interesantes.
Entregable:
Repositorio en Github.