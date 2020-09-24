package Playlist;

public class Main {
	public static void main(String[] args) {
		Playlist Cumbia = new Playlist();
		
		Cumbia.agregarCancion("AGUSTIN" , "lulil", 180);
		Cumbia.agregarCancion("AGUSTIN" , "lulel", 180);
		Cumbia.agregarCancion("AGUSTIN" , "lulal", 180);
		Cumbia.agregarCancion("GONZALITO", "LOL", 300);
		Cumbia.agregarCancion("CRISTIAN", 500);
		Cumbia.agregarCancion("ROCIO" , 300);

		
		Cumbia.metodoMostrar();

		
		
		System.out.println("Cantidad de canciones:" +Cumbia.consultarCantidadCanciones());
		
		Cumbia.consultarDuracionPlaylist();
		
		System.out.println("" +Cumbia.consultarDuracion("AGUSTIN"));
		
		
		System.out.println(Cumbia.cancionMayorDuracion());
		System.out.println(Cumbia.cancionMenorDuracion()+"\n\n");
		
		
		Cumbia.listaOrdenadaTitulo();
		
		
		
		
		
	}

}
