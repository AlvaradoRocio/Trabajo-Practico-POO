package playlist;

public class Main {
	public static void main(String[] args) {
		Playlist p = new Playlist(); 
		p.addSong("alabado", 5);
		p.addSong("Diosito", 500, "Ayudame porfitas");
		p.addSong("Cordero de dios","a", 5000);
		p.addSong("funcionaaaaa", "a", 20);
		p.addSong("alabado", "c", 340);	
		p.addSong("alabado", "aaa", "a", 3605);	
		//p.listaOrdenadaTitulo();
		System.out.println("Cantidad de canciones: "+ p.getSize());
		p.eliminarCancion("alabado");
		System.out.println("Cantidad de canciones: "+ p.getSize());
		p.listaOrdenadaTitulo();
		//System.out.println("Cantidad de canciones: "+ p.getSize());
		//p.eliminarCancion("diosito");
		System.out.println("Cantidad de canciones: "+ p.getSize());
		//p.duracionCancion("alabado");
		System.out.println("Duracion completa de la playlist: " + p.duracionPlaylist());
		System.out.println(p.mayorMenorduracion());
		//p.listaOrdenadaArtista();
		p.reproducirPlaylist();
	}
}
