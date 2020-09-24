package Playlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaylistTest {

	Playlist repro;
	@Before
	public void setUp() {
		repro = new Playlist();
		repro.agregarCancion("lol", 500);
		repro.agregarCancion("lul", 300, "los gonzaleros");
		repro.agregarCancion("lal", "los gonzalitos", "Chio",200);
		repro.agregarCancion("lil", "Los gonzajas", "Gonzalo", 322);
		repro.agregarCancion("luul", "Los gonzajas", "Cristian", 100);
	}
	
	@Test
	public void testAgregarCancion() {
		repro.agregarCancion("lool", 120);
		repro.agregarCancion("luul", 123, "los gonzaleros");
		int esperado = 7;
		int actual = repro.consultarCantidadCanciones();
		assertEquals(esperado, actual);
	}
	
	@Test
	public void testConsultarCantidadCanciones() {
		int esperado = 5;
		int actual = repro.consultarCantidadCanciones();
		assertEquals(esperado, actual);
	}
	
	@Test
	public void testConsultarDuracionPlaylist() {
		int esperado = 1422;
		int actual = repro.consultarDuracionPlaylist();
		assertEquals(esperado, actual);
	}
	
	@Test
	public void testMayorDuracion() {
		String actual = "lol";
		String esperado = repro.cancionMayorDuracion();
		assertEquals(esperado, actual);
				
		
	}
	
	@Test
	public void testMenorDuracion() {
		String actual = "luul";
		String esperado = repro.cancionMenorDuracion();
		assertEquals(esperado, actual);
				
		
	}
	
	@Test
	public void testOrdenarTitulos() {
		String actual[] = {"lal", "lil" , "lol" , "lul", "luul"};
		String esperado[] = repro.listaOrdenadaTitulo();
		assertArrayEquals(esperado, actual);
	}
	
	@Test
	public void testOrdenarArtistas() {
	}
	
	@Test
	public void testConsultarDuracion() {
		
	}
	
}
