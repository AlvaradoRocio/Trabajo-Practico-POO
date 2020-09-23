
package canciones;

/**
 *
 * @author Aguilar, Alvarado, Castellino, Nogueira, Sotelo.
 */

public class Cancion {


    private String titulo;
    private String art;
    private String album;
    private int dur;

    public Cancion(String titulo, String art, String album, int dur) {
        this.titulo = titulo;
        this.art = art;
        this.album = album;
        this.dur = dur;
    }

    public Cancion(String titulo, int dur) {
        this(titulo, "no encontrado", "no encontrado", dur);
    }

    public Cancion(String titulo, int dur, String album) {
        this(titulo, album, "no encontrado", dur);
    }

    public Cancion(String titulo, String art, int dur) {
        this(titulo, "no encontrado", art, dur);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArt() {
        return art;
    }

    public String getAlbum() {
        return album;
    }

    public int getDur() {
        return dur;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

}    

