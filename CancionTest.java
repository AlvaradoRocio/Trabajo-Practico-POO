
package canciones;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class CancionTest {
    Cancion miCancion;
    public CancionTest() {
    }
    
    @Before
    public void setUp() {
        miCancion= new Cancion("I wanna dance", 122);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetTitulo() {
        String esperado= "I wanna dance";
        String actual= miCancion.getTitulo();
        assertEquals(esperado, actual);
    }

    @Test
    public void testGetArtista() {
        String esperado= "no encontrado";
        String actual= miCancion.getArtista();
        assertEquals(esperado, actual);
    }

    @Test
    public void testGetAlbum() {
        String esperado= "no encontrado";
        String actual= miCancion.getAlbum();
        assertEquals(esperado, actual);
    }

    @Test
    public void testGetDuracion() {
        int esperado= 122;
        int actual= miCancion.getDuracion();
        assertEquals(esperado, actual);
    }
    
}
