
package canciones;

/**
 *
 * @author PC
 */
public class Cancion {

    private String titulo;
    private String artista;
    private String album;
    private int duracion;

    public Cancion(String titulo, String album, String artista, int duracion) {
        this.titulo = titulo;
        this.album = album;
        this.artista = artista;
        this.duracion = duracion;
    }

    public Cancion(String titulo, int duracion) {
        this(titulo, "no encontrado", "no encontrado", duracion);
    }

    public Cancion(String titulo, String album, int duracion) {
        this(titulo, album, "no encontrado", duracion);
    }

    public Cancion(String titulo, int duracion, String artista) {
        this(titulo, "no encontrado", artista, duracion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    

}