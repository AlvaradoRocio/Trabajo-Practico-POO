/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canciones;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class PlayListTest {

    PlayList nueva;

    public PlayListTest() {
    }

    @Before
    public void setUp() {
        nueva = new PlayList();
        nueva.agregarCancion("Baby one more time", 200);
        nueva.agregarCancion("Hello", 222, "Adele");
        nueva.agregarCancion("4 minutes", "Madonna y Justin Timberlake", "Madonna", 240);
        nueva.agregarCancion("Maria", 120, "Ricky Martin");
        nueva.agregarCancion("La tortura", 211, "Shakira");
        nueva.agregarCancion("Heart attack", 118, "Me");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetDuracionString() {
        String esperado = "03:42";
        String actual = nueva.getDuracionString(222);
        assertEquals(esperado, actual);
    }

    @Test
    public void testAgregarCancion_String_int() {
        nueva.agregarCancion("Hola", 1222);
        nueva.agregarCancion("Hello", "Adele", 120);
        int esperado = 2;
        int actual = nueva.getCantidadCancion();
        assertEquals(esperado, actual);

    }

    @Test
    public void testConsultarDuracion() {
        String[] esperado = {"03:20"};
        String[] actual = nueva.consultarDuracion("Baby one more time");
        assertArrayEquals(esperado, actual);
    }

    @Test
    public void testEliminarCancion_String() {
      
        nueva.eliminarCancion("Heart attack");

        int esperado = 5;
        int actual = nueva.getCantidadCancion();
        assertEquals(esperado, actual);
    }

    /*@Test
   public void testEliminarCancion_int() {
        nueva.agregarCancion("Baby one more time", 200);
        nueva.agregarCancion("Hello", "Adele", 222);
        nueva.agregarCancion("4 minutes", "Madonna y Justin Timberlake", "Madonna",240);
        nueva.agregarCancion("Maria","Ricky Martin", 120);
        nueva.agregarCancion("La tortura", "Shakira",211);
        nueva.agregarCancion("Heart attack", 118, "Me");
        nueva.eliminarCancion(200);
        nueva.eliminarCancion(120);
       
        int esperado= 4;
        int actual=nueva.consultarCantidadCancion();
        assertEquals(esperado, actual);
    }*/
    @Test
    public void testConsultarDuracionPlaylist() {
      
        String esperado = "18:31";
        String actual = nueva.consultarDuracionPlaylist();
        assertEquals(esperado, actual);
    }

    @Test
    public void testConsultarCantidadCancion() {
     
        int esperado = 6;
        int actual = nueva.getCantidadCancion();
        assertEquals(esperado, actual);
    }

    @Test
    public void testCancionMayorDuracion() {
        
        String esperado = "04:00";
        String actual = nueva.cancionMayorDuracion();
        assertEquals(esperado, actual);
    }

    @Test
    public void testmenorDuracion() {

        nueva.agregarCancion("Baby one more time", 200);
        nueva.agregarCancion("Hello", "Adele", 222);
        nueva.agregarCancion("4 minutes", "Madonna y Justin Timberlake", "Madonna", 240);
        nueva.agregarCancion("Maria", "Ricky Martin", 120);
        nueva.agregarCancion("La tortura", "Shakira", 211);
        nueva.agregarCancion("Heart attack", 118, "Me");
        Cancion esperada = new Cancion("Heart attack", 118, "Me");
        Cancion actual= nueva.menorDuracion();
        assertEquals(esperada.getDuracion(), actual.getDuracion());
    }

    @Test
    public void testOrdenadaTitulo() {
        nueva.agregarCancion("Baby one more time", 200);
        nueva.agregarCancion("Hello", 222, "Adele");
        nueva.agregarCancion("Four minutes", "Madonna y Justin Timberlake", "Madonna", 240);
        nueva.agregarCancion("Maria", 120, "Ricky Martin");
        nueva.agregarCancion("La tortura", 211, "Shakira");
        nueva.agregarCancion("Heart attack", 118, "Me");
        Cancion[] comparativa = new Cancion[6];
        comparativa[0] = new Cancion("Baby one more time", 200);
        comparativa[1] = new Cancion("Four minutes", "Madonna y Justin Timberlake", "Madonna", 240);
        comparativa[2] = new Cancion("Heart attack", 118, "Me");
        comparativa[3] =new Cancion("Hello", 222, "Adele");
        comparativa[4] = new Cancion("La tortura", 211, "Shakira");
        comparativa[5] = new Cancion("Maria", 120, "Ricky Martin");
        Cancion[] actual= nueva.ordenadaTitulo();
        String []actualTit = new String[6];
        for(int i=0; i<6; i++){
           assertEquals(actual[i].getTitulo(), comparativa[i].getTitulo());
           assertEquals(actual[i].getAlbum(), comparativa[i].getAlbum());
        }
        
    }

    @Test
    public void testOrdenArtista() {
        nueva.agregarCancion("Baby one more time",200);
        nueva.agregarCancion("america", 120, "Adele");
        nueva.agregarCancion("Hello", 222, "Adele");
        nueva.agregarCancion("Four minutes", "Madonna y Justin Timberlake", "Madonna", 240);
        nueva.agregarCancion("Maria", 120, "Ricky Martin");
        nueva.agregarCancion("La tortura", 211, "Shakira");
        nueva.agregarCancion("Heart attack", 118, "Me");
        Cancion[] actual= nueva.ordenArtista();
        actual[0].getTitulo();
        Cancion[] esperada= new Cancion[7];
        esperada[0]= new Cancion("america", 120, "Adele");
        esperada[1]=new Cancion("Hello", 222,"Adele");
        esperada[2]=new Cancion("Four minutes","Madonna y Justin Timberlake", "Madonna", 240);
        esperada[3]=new Cancion("Heart attack", 118, "Me");
        esperada[4]=new Cancion("Baby one more time", 200);
        esperada[5]=new Cancion("Maria", 120, "Ricky Martin");
        esperada[6]=new Cancion("La tortura", 211, "Shakira");
      
       
        for(int i=0; i<7; i++){
            assertEquals(esperada[i].getArtista(), actual[i].getArtista());
            assertEquals(esperada[i].getTitulo(), esperada[i].getTitulo());
            
        }
        
        
    }

    @Test
    public void testPlay() {
    }

}
