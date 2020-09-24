package Playlist;

public class Canciones {
	private String titulo; 
	private String album;
	private int duracion;
	private String artista;
	
	//METODOS CONSTRUCTORES
	public Canciones(String titulo, int duracion) {
		this.setTitulo(titulo);
		this.setDuracion(duracion);
		this.setAlbum("Desconocido");
		this.setArtista("Desconocido");
	}
	
	public Canciones(String titulo, String album, int duracion) {
		this.setTitulo(titulo);
		this.setAlbum(album);
		this.setDuracion(duracion);
		this.setArtista("Desconocido");
		
	}
	public Canciones(String titulo, int duracion , String album) {
		this.setTitulo(titulo);
		this.setArtista(artista);
		this.setDuracion(duracion);
		this.setAlbum("Desconocido");
		
	}
	public Canciones(String titulo, String album, String artista, int duracion) {
		this.setTitulo(titulo);
		this.setAlbum(album);
		this.setArtista(artista);
		this.setDuracion(duracion);
		
		
	}
	
	

	//SETTERS AND GETTERS
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	
	
}
