# Trabajo-Practico-Poo
Trabajo Grupal De Programación Orientada a Objetos
TRABAJO GRUPAL N°1
Integrantes del grupo: 
-Aguilar, Oriana 
-Alvarado, Rocío 
-Castellino, Gonzalo
-Nogueira, Cristian

Introducción:
En el presente informe se tiene como objetivo final exponer, justificar y explicar las decisiones tomadas a la hora de realizar el trabajo grupal adjunto. 
Se procederá a describir cada uno de los métodos utilizados y finalmente se presentará una síntesis de cómo, a través del conocimiento del paradigma de la 
programación orientada a objetos y el trabajo en equipo, es posible facilitar la realización de diversas tareas aumentando el aprendizaje a través del intercambio
de conocimientos entre unos y otros.

Decisiones de diseño tomadas: 
Nuestro trabajo consta de dos clases, una denominada "Cancion" la cual genera las características particulares de cada objeto (a través de sus constructores), y otra 
clase llamada Playlist que permite meter los objetos Cancion en un arreglo y así poder manejar las mismas en conjunto, permitiendo de esta forma realizar aquellos métodos
que demandan una comparación entre objetos (por ej. los métodos "mayorMenorDuracion", "listaOrdenadaTitulo" y "listaOrdenadaArtista"). 
Se realizaron cuatro métodos "addSong" para poder ingresar distintos tipos y cantidad de datos por parámetro, respetándose siempre que esté "titulo" y "duración" presentes 
en ellos, ya que los mismos generan un objeto Cancion y llaman a su respectivo constructor. Se decidió agregar dos métodos por fuera de lo pedido para poder complementar el 
trabajo ("setSize" para poder modificar la cantidad de canciones en la playlist y "getDuracionString" para poder convertir la duración de una canción en formato String, así en 
"eliminarCancion" no sería necesario hacer dos métodos con distintos tipos de datos pasados por parámetro). Se utilizó una clase predefinida del paquete Math perteneciente a 
java.lang, para el método "reproduccionPlaylist" (empleándose el método Math.random, para poder generar números aleatorios). 
En las pruebas JUnit, se consideró necesario en algunos métodos (los de ordenar la playlist) utilizar assertArraysEquals dentro de un for para poder evaluar uno por uno los
resultados, ya que de otra forma las comparaciones eran realizadas sobre la dirección de memoria que devolvía el método. Solo en la prueba de "reproduccionPlaylist" se llamó 
al método para que imprima por pantalla el resultado, todos los demás métodos retornan valores para poder hacer las pruebas automatizadas correctamente.
Descripción de cada archivo *.java comprendido en solución del problema: -Playlist.java contiene la clase Playlist donde se construye un arreglo de objetos Cancion, para poder 
realizar los diferentes ejercicios con estos. -Cancion.java contiene la clase Cancion que construye los objetos del tipo Cancion. -PlaylistTest.java contiene la prueba JUnit de 
la clase Playlist.

Conclusiones:
A forma de conclusión y análisis general de lo expuesto previamente, es posible afirmar que al programar orientado a objetos es necesario aprender a pensar cómo resolver los 
problemas de una manera distinta a como se realizaba anteriormente, en la programación estructurada. Esta forma de trabajo nos facilito la reutilización de código en distintas 
partes del programa y en adición, gracias a las pruebas unitarias, fue posible dividir el problema en partes más pequeñas con el fin de probarlas de manera independiente y 
aislar de forma más fácil los posibles errores que puedan surgir.
Finalmente con respecto al trabajo en equipo, se aportaron diferentes soluciones y puntos de vista con respecto al mismo problema facilitando así la comprensión y resolución 
del mismo. Se permitió una comprensión más total y más global de las situaciones-problema, y se facilitó también la realización de una acción integrada. 

