/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canciones;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class PlayListTest {
    Playlist nueva;
    public PlayListTest() {
    }
    
    
    @Before
    public void setUp() {
        nueva = new Playlist();
        nueva.addSong("Baby one more time", 200);
        nueva.addSong("Hello", 222, "Adele");
        nueva.addSong("Four minutes", "Madonna y Justin Timberlake", "Madonna", 240);
        nueva.addSong("Hello", 120, "Ricky Martin");
        nueva.addSong("La tortura", 211, "Shakira");
        nueva.addSong("Heart attack", 118, "Me");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddSong_String_int() {
        nueva.addSong("Hola", 1222);
        nueva.addSong("Hello", "Adele", 120);
        int esperado = 8;
        int actual = nueva.getSize();
        assertEquals(esperado, actual);
    }

    
    @Test
    public void testGetSize() {
        int esperado = 6;
        int actual = nueva.getSize();
        assertEquals(esperado, actual);
    }


    @Test
    public void testEliminarCancion() {
        nueva.eliminarCancion("Hello");

        int esperado = 4;
        int actual = nueva.getSize();
        assertEquals(esperado, actual);
    }

    @Test
    public void testDuracionCancion() {
        
        nueva.eliminarCancion("Hello");

        int esperado = 4;
        int actual = nueva.getSize();
        assertEquals(esperado, actual);
       
    }

    @Test
    public void testDuracionPlaylist() {
        String esperado = "18:31";
        String actual = nueva.duracionPlaylist();
        assertEquals(esperado, actual);
    }

    @Test
    public void testMayorMenorduracion() {
        
        String[] esperado= {"Heart attack", "Four minutes"};
        String[] actual = nueva.mayorMenorduracion();
        assertArrayEquals(esperado, actual);
    }

    @Test
    public void testListaOrdenadaArtista() {
       
        Cancion[] actual= nueva.listaOrdenadaArtista();
        Cancion[] esperada= new Cancion[6];
       
        esperada[0]=new Cancion("Hello", 222,"Adele");
        esperada[1]=new Cancion("Four minutes", "Madonna y Justin Timberlake","Madonna", 240);
        esperada[2]=new Cancion("Heart attack", 118, "Me");
        esperada[3]=new Cancion("Baby one more time", 200);
        esperada[4]=new Cancion("Hello", 120, "Ricky Martin");
        esperada[5]=new Cancion("La tortura", 211, "Shakira");    
        
       for(int i=0; i<6; i++){
           assertEquals(actual[i].getArt(), esperada[i].getArt());
           assertEquals(actual[i].getTitulo(), esperada[i].getTitulo());
          
        }   
    }

    @Test
    public void testListaOrdenadaTitulo() {
        Cancion[] comparativa = new Cancion[6];
        comparativa[0] = new Cancion("Baby one more time", 200);
        comparativa[1] = new Cancion("Four minutes", "Madonna", "Madonna y Justin Timberlake", 240);
        comparativa[2] = new Cancion("Heart attack", 118, "Me");
        comparativa[3] =new Cancion("Hello", 222, "Adele");
        comparativa[4] = new Cancion("Hello", 120, "Ricky Martin");
        comparativa[5] = new Cancion("La tortura", 211, "Shakira");
        
        Cancion[] actual= nueva.listaOrdenadaTitulo();
        String []actualTit = new String[6];
        for(int i=0; i<6; i++){
           assertEquals(actual[i].getTitulo(), comparativa[i].getTitulo());
           
        }
    }

    @Test
    public void testReproducirPlaylist() {
        nueva.reproducirPlaylist();
    }

    @Test
    public void testGetDuracionString() {
        String esperado = "03:42";
        String actual = nueva.getDuracionString(222);
        assertEquals(esperado, actual);
    }
    
}