package playlist;

import static org.junit.Assert.*;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlaylist {
	private Playlist p = new Playlist();
	@Before
	public void setUp() throws Exception {
		p.addSong("alabado", 5);
		p.addSong("Diosito", 500, "Ayudame porfitas");
		p.addSong("Cordero de dios","a", 5000);
		p.addSong("funcionaaaaa", "a", 20);
		p.addSong("la cucaracha", "c", 340);	
		p.addSong("alabado", "aaa", "a", 3605);	
	}
	@Test
	public void addSongtest() {
		this.p.addSong("diosito", "ayudame", "porfitas", 5);
		int expected = 7;
		int actual = this.p.getSize();
		assertEquals(expected, actual);
	}
	@Test
	public void deleteSongtest() {
		this.p.deleteSong("alabado");
		int expected = 5;
		int actual = this.p.getSize();
		assertEquals(expected, actual);
	}
	@Test
	public void consultarCantidadtest() { 		
		int expected = 6;
		int actual = this.p.getSize();
		assertEquals(expected, actual);
	}
	@Test
	public void FailduracionCanciontest() {
		String expected= "-1";
		String actual= this.p.duracionCancion("CancionNoExistente");
		assertEquals(expected, actual);
	}
	@Test
	public void duracionCanciontest() {
		String expected= "1. Duracion de la cancion alabado: 00:05\n2. Duracion de la cancion alabado: 01:00:05\n";
		String actual= this.p.duracionCancion("alabado");
		assertEquals(expected, actual);
	}
	@Test
	public void duracionPlaylisttest() {
		String expected = "02:37:50";
		String actual = this.p.duracionPlaylist();
		assertEquals(expected, actual);
	}
	@Test
	public void mayorMenortest() {
		String expected = "Cancion de menor duracion: alabado --> 00:05\nCancion de mayor duracion: Cordero de dios --> 01:23:20";
		String actual = this.p.mayorMenorduracion();
		assertEquals(expected, actual);
	}
	@Test
	public void listaOrdenadaArtistatest() {
		int i;	
		Song expected[] = new Song[6];
		expected[4]= new Song ("alabado", 5);
		expected[0]= new Song ("alabado", "aaa", "a", 3605);
		expected[1]= new Song ("Cordero de dios","a", 5000);
		expected[5]= new Song ("Diosito", 500, "Ayudame porfitas");
		expected[2]= new Song ("funcionaaaaa", "a", 20);
		expected[3]= new Song ("la cucaracha", "c", 340);	
		Song actual[] = this.p.listaOrdenadaArtista();
		
		for(i=0; i<6; i++) {
			assertEquals(expected[i].getArt(), actual[i].getArt());
			assertEquals(expected[i].getTitle(), actual[i].getTitle());
		}	
		
	}
	@Test
	public void listaOrdenadaTitulotest() {
		int i;	
		Song actual[] = this.p.listaOrdenadaTitulo();
		Song expected[] = new Song[6];
		expected[0]= new Song ("alabado", 5);
		expected[1]= new Song ("alabado", "aaa", "a", 3605);
		expected[2]= new Song ("Cordero de dios","a", 5000);
		expected[3]= new Song ("Diosito", 500, "Ayudame porfitas");
		expected[4]= new Song ("funcionaaaaa", "a", 20);
		expected[5]= new Song ("la cucaracha", "c", 340);	
		
		for(i=0; i<6; i++) {
			assertEquals(expected[i].getTitle(), actual[i].getTitle());
		}	
	}
	
}
