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
		this.p.eliminarCancion("alabado");
		int expected = 4;
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
		int[] expected= {-1};
		int[] actual= this.p.duracionCancion("CancionNoExistente");
		assertEquals(expected[0], actual[0]);
	}
	@Test
	public void duracionCanciontest() {
		int[]expected= new int[2] ;
		expected[0]= 5;
		expected[1]=3605;
		int[] actual= this.p.duracionCancion("alabado");		
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);
	}
	@Test
	public void duracionPlaylisttest() {
		int expected = 9470;
		int actual = this.p.duracionPlaylist();
		assertEquals(expected, actual);
	}
	@Test
	public void mayorMenortest() {
		String[] expected = new String[2];
		expected[0]="alabado";
		expected[1]="Cordero de dios";
		String str = this.p.mayorMenorduracion();
		String[] actual = str.split(" -");	
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);
	}
	@Test
	public void listaOrdenadaArtistatest() {
		int i;	
		Cancion expected[] = new Cancion[6];
		expected[4]= new Cancion ("alabado", 5);
		expected[0]= new Cancion ("alabado", "aaa", "a", 3605);
		expected[1]= new Cancion ("Cordero de dios","a", 5000);
		expected[5]= new Cancion ("Diosito", 500, "Ayudame porfitas");
		expected[2]= new Cancion ("funcionaaaaa", "a", 20);
		expected[3]= new Cancion ("la cucaracha", "c", 340);	
		Cancion actual[] = this.p.listaOrdenadaArtista();
		
		for(i=0; i<6; i++) {
			assertEquals(expected[i].getArt(), actual[i].getArt());
			assertEquals(expected[i].getTitulo(), actual[i].getTitulo());
		}	
		
	}
	@Test
	public void listaOrdenadaTitulotest() {
		int i;	
		Cancion actual[] = this.p.listaOrdenadaTitulo();
		Cancion expected[] = new Cancion[6];
		expected[0]= new Cancion ("alabado", 5);
		expected[1]= new Cancion ("alabado", "aaa", "a", 3605);
		expected[2]= new Cancion ("Cordero de dios","a", 5000);
		expected[3]= new Cancion ("Diosito", 500, "Ayudame porfitas");
		expected[4]= new Cancion ("funcionaaaaa", "a", 20);
		expected[5]= new Cancion ("la cucaracha", "c", 340);	
		
		for(i=0; i<6; i++) {
			assertEquals(expected[i].getTitulo(), actual[i].getTitulo());
		}	
	}
	
}