TRABAJO GRUPAL N° 1

Integrantes del grupo: 
  -Aguilar, Oriana
  -Alvarado, Rocío
  -Castellino, Gonzalo
  -Nogueira, Cristian
  -Sotelo, Nadia
  
Decisiones de diseño tomadas:
  Nuestro trabajo consta de dos clases, una denominada "Cancion" que genera las caracteristicas particulares (a traves de sus constructores) de cada objeto, y otra clase Playlist que nos permite meter los objetos Cancion en un arreglo y asi poder manejar las mismas en conjunto, pudiendo realizar aquellos métodos que demandaban una comparacion entre objetos (por ej. los métodos "mayorMenorDuracion", "listaOrdenadaTitulo" y "listaOrdenadaArtista"). Realizamos cuatro metodos "addSong", para poder ingresar distintos tipos y cantidad de datos por parametro, respetandose siempre que esté "titulo" y "duracion" presentes en ellos (los mismos generan un objeto Cancion y llaman a su respectivo constructor). Agregamos dos métodos por fuera de lo pedido para poder complementar el trabajo ("setSize" para poder modificar la cantidad de canciones en la playlist y "getDuracionString" para poder convertir la duracion de una cancion en formato String, así en "eliminarCancion" no sería necesario hacer dos métodos con distintos tipos de datos pasados por parametro). Se utilizó una clase predefinida del paquete Math perteneciente a java.lang, para el método "reproduccionPlaylist" (utilizandose el metodo Math.random, para poder generar numeros aleatorios). 
  En las pruebas JUnit, consideramos necesario en algunos métodos (los de ordenar la playlist) utilizar assertArraysEquals dentro de un for para poder evaluar uno por uno los resultados, ya que de otra forma las comparaciones eran realizadas sobre la dirección de memoria que devolvía el método. Solo en la prueba de "reproduccionPlaylist" se llamó al método para que imprima por pantalla el resultado, todos los demás métodos retornan valores para poder hacer las pruebas automatizadas correctamente.

Descripción de cada archivo *.java comprendido en solución del problema: 
  -Playlist.java contiene la clase Playlist donde se construye un arreglo de objetos Cancion, para poder realizar los diferentes ejercicios con estos.
  -Cancion.java contiene la clase Cancion que construye los objetos del tipo Cancion.
  -PlaylistTest.java contiene la prueba JUnit de la clase Playlist.
  
  Conclusiones:
  
